package com.hyringspree.filter;

public class MalformedJwtException extends RuntimeException {
	public MalformedJwtException(String message) {
		super(message);
	}
}
