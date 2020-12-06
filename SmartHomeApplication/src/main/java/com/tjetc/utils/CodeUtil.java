package com.tjetc.utils;

import java.util.Random;

public class CodeUtil {

	private static char[] cs = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890".toCharArray();
	
	public static String getCode(int len) {
		Random random = new Random();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			builder.append(cs[random.nextInt(cs.length)]);
		}
		return builder.toString();
	}

}
