package com.pat.thinking.in.spring.event;

import java.util.EventObject;
import java.util.Observable;
import java.util.Observer;

/**
 * @Description: {@link Observer} Demo
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/12
 * @Modify
 * @since
 */
public class ObserverDemo {

    public static void main(String[] args) {

        EventObservable observable = new EventObservable();
        observable.addObserver(new EventObserver());

        observable.notifyObservers("Hello World!");
    }

    static class EventObservable extends Observable {

        public void setChanged() {
            super.setChanged();
        }

        public void notifyObservers(Object arg) {
            setChanged();
            super.notifyObservers(new EventObject(arg));
            clearChanged();
        }
    }

    static class EventObserver implements Observer {

        @Override
        public void update(Observable o, Object event) {
            EventObject eventObject = (EventObject) event;
            System.out.println("收到事件：" + event);
        }
    }
}
