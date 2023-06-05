package com.qwerty.socialmediarestapi.repository;

import com.qwerty.socialmediarestapi.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface PostRepository extends JpaRepository<Post, Long> {
    public void savePostById();
}
