package com.pat.thinking.in.spring.validation;

import com.pat.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Import;
import org.springframework.validation.*;

import java.util.Locale;

import static com.pat.thinking.in.spring.validation.ErrorMessageDemo.createMessageSource;

/**
 * @Description: 自定义 Spring {@link Validator} 示例
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
public class ValidatorDemo {

    public static void main(String[] args) {
        Validator validator = new UserValidator();

        User user = new User();
        System.out.println("user 对象是否被 UserValidator 支持校验：" + validator.supports(user.getClass()));

        Errors errors = new BeanPropertyBindingResult(user, "user");
        validator.validate(user, errors);

        MessageSource messageSource = createMessageSource();

        for (ObjectError error : errors.getAllErrors()) {
            String message = messageSource.getMessage(error.getCode(), error.getArguments(), Locale.getDefault());
            System.out.println(message);
        }

    }

    static class UserValidator implements Validator {

        @Override
        public boolean supports(Class<?> clazz) {
            return User.class.isAssignableFrom(clazz);
        }

        @Override
        public void validate(Object target, Errors errors) {
            User user = (User) target;
            ValidationUtils.rejectIfEmptyOrWhitespace(errors,"id", "id.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name", "name.required");

            String userName = user.getName();
        }
    }
}
