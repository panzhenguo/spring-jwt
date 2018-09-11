package com.pan.sbs.jwt.service;


import com.pan.sbs.jwt.pojo.SysUser;

import java.util.List;

public interface UserService {


    /**
     * 添加一个用户
     * @param sysUser
     * @return
     */
    SysUser addSysUser(SysUser sysUser);

    SysUser getSysUserByName(String userName);

    SysUser getUserAllInfo(String userName);

    List<SysUser> getAllUser();


    SysUser loadUserByUsername(String userName);

}
