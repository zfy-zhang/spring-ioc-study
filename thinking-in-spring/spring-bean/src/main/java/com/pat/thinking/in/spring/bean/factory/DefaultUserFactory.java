package com.pat.thinking.in.spring.bean.factory;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @Description  默认 {@link UserFactory} 实现
 * @Author 不才人
 * @Create Date 2020/5/8 2:41 下午
 * @Modify
 */
public class DefaultUserFactory implements UserFactory, InitializingBean {

    // 1. 基于 @PostConstruct 注解
    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct：UserFactory初始化中...");
    }

    public void initUserFactory() {
        System.out.println("自定义初始化方法 initUserFactory() : UserFactory 初始化中...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean#afterPropertiesSet() : UserFactory 初始汇中...");
    }
}
