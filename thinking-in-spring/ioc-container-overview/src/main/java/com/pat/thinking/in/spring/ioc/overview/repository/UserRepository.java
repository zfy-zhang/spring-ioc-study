package com.pat.thinking.in.spring.ioc.overview.repository;

import com.pat.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

/**
 * @Description 用户信息仓储
 * @Author 不才人
 * @Create Date 2020/5/2 11:06 上午
 * @Modify
 */
public class UserRepository {

    private Collection<User> users;  // 自定义bean

    private BeanFactory beanFactory; // 内建非bean对象（依赖）

    private ObjectFactory<ApplicationContext> objectFactory;
//    private ObjectFactory<User> userObjectFactory;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public ObjectFactory<ApplicationContext> getUserObjectFactory() {
        return objectFactory;
    }

    public void setUserObjectFactory(ObjectFactory<ApplicationContext> objectFactory) {
        this.objectFactory = objectFactory;
    }
}
