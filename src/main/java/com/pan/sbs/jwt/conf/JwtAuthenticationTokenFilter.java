package com.pan.sbs.jwt.conf;

import com.pan.sbs.jwt.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @ClassName JwtAuthenticationTokenFilter
 * @Description TODO
 * @Author pzg
 * @Date 2018/9/10 下午4:46
 * @Version 0.0.1
 * @Remark
 **/
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {


    @Autowired
    private UserDetailsService userDetailsService;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal( HttpServletRequest request, HttpServletResponse response,FilterChain chain) throws ServletException, IOException {
        String authHeader = request.getHeader(this.tokenHeader);


        String token = request.getHeader("token");


        System.out.println(token);
        String usernameFromToken = jwtTokenUtil.getUsernameFromToken(token);
        System.out.println(usernameFromToken);

        System.out.println("authHeader ："+authHeader);
        if (authHeader != null && authHeader.startsWith(tokenHead)) {
            System.out.println("tokenHead : "+tokenHead);
            final String authToken = authHeader.substring(tokenHead.length());
            System.out.println("authToken ："+authToken);

            String username = jwtTokenUtil.getUsernameFromToken(authToken);

            System.out.println("username :"+username);

            Date createdDateFromToken = jwtTokenUtil.getCreatedDateFromToken(authToken);

            System.out.println("createdDateFromToken "+createdDateFromToken);


            logger.info("checking authentication " + username);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
                if (jwtTokenUtil.validateToken(authToken, userDetails)) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    logger.info("authenticated user " + username + ", setting security context");
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        chain.doFilter(request, response);
    }
}
