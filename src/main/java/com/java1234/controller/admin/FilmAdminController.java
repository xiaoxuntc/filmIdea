package com.java1234.controller.admin;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java1234.entity.Film;
import com.java1234.service.FilmService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.java1234.util.DateUtil;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/film")
public class FilmAdminController {

    @Resource
    private FilmService filmService;

    @Value("${imageFilePath}")
    private String imageFilePath;

    /**
     * 添加或者修改电影信息
     *
     * @param film
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    public Map<String, Object> save(Film film, @RequestParam("imageFile") MultipartFile file) throws Exception {
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename(); // 获取文件名
            String suffixName = fileName.substring(fileName.lastIndexOf(".")); // 获取文件的后缀
            String newFileName = DateUtil.getCurrentDateStr() + suffixName;
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(imageFilePath + newFileName));
            film.setImageName(newFileName);
        }
        film.setPublishDate(new Date());
        Map<String, Object> resultMap = new HashMap<String, Object>();
        filmService.save(film);
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 分页查询电影信息
     *
     * @param page
     * @param rows
     * @return
     * @throws Exception
     */
    @RequestMapping("/list")
    public Map<String, Object> list(Film film, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) throws Exception {
        List<Film> filmList = filmService.list(film, page - 1, rows);
        Long total = filmService.getCount(film);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("rows", filmList);
        resultMap.put("total", total);
        return resultMap;
    }

    @RequestMapping("/ckeditorUpload")
    public String ckeditorUpload(@RequestParam("upload") MultipartFile file, String CKEditorFuncNum) throws Exception {
        String fileName = file.getOriginalFilename(); // 获取文件名
        String suffixName = fileName.substring(fileName.lastIndexOf(".")); // 获取文件的后缀
        String newFileName = DateUtil.getCurrentDateStr() + suffixName;
        FileUtils.copyInputStreamToFile(file.getInputStream(), new File(imageFilePath + newFileName));

        StringBuffer sb = new StringBuffer();
        sb.append("<script type=\"text/javascript\">");
        sb.append("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'" + "/static/filmImage/" + newFileName + "','')");
        sb.append("</script>");

        return sb.toString();
    }

    /**
     * 删除电影信息
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete")
    public Map<String, Object> delete(@RequestParam(value = "ids") String ids) throws Exception {
        String[] idsStr = ids.split(",");
        Map<String, Object> resultMap = new HashMap<String, Object>();
        for (int i = 0; i < idsStr.length; i++) {
            filmService.delete(Integer.parseInt(idsStr[i]));
        }
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 根据id查找实体
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/findById")
    public Film findById(Integer id) throws Exception {
        return filmService.findById(id);
    }
}

