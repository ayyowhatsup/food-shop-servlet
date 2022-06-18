package com.group3.filter;

import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.http.HttpRequest;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Kiểm tra URL có / ở dưới cùng hay không
 *  có / thì cần xóa /
 */
public class KiemTraURLFilter extends HttpFilter {

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public KiemTraURLFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		String url = req.getRequestURI();
		url = url.replace(req.getContextPath(), "");
		if (url.endsWith("/")) {
			while (url.endsWith("/")) {
				url = url.substring(0, url.length() - 1);
			}
			request.getRequestDispatcher(url).forward(request, response);
		}
		
		else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
