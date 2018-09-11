package com.pan.sbs.jwt.core;

import com.pan.sbs.jwt.pojo.SysRole;
import com.pan.sbs.jwt.pojo.SysUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName UserDetailsServiceCustom
 * @Description TODO
 * @Author pzg
 * @Date 2018/9/10 下午4:49
 * @Version 0.0.1
 * @Remark
 **/
public class UserDetailsServiceCustom implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        //SysUser user = userRepository.findByUsername(s);

        SysRole role= new SysRole();
        role.setId(1l);
        role.setName("admin");

        SysRole role1 = new SysRole();
        role.setId(2l);
        role1.setName("emp");

        SysRole role2 = new SysRole();
        role2.setId(3l);
        role2.setName("mange");

        SysUser user = new SysUser();
        List<SysRole> roles = new ArrayList<>();
        roles.add(role);
        roles.add(role1);
        roles.add(role2);
        user.setId(1l);
        user.setRoles(roles);
        user.setUsername("admin");

        //$2a$10$y.VLQuyB1Px4Dg2m01Rts.00c6rD/bTceGsl8L.5wFz03H4N3V6Je
        //1536561106699
        user.setPassword("$2a$10$ZjlxvQQkRRhHlWkdsscmR./zci5jS973ZnCvi5ULPWfszTi8XuEDe");
        user.setUsername("zs");
        user.setLastPasswordResetDate(new Date(1536561106699l));

        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
//        System.out.println("username:"+user.getUsername()+";password:"+user.getPassword());
//        System.out.println("size:"+user.getRoles().size());
//        System.out.println("role:"+user.getRoles().get(0).getName());
        return user;
    }
}
