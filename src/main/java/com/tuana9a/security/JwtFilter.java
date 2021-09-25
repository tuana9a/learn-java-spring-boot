package com.tuana9a.security;

import com.tuana9a.repository.v3.UserRepoV3;
import com.tuana9a.service.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(2)
@AllArgsConstructor
public class JwtFilter implements Filter {
    private final UserRepoV3 userRepo;
    private final JwtService jwtService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

//        String token = req.getHeader("Authorization");
        String token = req.getParameter("token");

        if (token != null) {
            String username = jwtService.decodeToken(token);
            boolean exist = userRepo.existsByUsernameAndDeletedFalse(username);
            if (exist) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                resp.setStatus(401);
            }
        } else {
            resp.setStatus(401);
        }
    }

}
