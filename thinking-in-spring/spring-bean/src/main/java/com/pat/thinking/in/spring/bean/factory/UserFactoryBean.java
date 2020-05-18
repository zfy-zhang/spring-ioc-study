package com.pat.thinking.in.spring.bean.factory;

import com.pat.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Description {@link User} Bean 的 {@link org.springframework.beans.factory.FactoryBean} 实现
 * @Author 不才人
 * @Create Date 2020/5/8 3:38 下午
 * @Modify
 */
public class UserFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
