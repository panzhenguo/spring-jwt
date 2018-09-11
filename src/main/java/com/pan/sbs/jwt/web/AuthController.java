package com.pan.sbs.jwt.web;

import com.pan.sbs.jwt.pojo.SysUser;
import com.pan.sbs.jwt.service.AuthService;
import com.pan.sbs.jwt.utils.JwtAuthenticationResponse;
import com.pan.sbs.jwt.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthController {
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(String username, String password) throws AuthenticationException {

        //  @RequestBody JwtAuthenticationRequest authenticationRequest
        final String token = authService.login(username,password);
        System.out.println("login token : "+token);
        // Return the token


        UserDetails user = new SysUser();
        ((SysUser) user).setUsername("zs");

        String s = jwtTokenUtil.generateToken(user);
        System.out.println("s dz: "+s);

        String usernameFromToken = jwtTokenUtil.getUsernameFromToken(s);
        System.out.println("username : "+usernameFromToken);





        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    @RequestMapping(value = "/auth/login", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(
            HttpServletRequest request) throws AuthenticationException {
        String token = request.getHeader(tokenHeader);
        System.out.println("get token : "+token);

        String refreshedToken = authService.refresh(token);
        if(refreshedToken == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        }
    }

    @RequestMapping(value = "/auth/add",method = RequestMethod.GET)
    public SysUser addUser() {

//        System.out.println("dasdasdasdsadas");
//        authService.register(null);

        UserDetails user = new SysUser();
        ((SysUser) user).setUsername("zs");

        String s = jwtTokenUtil.generateToken(user);
        System.out.println("token : "+s);

        String usernameFromToken = jwtTokenUtil.getUsernameFromToken(s);
        System.out.println("username : "+usernameFromToken);

        System.out.println(jwtTokenUtil);
        return null;
    }

    @RequestMapping(value = "${jwt.route.authentication.register}", method = RequestMethod.POST)
    public SysUser register(@RequestBody SysUser addedUser) throws AuthenticationException {
        return authService.register(addedUser);
    }
}
