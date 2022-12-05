package com.ptit.personal.service;

import com.ptit.personal.entity.Book;

import java.util.List;

public interface IBookService {
    public List<Book> getAll();
    public Book getByID(Integer id);
    public void deleteByID(Book book);
    public void saveBook(Book book);
}
