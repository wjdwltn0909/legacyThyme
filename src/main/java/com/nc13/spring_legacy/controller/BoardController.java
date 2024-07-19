package com.nc13.spring_legacy.controller;

import com.nc13.spring_legacy.model.BoardDTO;
import com.nc13.spring_legacy.model.UserDTO;
import com.nc13.spring_legacy.service.BoardService;
import com.nc13.spring_legacy.service.ReplyService;
import com.nc13.spring_legacy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board/")
public class BoardController {
    @Autowired
    private UserService userService;
    @Autowired
    private BoardService boardService;
    @Autowired
    private ReplyService replyService;

    @GetMapping("showAll")
    public String showAll(Model model) {
        model.addAttribute("list",boardService.selectAll());
        model.addAttribute("user", userService.selectOne("a").getNickname());
        return "board/showAll";
    }

    @GetMapping("showOne/{id}")
    public String showOne(Model model, @PathVariable("id") int id, Authentication authentication) {
        model.addAttribute("boardDTO",boardService.selectOne(id));
        model.addAttribute("replyList", replyService.selectAll(id));

        model.addAttribute("logIn", (UserDTO)authentication.getPrincipal());

        return "board/showOne";
    }

    @GetMapping("write")
    public String showWrite(Model model) {
        model.addAttribute("boardDTO", new BoardDTO());
        return "board/write";
    }

    @PostMapping("write")
    public String write(@ModelAttribute BoardDTO boardDTO, Authentication authentication) {
        UserDTO logIn = (UserDTO) authentication.getPrincipal();

        boardDTO.setWriterId(logIn.getId());
        System.out.println(boardDTO);
        boardService.insert(boardDTO);

        return "redirect:/board/showAll";
    }

    @GetMapping("update/{id}")
    public String showUpdate(@PathVariable("id") int id, Model model) {
        BoardDTO boardDTO = boardService.selectOne(id);
        model.addAttribute("boardDTO", boardDTO);

        return "board/update";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute BoardDTO boardDTO) {

        boardService.update(boardDTO);

        return "redirect:/board/showOne/" + id;

    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") int id) {
        BoardDTO boardDTO = boardService.selectOne(id);

        if (boardDTO != null) {
            boardService.delete(id);

            return "redirect:/board/showAll";
        }
            return "board/showOne" + id;
    }
}
