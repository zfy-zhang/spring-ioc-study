package com.pat.thinking.in.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Description: 自定义 Spring 事件
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/14
 * @Modify
 * @since
 */
public class MySpringEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public MySpringEvent(Object source) {
        super(source);
    }

    @Override
    public String getSource() {
        return (String) super.getSource();
    }

    public String getMessage() {
        return getSource();
    }
}
