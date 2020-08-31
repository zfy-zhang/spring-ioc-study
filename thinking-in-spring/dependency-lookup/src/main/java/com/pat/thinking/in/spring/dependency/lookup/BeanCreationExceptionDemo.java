package com.pat.thinking.in.spring.dependency.lookup;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * @Description: {@link BeanCreationException} 实例
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/8/31
 * @Modify
 * @since
 */
public class BeanCreationExceptionDemo {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册 BeanDefinition Bean Class 是一个CharSequence 接口
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(POJO.class);
        applicationContext.registerBeanDefinition("errorBean", beanDefinitionBuilder.getBeanDefinition());


        // 启动应用上下文
        applicationContext.refresh();

        // 关闭上下文
        applicationContext.close();
    }

    static class POJO implements InitializingBean {

        @PostConstruct // CommonAnnotationBeanPostProcessor
        public void init() throws Throwable {
            throw new Exception("init() : For purposes......");
        }
        @Override
        public void afterPropertiesSet() throws Exception {
            throw new Exception("For purposes......");
        }
    }
}
