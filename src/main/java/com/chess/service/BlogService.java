package com.chess.service;

import com.chess.dto.BlogRequestDTO;
import com.chess.model.Blog;
//import com.chess.model.Blog.;
import com.chess.model.User;
import com.chess.repository.BlogRepository;
import com.chess.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository ;
    private  final UserRepository userRepository ;


    public Blog createBlog(BlogRequestDTO blogDTO) {
        Optional<User> authorOpt = userRepository.findById(blogDTO.getAuthorId());
        if (authorOpt.isEmpty()) {
            throw new RuntimeException("Author not found");
        }

        Blog blog = Blog.builder()
                .title(blogDTO.getTitle())
                .content(blogDTO.getContent())
                .timestamp(LocalDateTime.now())
                .author(authorOpt.get())
                .build();

        return blogRepository.save(blog);
    }

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public Blog getBlogById(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog not found"));
    }

    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
    public Blog updateBlog(Long id, BlogRequestDTO blogDTO) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog not found"));

        blog.setTitle(blogDTO.getTitle());
        blog.setContent(blogDTO.getContent());
        blog.setTimestamp(LocalDateTime.now());

        return blogRepository.save(blog);
    }
    public List<Blog> getBlogsByAuthor(Long authorId) {
        return blogRepository.findByAuthorId(authorId);
    }


}
