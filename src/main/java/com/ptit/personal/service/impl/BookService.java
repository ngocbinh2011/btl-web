
package com.ptit.personal.service.impl;

import com.ptit.personal.entity.Book;
import com.ptit.personal.repository.BookRepository;
import java.util.List;

import com.ptit.personal.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookService implements IBookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAll() {
        List<Book> books = bookRepository.findAll();
        return books;
    }

    public Book getByID(Integer id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null){
            Book bookSaved = new Book();
            bookSaved.setId(-1);
            return bookSaved;
        }
        return book;
    }

    public void deleteByID(Book book) {
        bookRepository.delete(book);
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }
}
