package com.alibou.books_marketplace_be.shippingaddress;

import com.alibou.books_marketplace_be.common.AbstractEntity;
import com.alibou.books_marketplace_be.order.Order;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "SHIPPING_ADDRESS")
public class ShippingAddress extends AbstractEntity {
    private String postalCode;
    private String city;
    private String country;
    private String street;
    @OneToMany(mappedBy = "order")
    private List<Order> orders;
}
