package com.hyringspree.configuration;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hyringspree.repository.UserRepository;
import com.hyringspree.service.UserService;

@CrossOrigin
@Component
public class ApplicationSecurityIntercepter extends HandlerInterceptorAdapter {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	Set<String> setOfSession = null;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean status = false;
		response.setContentType("application/json");
		String headerToken = request.getHeader("Authorization");
		
		HttpSession session = request.getSession(true);
		String getSessionValue = userService.getSessionValue();
		session.setAttribute("sessionValue", getSessionValue);
		String sessionValue = (String) session.getAttribute("sessionValue");

		if (setOfSession != null) {
			setOfSession.add(sessionValue);
		} else {
			setOfSession = new HashSet<String>();
			setOfSession.add(sessionValue);
		}
		
		// session & token expire in 30 mins
		try{
		session.setMaxInactiveInterval(30 * 60);
		}catch (Exception e) {
			System.out.println("Your session is expired. Please re-login ");
		}
		for (String tokenVal : setOfSession) {
			if (sessionValue != null && sessionValue != "" && headerToken != null && headerToken != "") { 
				// Again manage if condition for equals the value of front-end and session.
				if (tokenVal.equals(headerToken)) {
					status = true;
					return status;
				}
			}
		}
		final PrintWriter printWriter = response.getWriter();
		String errorResponse = userRepository.errorJson();
		printWriter.println(errorResponse);
		response.setHeader("AuthenticationMessageUnSuccess", "User Is  Unauthorized.");
		return status;
	}
}
