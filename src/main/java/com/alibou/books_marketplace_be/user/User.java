package com.alibou.books_marketplace_be.user;

import com.alibou.books_marketplace_be.book.Book;
import com.alibou.books_marketplace_be.common.AbstractEntity;
import com.alibou.books_marketplace_be.order.Order;
import com.alibou.books_marketplace_be.rate.Rate;
import com.alibou.books_marketplace_be.role.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "USERS")
public class User extends AbstractEntity {
    private String keycloakId;
    private String fullName;
    private String email;
    private String password;
    private String phone;
    @Enumerated
    private Role role;
    @OneToMany(mappedBy = "user")
    private List<Book> books;
    @OneToMany(mappedBy = "buyer")
    private List<Order> orders;
    @OneToMany(mappedBy = "buyer")
    private List<Rate> ratings;
    @ManyToMany
    @JoinTable(
            name = "wishlist",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> favoriteBooks;



}
