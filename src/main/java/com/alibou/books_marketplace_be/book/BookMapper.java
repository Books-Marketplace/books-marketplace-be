package com.alibou.books_marketplace_be.book;

import com.alibou.books_marketplace_be.user.UserInformation;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {
    public Book mapToBookEntity(BookRequest bookRequest, UserInformation admin) throws Exception {
        if(!(admin.getId().equals(bookRequest.getAdminId()))) {
            throw new Exception(("Unauthorized: Logged-in user does not match the admin ID in the request."));// we must use a custom execption
        }
        return Book.builder()
                .title(bookRequest.getTitle())
                .author(bookRequest.getAuthor())
                .price(bookRequest.getPrice())
                .image(bookRequest.getImage())
                .description(bookRequest.getDescription())
                .category(bookRequest.getCategory())
                .admin(admin)
                .build();

    }

    public BookResponse mapToBookResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .price(book.getPrice())
                .image(book.getImage())
                .description(book.getDescription())
                .averageRating(book.getAverageRating())
                .category(book.getCategory())
                .numberOfRatings(book.getNumberOfRatings())
                .build();
    }
}
