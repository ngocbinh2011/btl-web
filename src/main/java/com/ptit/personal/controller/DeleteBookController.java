package com.ptit.personal.controller;

import com.ptit.personal.entity.Book;
import com.ptit.personal.service.IBookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
@Controller
public class DeleteBookController {

    private final IBookService bookService;

    @GetMapping("/books/delete/{id}")
    public String deleteBook(Book book, @PathVariable String id) {
        try {
            bookService.deleteByID(book);
            return "redirect:/";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }
}
