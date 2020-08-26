package com.pat.thinking.in.spring.bean.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Description  默认 {@link UserFactory} 实现
 * @Author 不才人
 * @Create Date 2020/5/8 2:41 下午
 * @Modify
 */
public class DefaultUserFactory implements UserFactory, InitializingBean, DisposableBean {

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
        System.out.println("InitializingBean#afterPropertiesSet() : UserFactory 初始化中...");
    }

    @PreDestroy
    public void perDestroy() {
        System.out.println("@PreDestroy ：UserFactory销毁中...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean#destroy() ：UserFactory销毁中...");
    }

    public void doDestroy() {
        System.out.println("自定义方法doDestroy() ：UserFactory销毁中...");
    }

    @Override
    public void finalize() throws Throwable {
        System.out.println("当前 DefaultUserFactory 对象正在被垃圾回收...");
    }
}
