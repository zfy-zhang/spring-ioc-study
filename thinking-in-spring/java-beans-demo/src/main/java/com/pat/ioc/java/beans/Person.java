package com.pat.ioc.java.beans;

/**
 * @Description：描述人的POJO
 *
 * Setter / Getter 方法
 * 可写方法(Writable) / 可读方法(Readable)
 *
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create Date 2020/5/1 10:20 下午
 * @Modify
 * @Since
 */
public class Person {

    // String to String
    String name; // Property

    // String to Integer
    Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
