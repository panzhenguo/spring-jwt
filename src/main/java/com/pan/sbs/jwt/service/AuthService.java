package com.pan.sbs.jwt.service;

import com.pan.sbs.jwt.pojo.SysUser;

/**
 * @ClassName AuthService
 * @Description TODO
 * @Author pzg
 * @Date 2018/9/7 下午4:15
 * @Version 0.0.1
 * @Remark
 **/
public interface AuthService {

    SysUser register(SysUser userToAdd);
    String login(String username, String password);
    String refresh(String oldToken);

}
