package com.alibou.books_marketplace_be.user;

import com.alibou.books_marketplace_be.book.Book;
import com.alibou.books_marketplace_be.common.AbstractEntity;
import com.alibou.books_marketplace_be.order.Order;
import com.alibou.books_marketplace_be.rate.Rate;
import com.alibou.books_marketplace_be.role.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotNull
    @Column(unique = true)
    private String keycloakId;
    @NotBlank
    @Size(min = 2)
    private String fullName;
    @NotBlank
    @Email
    @Column(unique = true)
    private String email;
    @NotBlank
    @Size(min = 8)
    private String password;
    private String phone;
    @Enumerated
    private Role role;
    @OneToMany(mappedBy = "admin")
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
