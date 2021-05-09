package com.pat.thinking.in.spring.data.binding;

import com.pat.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.validation.DataBinder;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: {@link DataBinder} 示例
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @see DataBinder
 * @since
 */
public class DataBindingDemo {
    public static void main(String[] args) {

        User user = new User();
        DataBinder binder = new DataBinder(user, "user");

        Map<String, Object> source = new HashMap<>();
        source.put("id", 7);
        source.put("name", "风尘");

        // 设置一个不存在的属性值
        // 忽略未知属性
        source.put("age", 22);

        // PropertyValues 嵌套一个 company.name
        // 支持嵌套属性
        source.put("company.name", "无限公司");


        PropertyValues propertyValues = new MutablePropertyValues(source);


        binder.bind(propertyValues);

        System.out.println(user);

    }
}
