package com.pat.thinking.in.spring.bean.definition;

import com.pat.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description 实例化实例
 * @Author 不才人
 * @Create Date 2020/5/8 2:28 下午
 * @Modify
 */
public class BeanInstantiationDemo {
    public static void main(String[] args) {
        // 配置XML配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation-context.xml");
        User user = beanFactory.getBean("user-by-static-method", User.class);
        User userByInstanceMethod = beanFactory.getBean("user-by-instance-method", User.class);
        User userByIFactoryBean = beanFactory.getBean("user-by-factory-bean", User.class);
        System.out.println(user);
        System.out.println(userByInstanceMethod);

        System.out.println(user == userByInstanceMethod);
        System.out.println(user == userByIFactoryBean);

    }
}
