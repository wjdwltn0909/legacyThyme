package com.nc13.spring_legacy.controller;

import com.nc13.spring_legacy.service.BoardService;
import com.nc13.spring_legacy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private BoardService boardService;
    private UserService userService;
    @Autowired
    public HomeController(BoardService boardService, UserService userService){
        this.boardService = boardService;
        this.userService = userService;
    }


    @GetMapping("/")
    public String showHome(Model model) {
        model.addAttribute("list", boardService.selectAll());
        model.addAttribute("user", "정지수");

        return "index";
    }


}
