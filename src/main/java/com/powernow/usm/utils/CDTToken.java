package com.powernow.usm.utils;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;

public class CDTToken {
	
	/**
	 * 生成Token Token：Nv6RRuGEVvmGjB+jimI/gw==
	 *
	 * @return
	 */
	public static String makeToken() { 
		String random = new Random().nextInt(999999999) + "";
		String token = UUID.randomUUID().toString().replaceAll("-", "") + random;
		// 数据指纹 128位长 16个字节 md5
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte md5[] = md.digest(token.getBytes());
			// base64编码--任意二进制编码明文字符 adfsdfsdfsf
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md5);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

}
