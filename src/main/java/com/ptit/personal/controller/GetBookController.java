package com.ptit.personal.controller;


import com.ptit.personal.config.AppConfig;
import com.ptit.personal.entity.Book;
import com.ptit.personal.service.IBookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@Slf4j
public class GetBookController {

    private final IBookService bookService;
    private final AppConfig appConfig;

    @GetMapping("/books/{id}")
    public String getBook(Model model, @PathVariable String id) {
        try {
            Book book = bookService.getByID(Integer.valueOf(id));
            model.addAttribute("book", book);
            return "book-details";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "book-details";
    }
}

