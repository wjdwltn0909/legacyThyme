package com.nc13.spring_legacy.controller;

import com.nc13.spring_legacy.service.BoardService;
import com.nc13.spring_legacy.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reply/")
public class ReplyController {
    @Autowired
    private BoardService boardService;
    @Autowired
    private ReplyService replyService;

    @GetMapping("ShowAll/{boardId}")
    public String showAll(Model model, @PathVariable("boardId") int boardId) {
        model.addAttribute("replyList", replyService.selectAll(boardId) );

        return "";
    }
}
