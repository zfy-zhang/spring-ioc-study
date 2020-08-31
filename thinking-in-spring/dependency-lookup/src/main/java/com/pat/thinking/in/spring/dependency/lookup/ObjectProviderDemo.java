package com.pat.thinking.in.spring.dependency.lookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @Description: {@link ObjectProvider} 进行依赖查找
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/8/31
 * @Modify
 * @since
 */
public class ObjectProviderDemo {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将 AnnotationApplicationContextAsIocContainerDemo 作为配置类（Configuration Class）
        applicationContext.register(ObjectProviderDemo.class);

        // 启动应用上下文
        applicationContext.refresh();
        // 依赖查找集合对象
        lookupByObjectProvider(applicationContext);

        // 关闭上下文
        applicationContext.close();
    }

    @Bean
    public String helloWorld() {
        return "Hello World";
    }

    private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
        System.out.println(objectProvider.getObject());
    }
}
