package com.tjetc.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	
	public static String getMd5(String content) {
		
		//生成一个MD5
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
			digest.update(content.getBytes());
			byte[] bs = digest.digest();
			String result = new BigInteger(1,bs).toString(16);
			return result;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		
		System.out.println(getMd5("123456"));
		System.out.println("ok");
		
	}
	

}
