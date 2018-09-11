package com.pan.sbs.jwt.service.impl;//package com.pan.sbs.jwt.service.impl;
//
//import com.pan.sbs.jwt.pojo.SysRole;
//import com.pan.sbs.jwt.pojo.SysUser;
//import com.pan.sbs.jwt.service.UserService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.UUID;
//
//@Transactional
//@Service
//public class UserServiceImpl implements UserService {
//
////    @Autowired
////    private SysUserMapper sysUserMapper;
//
//    @Override
//    public SysUser addSysUser(SysUser sysUser) {
//        String uuid= UUID.randomUUID().toString();
//        sysUser.setLastPasswordResetDate(new Date());
//        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
//        sysUser.setPassword(encode.encode(sysUser.getPassword()));
//
//        return sysUser;
//    }
//
//    @Override
//    public SysUser getSysUserByName(String userName) {
//        return new SysUser();
//    }
//
//    @Override
//    public SysUser getUserAllInfo(String userName) {
//        SysUser su = getSysUserByName(userName);
//
//        su.setUsername("zs");
//        su.setPassword("$2a$10$ApICaxsE.i1a8CrRXy/15OpZoIshw2vjL7O8kKNS4occEeOr.w6Mu");
//
//
//        List<SysRole> spl = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            sp = new SysPermission();
//            sp.setType(2);
//            sp.setName("spl:add");
//            spl.add(sp);
//        }
//        su.setPermissionList(spl);
//        return su;
//    }
//
//    @Override
//    public List<SysUser> getAllUser() {
//
//        //return sysUserMapper.selectAll();
//        return null;
//    }
//
//    @Override
//    public SysUser loadUserByUsername(String userName) {
//        SysRole role= new SysRole();
//        role.setId(1l);
//        role.setName("admin");
//
//        SysRole role1 = new SysRole();
//        role.setId(2l);
//        role1.setName("emp");
//
//        SysRole role2 = new SysRole();
//        role2.setId(3l);
//        role2.setName("mange");
//
//        SysUser user = new SysUser();
//        List<SysRole> roles = new ArrayList<>();
//        roles.add(role);
//        roles.add(role1);
//        roles.add(role2);
//        user.setId(1l);
//        user.setRoles(roles);
//        user.setUsername("admin");
//        user.setPassword("$2a$10$ApICaxsE.i1a8CrRXy/15OpZoIshw2vjL7O8kKNS4occEeOr.w6Mu");
//        ///user.setLastPasswordResetDate(new Date());
//
//        if (user == null) {
//           // throw new UsernameNotFoundException("用户名不存在");
//        }
//        System.out.println("username:"+user.getUsername()+";password:"+user.getPassword());
//        System.out.println("size:"+user.getRoles().size());
//        System.out.println("role:"+user.getRoles().get(0).getName());
//        return user;
//    }
//
//}
