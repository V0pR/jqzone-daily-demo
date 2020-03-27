package com.core.service.impl;

import com.core.common.base.BaseService;
import com.core.common.exception.BizException;
import com.core.domain.User;
import com.core.domain.UserRoleRef;
import com.core.service.UserService;
import com.google.common.collect.Lists;
import io.ebean.Ebean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

/**
 * @author wangj
 * @version 1.0
 * @Title: UserServiceImpl
 * @Package com.core.service.impl
 * @Description: TODO
 * @date 2020/3/17 0:21
 */
@Service("userService")
@Slf4j
public class UserServiceImpl extends BaseService<User> implements UserService {

    @Autowired
    HttpServletRequest request;


    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        log.info("loadUserByUsername {}", account);

        User user = User.finder.findByAccount(account);


        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("account", account);


        //权限
        List<GrantedAuthority> authorities = Lists.newArrayList();

        //加载权限
        List<UserRoleRef> userRoleRefs = UserRoleRef.finder.findRoleByUserId(user.getId());
        for (UserRoleRef roleRef : userRoleRefs) {
            authorities.add(new SimpleGrantedAuthority(roleRef.getRole().getCode()));
        }
        // 返回UserDetails实现类
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorities);
    }

    @Override
    public void registered(User user) {
        create(user);
    }
}
