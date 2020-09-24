package com.pat.thinking.in.spring.configuration.metadata;

import com.pat.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;

/**
 * @Description: {@link PropertiesBeanDefinitionReader} 示例
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/9/23
 * @Modify
 * @since
 */
public class PropertiesBeanDefinitionReaderDemo {

    public static void main(String[] args) {
        // 创建 IOC 底层容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 创建面向 Properties 资源的 BeanDefinitionReader 示例
        PropertiesBeanDefinitionReader beanDefinitionReader = new PropertiesBeanDefinitionReader(beanFactory);
        // Properties 资源加载默认通过 ISO-8859-1， 实际存储是 UTF-8
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        // 通过指定的 ClassPath 获取 Resource 对象
        Resource resource = resourceLoader.getResource("classpath:/META-INF/users-bean-definitions.properties");
        // 转换成带有字符编码 EncodedResource 对象
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
        int beanDefinitionsCount = beanDefinitionReader.loadBeanDefinitions(encodedResource);
        System.out.printf("已加载 %s 个 BeanDefinition \n", beanDefinitionsCount);

        // 通过依赖查找 User Bean
        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);
    }

}
