package com.pat.thinking.in.spring.event;

import org.springframework.context.ApplicationListener;

/**
 * @Description: 自定义 Spring 事件监听器
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/14
 * @Modify
 * @since
 */
public class MySpringEventListener implements ApplicationListener<MySpringEvent> {
    @Override
    public void onApplicationEvent(MySpringEvent event) {
        System.out.printf("[线程 ： %s] 监听到事件 ： %s\n", Thread.currentThread().getName(), event);
    }
}
