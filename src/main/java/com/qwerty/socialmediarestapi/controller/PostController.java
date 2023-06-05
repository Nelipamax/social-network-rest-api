package com.qwerty.socialmediarestapi.controller;

import com.qwerty.socialmediarestapi.model.Post;
import com.qwerty.socialmediarestapi.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<String> createPost(@RequestParam(value = "file1", required = false) MultipartFile file1,
                                        @RequestParam(value = "file2", required = false) MultipartFile file2,
                                        @RequestParam(value = "file3", required = false) MultipartFile file3,
                                        @RequestHeader("Authorization") String token,
                                        Post post) throws IOException {
        postService.saveProduct(post, token, file1, file2, file3);
        return ResponseEntity.ok("Post successfully created");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updatePost(@RequestParam(value = "file1", required = false) MultipartFile file1,
                                             @RequestParam(value = "file2", required = false) MultipartFile file2,
                                             @RequestParam(value = "file3", required = false) MultipartFile file3,
                                             @RequestHeader("Authorization") String token,
                                             Post post, @PathVariable long id ) {

        return ResponseEntity.ok("Post successfully updated");
    }
}
