package com.pat.thinking.in.spring.validation;

import com.pat.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.context.support.StaticMessageSource;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Locale;

/**
 * @Description: 错误文案示例
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 * @see Errors
 */
public class ErrorMessageDemo {

    public static void main(String[] args) {
        // 0、创建 User 对象
        User user = new User();
        // 1、选择 Errors -> BeanPropertyBindingResult
        Errors errors = new BeanPropertyBindingResult(user, "user");
        // 2、调用 reject 或 rejectValue
        // reject 生成 ObjectError
        // reject 生成 FiledError
        errors.reject("user.properties.not.null");
        // user.name = user.getName()
        errors.rejectValue("name", "name.required");

        // 3、获取 Errors 中的 ObjectError 和 FiledError
        List<ObjectError> globalErrors = errors.getGlobalErrors();
        FieldError fieldError = errors.getFieldError();
        List<ObjectError> allErrors = errors.getAllErrors();

        // 4、通过 ObjectError 和 FiledError 中的 code 和 args 来关联 MessageSource 实现
        MessageSource messageSource = createMessageSource();

        for (ObjectError error : allErrors) {
            String message = messageSource.getMessage(error.getCode(), error.getArguments(), Locale.getDefault());
            System.out.println(message);
        }

    }

    static MessageSource createMessageSource() {
        StaticMessageSource messageSource = new StaticMessageSource();
        messageSource.addMessage("user.properties.not.null", Locale.getDefault(), "User 所有属性不能为空.");
        messageSource.addMessage("id.required", Locale.getDefault(), "the id of User must not be null.");
        messageSource.addMessage("name.required", Locale.getDefault(), "the name of User must not be null.");
        return messageSource;
    }

}
