package com.pat.thinking.in.spring.bean.definition;

import com.pat.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description BeanDefinition 示例
 * @Author 不才人
 * @Create Date 2020/5/8 10:24 上午
 * @Modify
 */
// 3. 通过 @Import 来进行导入
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {
    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册 Configuration Class （配置类）
        applicationContext.register(Config.class);

        applicationContext.refresh();
        System.out.println("Config 类型的所有 Beans" + applicationContext.getBeansOfType(Config.class));
        System.out.println("User 类型的所有 Beans" + applicationContext.getBeansOfType(User.class));

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();

    }

    // 2. 通过 @Component 方式
    @Component // 定义当前类作为 Spring Bean （组件）
    public static class Config {
        /**
         *  1. 通过 @Bean 方式定义
         * 通过 Java 注解的方式， 定义一个Bean
         * @return
         */
        @Bean
        public User user() {
            User user = new User();
            user.setId(1L);
            user.setName("pat");
            return user;
        }
    }
}
