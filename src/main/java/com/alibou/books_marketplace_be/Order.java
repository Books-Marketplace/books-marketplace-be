package com.alibou.books_marketplace_be;

import com.alibou.books_marketplace_be.book.Book;
import com.alibou.books_marketplace_be.common.AbstractEntity;
import com.alibou.books_marketplace_be.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order extends AbstractEntity {

    @Column(nullable = false)
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User buyer;
    @OneToMany
    private List<Book> books;

}
