package com.pat.thinking.in.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Description: {@link ApplicationListener}
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/12
 * @Modify
 * @since
 * @see ApplicationListener
 */
@EnableAsync
public class ApplicationListenerDemo implements ApplicationEventPublisherAware {

    public static void main(String[] args) {
//        GenericApplicationContext context = new GenericApplicationContext();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 将引导类 ApplicationListenerDemo 作为 Configuration Class
        context.register(ApplicationListenerDemo.class);

        // 方法一：基于 Spring 接口：向 Spring 应用上下文注册事件
        // a方法：基于 ConfigurableApplicationContext API 实现
        context.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                println("接收到 Spring 事件：" + event);
            }
        });

        // b方法：基于 ApplicationListener 注册成 Spring Bean
        context.register(MyApplicationListener.class);

        // 方法二：基于Spring注解 ：EventListener

        context.refresh();

        context.start();

        context.close();
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        applicationEventPublisher.publishEvent(new ApplicationEvent("Hello World!!!!!") {
        });

        applicationEventPublisher.publishEvent("----------------");

    }

    static class MyApplicationListener implements ApplicationListener {
        @Override
        public void onApplicationEvent(ApplicationEvent event) {
            println("MyApplicationListener 接收到 Spring 事件：" + event);
        }
    }

    @EventListener
    @Order(2)
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("@EventListener（onApplicationEvent） 接收到 ContextRefreshedEvent 事件：" + event);
    }

    @EventListener
    @Order(1)
    public void onApplicationEvent1(ContextRefreshedEvent event) {
        System.out.println("@EventListener（onApplicationEvent1） 接收到 ContextRefreshedEvent 事件：" + event);
    }

    @EventListener
    @Async
    public void onApplicationEventAsync(ContextRefreshedEvent event) {
        println("@EventListener（异步） 接收到 ContextRefreshedEvent 事件：" + event);
    }

    @EventListener
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("@EventListener 接收到 ContextStartedEvent 事件：" + event);
    }

    @EventListener
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("@EventListener 接收到 ContextClosedEvent 事件：" + event);
    }

    private static void println(Object printable) {
        System.out.printf("[线程： %s]：%s\n", Thread.currentThread().getName(), printable);
    }
}
