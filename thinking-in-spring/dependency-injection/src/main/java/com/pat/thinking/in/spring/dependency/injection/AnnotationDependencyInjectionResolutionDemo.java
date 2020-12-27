package com.pat.thinking.in.spring.dependency.injection;

import com.pat.thinking.in.spring.dependency.injection.annotation.InjectedUser;
import com.pat.thinking.in.spring.dependency.injection.annotation.MyAutowired;
import com.pat.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.inject.Inject;
import java.lang.annotation.Annotation;
import java.util.*;

import static java.util.Arrays.asList;
import static org.springframework.context.annotation.AnnotationConfigUtils.AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME;


/**
 * @Description: 注解驱动的依赖处理过程
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/9/1
 * @Modify
 * @since
 */
public class AnnotationDependencyInjectionResolutionDemo {


    @Autowired          // 依赖查找（处理）
    @Lazy
    private User lazyUser;

    @Autowired          // 依赖查找（处理）
    private User user; // DependencyDescriptor ->
                        // 必须（require=true）
                        // （eager=true）
                        // 通过类型（User.class）
                        // 字段名称（"user"）
                        // 是否首要（primary=true)

    @Autowired
    private Map<String, User> users; // user supperUser

    @MyAutowired
    private Optional<User> userOptional; // user superUser

    @Inject
    private User injectedUser;

    @InjectedUser
    private User myInjectedUser;

//    @Bean(name = AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME)
//    public static AutowiredAnnotationBeanPostProcessor beanPostProcessor() {
//        AutowiredAnnotationBeanPostProcessor beanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
//        // @Autowired + 使用新注解@InjectedUser
//        Set<Class<? extends Annotation>> autowireAnnotationTypes = new LinkedHashSet<>(asList(Autowired.class, Inject.class, InjectedUser.class));
//        beanPostProcessor.setAutowiredAnnotationTypes(autowireAnnotationTypes);
//        return beanPostProcessor;
//    }

    @Bean
    @Order(Ordered.LOWEST_PRECEDENCE-3)
    public static AutowiredAnnotationBeanPostProcessor beanPostProcessor() {
        AutowiredAnnotationBeanPostProcessor beanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
        beanPostProcessor.setAutowiredAnnotationType(InjectedUser.class);
        return beanPostProcessor;
    }

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册 Configuration Class （配置类） -> Spring Bean
        applicationContext.register(AnnotationDependencyInjectionResolutionDemo.class);


        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";
        // 加载 XML 资源，解析并生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
        // 启动 Spring 上下文
        applicationContext.refresh();

        // 依赖查找 QualifierAnnotationDependencyInjectionDemo Bean
        AnnotationDependencyInjectionResolutionDemo demo = applicationContext.getBean(AnnotationDependencyInjectionResolutionDemo.class);

        // 期待输出 superUser Bean
        System.out.println("demo.user=" + demo.user);
        System.out.println("demo.injectedUser=" + demo.injectedUser);

        System.out.println("demo.users=" + demo.users);

        System.out.println("demo.userOptional=" + demo.userOptional);

        System.out.println("demo.myInjectedUser=" + demo.myInjectedUser);

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();

    }

}
