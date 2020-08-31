package com.pat.thinking.in.spring.ioc.overview.domain;

import com.pat.thinking.in.spring.ioc.overview.enums.City;
import org.springframework.core.io.Resource;

/**
 * @Description
 * @Author 不才人
 * @Create Date 2020/5/2 10:13 上午
 * @Modify
 */
public class User {
    private Long id;
    private String name;
    private City city;

    private Resource configFileLocation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Resource getConfigFileLocation() {
        return configFileLocation;
    }

    public void setConfigFileLocation(Resource configFileLocation) {
        this.configFileLocation = configFileLocation;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                ", configFileLocation=" + configFileLocation +
                '}';
    }

    public static User createUser() {
        User user = new User();
        user.setId(1L);
        user.setName("pat");
        return user;
    }
}
