package com.nc13.spring_legacy.controller;

import com.nc13.spring_legacy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("register")
    public String showRegister(){
        return "user/register";
    }

    @GetMapping("/")
    public String index(Model model) {
        // 사용자 데이터를 Model에 추가
        model.addAttribute("user", userService.selectOne("a"));
        return "index"; // View 이름 반환
    }

    @GetMapping("logOut")
    public String logOut() {
        return "redirect:/";
    }
}
