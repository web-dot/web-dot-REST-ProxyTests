package com.estore.application;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		  HttpServletResponse response = (HttpServletResponse) res;
		  HttpServletRequest request = (HttpServletRequest) req;
		  
		  response.setHeader("Access-Control-Allow-Origin", "*");
		  response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		  response.setHeader("Access-Control-Max-Age", "3600");
		  response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, X-Requested-With");
		  chain.doFilter(req, res);
	}
}
