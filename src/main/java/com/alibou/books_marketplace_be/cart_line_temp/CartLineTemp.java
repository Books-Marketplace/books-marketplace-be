package com.alibou.books_marketplace_be.cart_line_temp;

import com.alibou.books_marketplace_be.common.AbstractEntity;
import com.alibou.books_marketplace_be.order.Order;
import com.alibou.books_marketplace_be.user.UserInformation;
import jakarta.persistence.*;

@Entity
public class CartLineTemp extends AbstractEntity {
    private Order orders;
    private UserInformation users;

}
