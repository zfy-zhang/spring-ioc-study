package com.pat.thinking.in.spring.dependency.injection;

import com.pat.thinking.in.spring.dependency.injection.annotation.UserGroup;
import com.pat.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Set;


/**
 * @Description: {@link ObjectProvider} 注解依赖注入
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/9/1
 * @Modify
 * @since
 */
public class LazyAnnotationDependencyInjectionDemo {

    @Autowired
    private User user;

    @Autowired
    ObjectProvider<User> userObjectProvider;

    @Autowired
    ObjectProvider<Set<User>> userObjectFactory;

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册 Configuration Class （配置类） -> Spring Bean
        applicationContext.register(LazyAnnotationDependencyInjectionDemo.class);


        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";
        // 加载 XML 资源，解析并生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
        // 启动 Spring 上下文
        applicationContext.refresh();

        // 依赖查找 QualifierAnnotationDependencyInjectionDemo Bean
        LazyAnnotationDependencyInjectionDemo demo = applicationContext.getBean(LazyAnnotationDependencyInjectionDemo.class);

        // 期待输出 superUser Bean
        System.out.println("demo.user=" + demo.user);

        // 期待输出 user Bean
        System.out.println("demo.userObjectProvider=" + demo.userObjectProvider.getObject()); // 继承ObjectFactory
        System.out.println("demo.userObjectFactory=" + demo.userObjectFactory.getObject());

        demo.userObjectProvider.forEach(System.out::println);

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();

    }

}
