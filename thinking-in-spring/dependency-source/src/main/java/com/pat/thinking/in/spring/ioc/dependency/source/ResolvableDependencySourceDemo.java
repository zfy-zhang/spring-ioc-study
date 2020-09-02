package com.pat.thinking.in.spring.ioc.dependency.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * @Description: ResolvableDependency 作为依赖来源
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/9/2
 * @Modify
 * @since
 */
public class ResolvableDependencySourceDemo {

    @Autowired
    private String value;

    @PostConstruct
    public void init() {
        System.out.println(value);
    }

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册 Configuration Class （配置类） -> Spring Bean
        applicationContext.register(ResolvableDependencySourceDemo.class);

        applicationContext.addBeanFactoryPostProcessor(beanFactory ->{
            // 注册 Resolvable Dependency
            beanFactory.registerResolvableDependency(String.class, "纵使在青云不凌志");
        } );

        // 启动 Spring 上下文
        applicationContext.refresh();

//        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();

//        if (beanFactory instanceof ConfigurableListableBeanFactory) {
//            ConfigurableListableBeanFactory configurableListableBeanFactory = ConfigurableListableBeanFactory.class.cast(beanFactory);
//            // 注册 Resolvable Dependency
//            configurableListableBeanFactory.registerResolvableDependency(String.class, "总是在青云不凌志");
//        }

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();

    }

}
