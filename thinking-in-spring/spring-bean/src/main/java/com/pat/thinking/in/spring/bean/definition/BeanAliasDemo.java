package com.pat.thinking.in.spring.bean.definition;

import com.pat.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description 别名示例
 * @Author 不才人
 * @Create Date 2020/5/8 10:10 上午
 * @Modify
 */
public class BeanAliasDemo {
    public static void main(String[] args) {
        // 配置XML配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-definitions-context.xml");
        // 通过别名获取 bean
        User user = beanFactory.getBean("user", User.class);
        User patUser = beanFactory.getBean("pat-user", User.class);

        System.out.println("pat-user 是否与 user Bean 相同: " +(user == patUser));
    }
}
