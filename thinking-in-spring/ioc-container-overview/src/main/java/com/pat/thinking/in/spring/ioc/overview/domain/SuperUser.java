package com.pat.thinking.in.spring.ioc.overview.domain;

import com.pat.thinking.in.spring.ioc.overview.annotation.Super;

/**
 * @Description 超级用户
 * @Author 不才人
 * @Create Date 2020/5/2 10:44 上午
 * @Modify
 */
@Super
public class SuperUser extends User {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
