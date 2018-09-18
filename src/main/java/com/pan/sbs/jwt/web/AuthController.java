package com.pan.sbs.jwt.web;

import com.pan.sbs.jwt.core.Result;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        final String token = authService.login(username, password);
        System.out.println("login token : " + token);
        // Return the token


        UserDetails user = new SysUser();
        ((SysUser) user).setUsername("zs");

        String s = jwtTokenUtil.generateToken(user);
        System.out.println("s dz: " + s);

        String usernameFromToken = jwtTokenUtil.getUsernameFromToken(s);
        System.out.println("username : " + usernameFromToken);


        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    @RequestMapping(value = "/auth/login", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(
            HttpServletRequest request) throws AuthenticationException {
        String token = request.getHeader(tokenHeader);
        System.out.println("get token : " + token);

        String refreshedToken = authService.refresh(token);
        if (refreshedToken == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        }
    }


    public static String token = null;
    public static Date lastData = null;

    @RequestMapping(value = "/auth/add", method = RequestMethod.GET)
    public Result addUser() {
        SysUser user = new SysUser();
        user.setUsername("zs");
        user.setPassword("123");
        if (token == null) {
            token = jwtTokenUtil.generateToken(user);
        }
        System.out.println("token : " + token);
        String usernameFromToken = jwtTokenUtil.getUsernameFromToken(token);
        //System.out.println("username : " + usernameFromToken);
        lastData = jwtTokenUtil.getCreatedDateFromToken(token);
        //System.out.println(createdDateFromToken);
        DateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        //System.out.println(jwtTokenUtil);
        System.out.println("token 初始化时间：" + format.format(lastData) + "-------------" + format.format(jwtTokenUtil.getExpirationDateFromToken(token)));
        return null;
    }

    @RequestMapping(value = "/auth/res", method = RequestMethod.GET)
    public Result resUser() {
        if (token != null) {
            System.out.println(token);
           // String s = jwtTokenUtil.refreshToken(token);
           // System.out.println(s);
            Date d = new Date();
            boolean f = jwtTokenUtil.canTokenBeRefreshed(token, d);
            System.out.println(f);


        }
        return null;
    }

    /**
     * @MethodName
     * @Description TODO
     * @Author pzg
     * @Date 2018/9/17
     * @Param
     * @Return
     * @Version 1.0.0
     **/
    @RequestMapping(value = "${jwt.route.authentication.register}", method = RequestMethod.POST)
    public SysUser register(@RequestBody SysUser addedUser) throws AuthenticationException {
        return authService.register(addedUser);
    }
}
