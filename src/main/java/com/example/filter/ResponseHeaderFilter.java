package com.example.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class ResponseHeaderFilter implements Filter {
  
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
          throws IOException, ServletException {

      HttpServletResponse res = (HttpServletResponse) response;
      res.setHeader("Cache-Control", "public, max-age=3600");
      res.setHeader("Strict-Transport-Security","max-age=31536000; includeSubDomains");
      res.setHeader("X-Content-Type-Options", "nosniff");
      res.setHeader("Referrer-Policy", "strict-origin-when-cross-origin");

      chain.doFilter(request, response);
  }

}
