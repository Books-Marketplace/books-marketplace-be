package com.alibou.books_marketplace_be.cart_line_temp;

import com.alibou.books_marketplace_be.common.AbstractEntity;
import com.alibou.books_marketplace_be.order.Order;
import com.alibou.books_marketplace_be.user.UserInformation;
import jakarta.persistence.*;

@Entity
public class CartLineTemp extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order orders;
    @ManyToOne
    @JoinTable(name = "user_information_id")
    private UserInformation users;

}
