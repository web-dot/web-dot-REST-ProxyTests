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
public class RequestMetadataWritingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		
		 // writing request metadata
		  FileWriter fw = null;
		  PrintWriter writer = null;
		  try {
			  fw = new FileWriter("D:\\690\\RESTful-apis-test\\REST-ProxyTests\\RESPONSE_META_DATA.txt", true);
			  
			  //collect request metadata
			  String requestId = UUID.randomUUID().toString();
			  String timestamp = new Date().toString();
			  String method = request.getMethod();
			  String requestUrl = request.getRequestURI();
			  String remoteAddress = request.getRemoteAddr();
			  
			  writer = new PrintWriter(fw);
			  
			  writer.write("Request ID: " + requestId + "\n");
			  writer.write("Timestamp: " + timestamp + "\n");
			  writer.write("Method: " + method + "\n");
			  writer.write("RequestUrl: " + requestUrl + "\n");
			  writer.write("Remote Address: " + remoteAddress + "\n");
			  writer.write("\n");
		  }
		  catch(IOException e) {
			  e.printStackTrace();
		  }
		  finally {
			  try {
				  if(writer != null) {
					  writer.close();
				  }
			  }
			  catch(Exception e) {
				  e.printStackTrace();
			  }
		  }
		  chain.doFilter(req, res);
	}

}
