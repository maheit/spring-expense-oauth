package com.maheit.expense.service;

import com.maheit.expense.entity.*;

import java.util.List;

import javax.transaction.Transactional;

import com.maheit.expense.repository.BlogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BlogService {

    @Autowired
    private BlogRepository blogDB;

    public List<Blog> getAllBlog() {
        return blogDB.findAll();
    }

    public void insertBlog(Blog blog) {
        blogDB.save(blog);
    }

}