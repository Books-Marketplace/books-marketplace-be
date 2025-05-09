package com.alibou.books_marketplace_be.user;

import com.alibou.books_marketplace_be.book.Book;
import com.alibou.books_marketplace_be.common.AbstractEntity;
import com.alibou.books_marketplace_be.order.Order;
import com.alibou.books_marketplace_be.payment.Payment;
import com.alibou.books_marketplace_be.shippingaddress.ShippingAddress;
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
@Table(name = "USERS_INFORMATION")
public class UserInformation extends AbstractEntity {
    @Column(unique = true)
    private String fullName;
    @Column(unique = true)
    private String email;
    private String phone;
    @OneToMany(mappedBy = "buyer")
    private List<Order> orders;
    @ManyToMany
    @JoinTable(
            name = "wishlist",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> whishlist;
    @OneToMany(mappedBy = "shippingAddress")
    private List<ShippingAddress> shippingAddress;
    @OneToMany(mappedBy = "payment")
    private List<Payment> card;


}
