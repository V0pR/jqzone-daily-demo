package com.core.service;

import com.core.common.base.BaseService;
import com.core.common.exception.BizException;
import com.core.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

/**
 * @author wjq
 * @version 1.0
 * @Title: UserServiceImpl
 * @Package com.core.service
 * @Description:
 * @date 2020/1/10 14:07
 */
@Service
public class UserServiceImpl extends BaseService<User> implements UserService {

    @Override
    public User create(User user) {
        if (StringUtils.isNotBlank(user.getAccount()) || StringUtils.isNotBlank(user.getPassword())) {
            throw new BizException("账户或密码不能为空");
        }

        user.setPassword(hash(user.getPassword()));
        return super.create(user);
    }

    @Override
    public void updatePassword(Long userId, String password) {
        User originUser = User.finder.findById(userId);
        if (BCrypt.checkpw(password, originUser.getPassword())) {
            throw new BizException("密码未做任何更改");
        }
        originUser.setPassword(hash(password));
        update(originUser);
    }

    @Override
    public void update(User entity) {
         super.update(entity);
    }

    private String hash(String text) {
        return BCrypt.hashpw(text, BCrypt.gensalt());
    }


}


//  String candidate = "testpassword";
// if(BCrypt.checkpw(candidate,hashed))
//         　　　　System.out.println("It matches");
//         　   　else
//         　　System.out.println("It does not match");

