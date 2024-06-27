package com.farmatodo.ticketmanagement.application.utlis;

import java.security.SecureRandom;

public class CodeGeneratorUtils {
	
	 private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	 private static final int LENGTH = 10;
	 private static final SecureRandom random = new SecureRandom();

	 public static String generateRandomString() {
	      StringBuilder stringBuilder = new StringBuilder(LENGTH);
	      for (int i = 0; i < LENGTH; i++) {
	          int index = random.nextInt(CHARACTERS.length());
	          stringBuilder.append(CHARACTERS.charAt(index));
	      }
	      return stringBuilder.toString();
	  }
}
