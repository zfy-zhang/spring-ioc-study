package com.pat.thinking.in.spring.bean.lifecycle;

import com.pat.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/9/6
 * @Modify
 * @since
 */
public class UserHolder implements BeanNameAware, BeanFactoryAware, BeanClassLoaderAware, EnvironmentAware, InitializingBean,
        SmartInitializingSingleton, DisposableBean {

    private final User user;

    private Integer number;

    private String description;

    private ClassLoader classLoader;

    private BeanFactory beanFactory;

    private String beanName;

    private Environment environment;


    public UserHolder(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 依赖于注解驱动
     * 当前场景： BeanFactory
     */
    @PostConstruct
    public void initPostConstruct() {
        // v3 postProcessBeforeInitialization -> v4 initPostConstruct
        this.description = "v4";
        System.out.println("initPostConstruct() = " + description);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // v4 initPostConstruct -> v5 afterPropertiesSet
        this.description = "v5";
        System.out.println("afterPropertiesSet() = " + description);
    }

    /**
     * 自定义初始化方法
     */
    public void init() {
        // v5 initPostConstruct -> v6 afterPropertiesSet
        this.description = "v6";
        System.out.println("init() = " + description);
    }

    @PreDestroy
    public void preDestroy() {
        // v9 -> v10
        this.description = "v10";
        System.out.println("preDestroy:" + description);
    }

    @Override
    public void destroy() throws Exception {
        // v10 -> v11
        this.description = "v11";
        System.out.println("destroy:" + description);
    }

    public void doDestroy() throws Exception {
        // v10 -> v11
        this.description = "v12";
        System.out.println("doDestroy:" + description);
    }


    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                ", number=" + number +
                ", description='" + description + '\'' +
                ", beanName='" + beanName + '\'' +
                '}';
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void afterSingletonsInstantiated() {
        // v6 postProcessAfterInitialization -> v8 afterSingletonsInstantiated
        this.description = "v8";
        System.out.println("afterSingletonsInstantiated() = " + description);
    }


    protected void finalize() throws Throwable {
        System.out.println("UserHolder is initialized");
    }
}
