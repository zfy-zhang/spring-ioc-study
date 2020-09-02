package com.pat.thinking.in.spring.dependency.injection.annotation;

import java.lang.annotation.*;

/**
 * @Description: 自定义依赖注入注解
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/9/2
 * @Modify
 * @since
 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InjectedUser {
}
