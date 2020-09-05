package com.pat.thinking.in.spring.ioc.bean.scope.web.controller;

import com.pat.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description: 首页 Spring Web MVC Controller
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/9/3
 * @Modify
 * @since
 */
//@RequestMapping
@Controller
public class IndexController {

    private final User user; // CGLIB 代理后的对象（不变的）

    @Autowired
    public IndexController(User user) {
        this.user = user;
    }

    @GetMapping("index.html")
    public String index(Model model) {
        // JSP EL 变量搜索路径 page -> request -> session -> application(ServletContext)
        // userObject -> 渲染上下文
        // user 对象存在 ServletContext，上下文名称：scopedTarget.user == 新生成 Bean 名称
        model.addAttribute("userObject", user);
        return "index";
    }
}
