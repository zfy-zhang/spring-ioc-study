package com.pat.thinking.in.spring.dependency.injection;

import com.pat.thinking.in.spring.dependency.injection.annotation.UserGroup;
import com.pat.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Collection;


/**
 * @Description: {@link Qualifier} 注解依赖注入
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/9/1
 * @Modify
 * @since
 */
public class QualifierAnnotationDependencyInjectionDemo {

    @Autowired
    private User user; // superUser primary -> true

    @Autowired
    @Qualifier("user") // 指定 bean 的名称或 id
    private User namedUser;

    // 整体应用上下文存在 4 个 User 类型 Bean：
    // superUser
    // user
    // user1   @Qualifier
    // user2   @Qualifier

    @Autowired
    private Collection<User> allUsers; // 2 Beans：user、superUser

    @Autowired
    @Qualifier
    private Collection<User> qualifiedUsers; // 2 Beans

    @Autowired
    @UserGroup
    private Collection<User> groupUsers; // 2 Beans

    @Bean
    @Qualifier
    public User user1() {
        return createUser(7L);
    }

    @Bean
    @Qualifier
    public User user2() {
        return createUser(8L);
    }

    @Bean
    @UserGroup
    public User user3() {
        return createUser(9L);
    }

    @Bean
    @UserGroup
    public User user4() {
        return createUser(10L);
    }

    private static User createUser(Long id) {
        User user = new User();
        user.setId(id);
        return user;
    }

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册 Configuration Class （配置类） -> Spring Bean
        applicationContext.register(QualifierAnnotationDependencyInjectionDemo.class);


        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";
        // 加载 XML 资源，解析并生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
        // 启动 Spring 上下文
        applicationContext.refresh();

        // 依赖查找 QualifierAnnotationDependencyInjectionDemo Bean
        QualifierAnnotationDependencyInjectionDemo demo = applicationContext.getBean(QualifierAnnotationDependencyInjectionDemo.class);

        // 期待输出 superUser Bean
        System.out.println("demo.user=" + demo.user);

        // 期待输出 user Bean
        System.out.println("demo.user=" + demo.namedUser);

        System.out.println("demo.allUsers=" + demo.allUsers);

        System.out.println("demo.qualifiedUsers=" + demo.qualifiedUsers);

        System.out.println("demo.groupUsers=" + demo.groupUsers);


        // 显示地关闭 Spring 应用上下文
        applicationContext.close();

    }

}
