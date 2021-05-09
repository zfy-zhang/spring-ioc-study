package com.pat.thinking.in.spring.validation;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @Description: Spring Bean Validation 整合示例
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 *
 * @see Validator
 * @see LocalValidatorFactoryBean
 */
public class SpringBeanValidationDemo {

    public static void main(String[] args) {

        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/bean-validation-context.xml");

//        Validator validator = applicationContext.getBean(Validator.class);
//        System.out.println(validator instanceof LocalValidatorFactoryBean);

        UserProcessor userProcessor = applicationContext.getBean(UserProcessor.class);
        userProcessor.process(new User());

        // 关闭应用上下文
        applicationContext.close();
    }

    @Component
    @Validated
    static class UserProcessor {

        public void process(@Valid User user) {
            System.out.println(user);
        }

    }

    @Validated
    static class User {
        @NotNull
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
