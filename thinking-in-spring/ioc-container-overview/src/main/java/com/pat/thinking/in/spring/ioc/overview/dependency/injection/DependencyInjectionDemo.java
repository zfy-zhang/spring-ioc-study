package com.pat.thinking.in.spring.ioc.overview.dependency.injection;

import com.pat.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @Description
 * @Author 不才人
 * @Create Date 2020/5/2 11:04 上午
 * @Modify
 */
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-injection-context.xml");
        // 依赖来源一：自定义的bean
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);
//        System.out.println(userRepository.getUsers());

        // 依赖来源二：依赖注入（内建依赖）
        System.out.println(userRepository.getBeanFactory());
//        System.out.println(userRepository.getBeanFactory() == beanFactory);

        ObjectFactory userFactory = userRepository.getUserObjectFactory();

        System.out.println(userFactory.getObject() == beanFactory);


        // 依赖查找（错误）
//        System.out.println(beanFactory.getBean(BeanFactory.class));
        Environment environment = beanFactory.getBean(Environment.class);

        // 依赖来源三： 容器内建 Bean
        System.out.println("获取 Environment 类型的 Bean：" + environment);
    }
}
