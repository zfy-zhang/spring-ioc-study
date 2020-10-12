package com.pat.thinking.in.spring.configuration.metadata;

import org.springframework.beans.factory.xml.NamespaceHandler;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @Description: "users.xsd" {@link NamespaceHandler} 实现
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/12
 * @Modify
 * @since
 */
public class UsersNamespaceHandler extends NamespaceHandlerSupport {


    @Override
    public void init() {
        // 讲 "user" 元素注册对应的 BeanDefinitionParser 实现
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
    }
}
