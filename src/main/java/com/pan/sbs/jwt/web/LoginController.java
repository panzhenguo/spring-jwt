package com.pan.sbs.jwt.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author pzg
 * @Date 2018/9/6 上午10:19
 * @Version 0.0.1
 * @Remark
 **/
@RequestMapping("/login")
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        System.out.println("to login");
        return "/login.html";
    }


    @RequestMapping("/success")
    public String success(HttpServletRequest request) {

        System.out.println(request.getSession().getId());

//        SecurityContextImpl securityContext = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
//        UserDetails principal = (UserDetails) securityContext.getAuthentication().getPrincipal();
//
//        System.out.println(principal.getAuthorities().toString());

        return "/success.html";

    }

//    @RequestMapping("/loginAction")
//    public String loginAction(String userName ,String userPwd){
//        System.out.println(userName);
//        System.out.println(userPwd);
//        return "";
//    }
}
