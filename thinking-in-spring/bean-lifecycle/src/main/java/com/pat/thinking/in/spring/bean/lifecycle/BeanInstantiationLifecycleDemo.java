package com.pat.thinking.in.spring.bean.lifecycle;

import com.pat.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: Bean 实例化生命周期 实例
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/9/6
 * @Modify
 * @since
 */
public class BeanInstantiationLifecycleDemo {

    public static void main(String[] args) {

        executeBeanFactory();
        System.out.println("-----------------------------------------------------------------");
        executeApplicationContext();

    }

    private static void executeBeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

//        方式一：添加 BeanPostProcessor 实现 MyInstantiationAwareBeanPostProcessor
//        beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
//        方式二：将 MyInstantiationAwareBeanPostProcessor 作为 Bean 注册
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String[] locations = {"META-INF/dependency-lookup-context.xml", "META-INF/bean-constructor-dependency-injection.xml"};
        int beanNumbers = beanDefinitionReader.loadBeanDefinitions(locations);
        System.out.println("已加载 BeanDefinition 数量 ： " + beanNumbers);
        // 通过 Bean Id 和类型进行依赖查找
        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);

        User superUser = beanFactory.getBean("superUser", User.class);
        System.out.println(superUser);

        UserHolder userHolder = beanFactory.getBean("userHolder", UserHolder.class);
        System.out.println(userHolder);
    }

    public static void executeApplicationContext() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        String[] locations = {"META-INF/dependency-lookup-context.xml", "META-INF/bean-constructor-dependency-injection.xml"};
        applicationContext.setConfigLocations(locations);
        applicationContext.refresh();
        // 通过 Bean Id 和类型进行依赖查找
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);

        User superUser = applicationContext.getBean("superUser", User.class);
        System.out.println(superUser);

        UserHolder userHolder = applicationContext.getBean("userHolder", UserHolder.class);
        System.out.println(userHolder);
        applicationContext.close();
    }

}
