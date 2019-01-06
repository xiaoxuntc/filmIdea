/**
 * 
 */
package com.java1234.conf;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author  sean 
 * @date 创建时间：2019年1月6日 下午2:31:39 
 * @version 1.0  
 */
/**
 * <p>Title: MyPasswordEncoder.java</p>  
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: www.sean.com</p> 
 * @author sean
 * @date 2019年1月6日
 * @version 1.0
 */
public class MyPasswordEncoder implements PasswordEncoder {
	public String encode(CharSequence charSequence) {
		return charSequence.toString();
	}

	@Override
	public boolean matches(CharSequence charSequence, String s) {
		return s.equals(charSequence.toString());
	}
}