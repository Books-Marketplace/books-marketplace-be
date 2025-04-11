package com.alibou.books_marketplace_be.book;

import com.alibou.books_marketplace_be.common.AbstractEntity;
import com.alibou.books_marketplace_be.user.User;
import jakarta.persistence.Entity;
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
@Table(name = "BOOKS")
public class Book extends AbstractEntity {
    private String title;
    private String author;
    private double price;
    private String description;
    private CategoryName category;
    @ManyToOne
    private User seller;

}
