package com.pan.sbs.jwt.dao;

import com.pan.sbs.jwt.pojo.SysUser;
import org.springframework.stereotype.Component;

/**
 * @ClassName SysUserRepository
 * @Description TODO
 * @Author pzg
 * @Date 2018/9/11 上午9:47
 * @Version 0.0.1
 * @Remark
 **/
@Component
public class SysUserRepository {

    public SysUser findByUsername(String userName){
        return new SysUser();
    }

    public SysUser save(SysUser sysUser){
        return null;
    }
}
