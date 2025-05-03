package com.alibou.books_marketplace_be.rate;

import com.alibou.books_marketplace_be.book.Book;
import com.alibou.books_marketplace_be.common.AbstractEntity;
import com.alibou.books_marketplace_be.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "RATINGS")
public class Rate extends AbstractEntity {
    private int value;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User buyer;

}
