package com.pan.sbs.jwt.core;//package com.pan.sbs.jwt.core;
//
//import com.pan.sbs.jwt.dao.SysUserRepository;
//import com.pan.sbs.jwt.pojo.SysUser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
///**
// * @ClassName CustomUserService
// * @Description TODO
// * @Author pzg
// * @Date 2018/9/11 上午9:51
// * @Version 0.0.1
// * @Remark
// **/
//public class CustomUserService implements UserDetailsService {
//
//    @Autowired
//    SysUserRepository userRepository;
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        SysUser user = userRepository.findByUsername(s);
//        if (user == null) {
//            throw new UsernameNotFoundException("用户名不存在");
//        }
//        System.out.println("s:"+s);
//        System.out.println("username:"+user.getUsername()+";password:"+user.getPassword());
//        System.out.println("size:"+user.getRoles().size());
//        System.out.println("role:"+user.getRoles().get(0).getName());
//        return user;
//    }
//}
