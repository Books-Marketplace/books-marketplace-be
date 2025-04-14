package com.alibou.books_marketplace_be.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

     boolean existsByEmail(String Email);
}
