package com.pat.thinking.in.spring.dependency.injection;

import com.pat.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * @Description: 基于 Java 注解的依赖字段方法注入示例
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/8/31
 * @Modify
 * @since
 */
public class AnnotationDependencyFieldInjectionDemo {

    @Autowired
    private UserHolder userHolder; // @Autowired 会忽略静态字段

    @Resource
    private UserHolder userHolder2;

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册 Configuration Class （配置类） -> Spring Bean
        applicationContext.register(AnnotationDependencyFieldInjectionDemo.class);


        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";
        // 加载 XML 资源，解析并生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
        // 启动 Spring 上下文
        applicationContext.refresh();

        // 依赖查找 AnnotationDependencyFieldInjectionDemo Bean
        AnnotationDependencyFieldInjectionDemo demo = applicationContext.getBean(AnnotationDependencyFieldInjectionDemo.class);

        // 通过 @Autowired 字段关联
        UserHolder userHolder = demo.userHolder2;
        System.out.println(userHolder);

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();

    }

    @Bean
    public UserHolder userHolder(User user) {
        return new UserHolder(user);
    }

}
