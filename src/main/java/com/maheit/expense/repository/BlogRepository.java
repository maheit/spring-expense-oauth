package com.maheit.expense.repository;

import java.util.List;

import com.maheit.expense.entity.Blog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByTitle(String title);
}