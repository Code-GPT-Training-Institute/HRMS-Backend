package com.trainings.jpa.filter;

import com.trainings.jpa.service.ITokenService;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.security.auth.message.AuthException;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthFilter implements Filter {

    @Autowired
    ITokenService tokenService;
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        String url = ((HttpServletRequest)servletRequest).getRequestURL().toString();
        if (url.contains("/user/auth/")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            final String token = ((HttpServletRequest) servletRequest).getHeader("Authorization");
            if (null != token && token.startsWith("Bearer ")) {
                try {
                    tokenService.validateToken(token.replace("Bearer ", ""));
                    filterChain.doFilter(servletRequest, servletResponse);
                } catch (ExpiredJwtException expiredJwtException) {
                    ((HttpServletResponse)servletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token Expired");
                } catch (Exception ex) {
                    ((HttpServletResponse)servletResponse).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unhandled exception");
                }
            } else {
                ((HttpServletResponse)servletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid Token");
            }
        }
    }
}
