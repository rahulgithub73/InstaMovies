package org.cod.controllers;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebFilter(urlPatterns = { "/paginationIndex/*","/paginationMovies/*","/paginationSeries/*","/paginationMusic/*","/paginationBooks/*","/trainTimeTable/*","/trainRunningInfo/*","/movieDetailPage/*","/subSeries/*","/seriesDetailPage/*","/musicDetailPage/*"})
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig config) throws ServletException {
		// If you have any <init-param> in web.xml, then you could get them
		// here by config.getInitParameter("name") and assign it as field.
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("mobile") == null) {
			
			response.sendRedirect("/"); // No logged-in user found, so redirect to login
															// page.
		} else {
			chain.doFilter(req, res); // Logged-in user found, so just continue request.
		}
	}

	@Override
	public void destroy() {
		// If you have assigned any expensive resources as field of
		// this Filter class, then you could clean/close them here.
	}

}
