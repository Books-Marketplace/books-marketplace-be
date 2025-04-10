package com.alibou.books_marketplace_be.role;

import com.alibou.books_marketplace_be.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "ROLES")
public class Role {
    @Id
    @GeneratedValue
    private long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleName name;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();
}
