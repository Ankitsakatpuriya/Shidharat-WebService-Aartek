package com.hyringspree.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Dateutills {

	public static String generateIdFormat() {
		LocalDateTime now1 = LocalDateTime.now();
		String format3 = now1.format(DateTimeFormatter.ofPattern("yyMMdd", Locale.ENGLISH));
		System.out.println(format3);
		return format3;
	}
	
	public static String generateCurrentDate() {
		LocalDateTime now1 = LocalDateTime.now();
		String format3 = now1.format(DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH));
		System.out.println(format3);
		return format3;
	}

	public static void main(String[] args) {
		generateIdFormat();
		
	}

}
