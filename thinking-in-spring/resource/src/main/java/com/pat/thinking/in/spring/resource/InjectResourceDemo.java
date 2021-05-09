package com.pat.thinking.in.spring.resource;

import com.pat.thinking.in.spring.resource.util.ResourceUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.stream.Stream;

/**
 * @Description: 注入 {@link Resource} 对象示例
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 *
 * @see Resource
 * @see Value
 * @see AnnotationConfigApplicationContext
 */
public class InjectResourceDemo {

    @Value("classpath:/META-INF/default.properties")
    private Resource defaultPropertiesResource;

    @Value("classpath*:/META-INF/*.properties")
    private Resource[] propertiesResources;

    @Value("${user.dir}")
    private String currentProjectRootPath;

    @PostConstruct
    public void init() {
        System.out.println(ResourceUtils.getContent(defaultPropertiesResource));
        System.out.println("==================================================");
        Stream.of(propertiesResources).map(ResourceUtils::getContent).forEach(System.out::println);
        System.out.println("==================================================");
        System.out.println(currentProjectRootPath);
    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(InjectResourceDemo.class);

        // 启动 Spring 上下文
        context.refresh();

        // 关闭 Spring 上下文
        context.close();
    }

}
