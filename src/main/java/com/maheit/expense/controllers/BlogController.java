package com.maheit.expense.controllers;

import java.util.List;

import com.maheit.expense.entity.Blog;
import com.maheit.expense.model.Greeting;
import com.maheit.expense.service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blog")
    public List<Blog> greeting(@RequestParam(value = "name", defaultValue = "Mahesh") String name) {
        System.out.println(blogService.getAllBlog().toString() + "  ===========================================");
        Blog blog = new Blog("Test", "Checking");
        System.out.println(blog.getId() + " ###### " + blog.getTitle());
        blogService.insertBlog(blog);
        System.out.println(blogService.getAllBlog().toString() + "  ===========================================");

        List<Blog> data = blogService.getAllBlog();
        return data;
    }
}