package com.test.reca.config.filter;

import com.test.reca.config.JWTUtil;
import com.test.reca.service.TestUserDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class JwtFilterRequest extends OncePerRequestFilter {

    @Autowired
    JWTUtil jwtUtil;

    @Autowired
    TestUserDetailService testUserDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = httpServletRequest.getHeader("Authorization");
        log.info("Entra al doFilter");
        if (authorizationHeader!=null&& authorizationHeader.startsWith("Bearer")) {
            log.info("Entra al Auth");
            String jwt = authorizationHeader.substring(7);
            String username = jwtUtil.extractUsername(jwt);
            if (username!=null && SecurityContextHolder.getContext().getAuthentication() == null) {
                log.info("Entra al getAuthentication");
                UserDetails userDetails = testUserDetailService.loadUserByUsername(username);
                if (jwtUtil.validateToken(jwt, userDetails)) {
                    log.info("Entra al validateToken");
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }

            }

        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
