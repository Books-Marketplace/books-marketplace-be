package com.alibou.books_marketplace_be.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.net.ContentHandler;

public interface BookRepository extends JpaRepository<Book, String> {
    boolean existsByIsbn(String isbn);

    Page<Book> findAllByAuthor(String author, Pageable pageable);

    Page<Book> findAllByCategory(String category, Pageable pageable);
    @Query("SELECT b FROM Book b WHERE " +
            "LOWER(b.title) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(b.author) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(b.category) LIKE LOWER(CONCAT('%', :keyword, '%')) "
)
    Page<Book> findBookByKeyword(@Param( "keyword")String keyword, Pageable pageable);
}
