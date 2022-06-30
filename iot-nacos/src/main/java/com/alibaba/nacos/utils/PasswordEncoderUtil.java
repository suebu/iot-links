package com.alibaba.nacos.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author sue
 */
public class PasswordEncoderUtil {
	public static Boolean matches(String raw, String encoded) {
		return new BCryptPasswordEncoder().matches(raw, encoded);
	}

	public static String encode(String raw) {
		return new BCryptPasswordEncoder().encode(raw);
	}

}
