package com.ptit.personal.controller;

import com.ptit.personal.entity.Book;
import com.ptit.personal.service.IBookService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private IBookService bookService;

    @GetMapping(value = {"/"})
    public String homepage(Model model) {
        List<Book> books = bookService.getAll();
        model.addAttribute("books", books);
        return "home";
    }
}
