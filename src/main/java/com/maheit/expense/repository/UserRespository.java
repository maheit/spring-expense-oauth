package com.maheit.expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.maheit.expense.entity.User;

@Repository
public interface UserRespository extends JpaRepository<User, Integer>{
    User findByEmail(String email);
}