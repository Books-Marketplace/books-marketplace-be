package com.alibou.books_marketplace_be.book;

import com.alibou.books_marketplace_be.user.UserInformation;

import java.util.List;

public interface BookService {
    void createBook(BookRequest bookRequest, UserInformation admin);
    List<BookResponse> getAllBooks(int page ,int size);
    BookResponse findBookById(String bookId);
    void updateBook(String adminId,String bookId,  BookRequest bookRequest);
    void deleteBook(String bookId);
    List<BookResponse> getAllBooksByAuthor(String author,int page ,int size);
    List<BookResponse> filterBooksByCategory(String category,int page ,int size);
    List<BookResponse> search(String keyword ,int page ,int pageSize);




}
