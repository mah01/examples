package dk.sorokin.maksim.dosgiSecurity.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityFilter implements Filter {

  // Suzy:rocket
  private static final String HARDCODED_AUTHORIZATION_HEADER = "Basic U3V6eTpyb2NrZXQ=";

  @Override
  public void destroy() {
    //
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;

    String authorizationHeader = httpRequest.getHeader("Authorization");

    if ((authorizationHeader != null) && authorizationHeader.equals(HARDCODED_AUTHORIZATION_HEADER)) {
      chain.doFilter(request, response);
    } else {
      httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
    }
  }

  @Override
  public void init(FilterConfig config) throws ServletException {
    //
  }
}