package com.chess.controller;

import com.chess.dto.BlogRequestDTO;
import com.chess.model.Blog;
import com.chess.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
@RequiredArgsConstructor
public class BlogController {

    private  final BlogService blogService;


    @PostMapping
    public Blog createBlog(@RequestBody BlogRequestDTO blogDTO) {
        return blogService.createBlog(blogDTO);
    }

    @GetMapping
    public List<Blog> getAllBlogs() {
        return blogService.getAllBlogs();
    }

    @GetMapping("/{id}")
    public Blog getBlog(@PathVariable Long id) {
        return blogService.getBlogById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
        return "Blog deleted";
    }
    @PutMapping("/{id}")
    public Blog updateBlog(@PathVariable Long id, @RequestBody BlogRequestDTO blogDTO) {
        return blogService.updateBlog(id, blogDTO);
    }
    @GetMapping("/author/{authorId}")
    public List<Blog> getBlogsByAuthor(@PathVariable Long authorId) {
        return blogService.getBlogsByAuthor(authorId);
    }


}
