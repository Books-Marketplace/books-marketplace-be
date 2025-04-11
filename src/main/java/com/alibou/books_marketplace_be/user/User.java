package com.alibou.books_marketplace_be.user;

import com.alibou.books_marketplace_be.book.Book;
import com.alibou.books_marketplace_be.common.AbstractEntity;
import com.alibou.books_marketplace_be.role.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "USERS")
public class User extends AbstractEntity {

   private String keycloakId;
   @Column(nullable = false)
   private String userName;
   @Column(unique = true, nullable = false)
   private String email;
   @ManyToMany
   @JoinTable(
           name = "user_roles",
           joinColumns = @JoinColumn(name = "user_id"),
           inverseJoinColumns = @JoinColumn(name = "role_id")
   )
   private Set<Role> roles;
   //@OneToMany(mappedBy = "user")
   //private List<Order> orders;
   @OneToMany(mappedBy = "seller")
   private List<Book> books ;
   @Column(nullable = false)
   private String password;

}
