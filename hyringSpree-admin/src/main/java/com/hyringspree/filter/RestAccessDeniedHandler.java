package com.hyringspree.filter;

import static org.apache.commons.httpclient.HttpStatus.SC_FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;


import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * The RestAccessDeniedHandler is called by the ExceptionTranslationFilter to
 * handle all AccessDeniedExceptions. These exceptions are thrown when the
 * authentication is valid but access is not authorized.
 *
 */
public class RestAccessDeniedHandler implements AccessDeniedHandler {

	// @Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		

		final HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(response);
		wrapper.setStatus(SC_FORBIDDEN);
		wrapper.setContentType(APPLICATION_JSON_VALUE);
		wrapper.getWriter().flush();
	}
}
