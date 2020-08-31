package com.pat.thinking.in.spring.bean.factory;

import com.pat.thinking.in.spring.ioc.overview.domain.User;

/**
 * @Description {@link UserFactory} 工厂类
 * @Author 不才人
 * @Create Date 2020/5/8 2:35 下午
 * @Modify
 */
public interface UserFactory {

    // Java 8 接口的默认抽象实现
    default User createUser() {
        return  User.createUser();
    }

    void initUserFactory();
}
