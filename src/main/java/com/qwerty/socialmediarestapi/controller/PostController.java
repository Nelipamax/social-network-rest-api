package com.qwerty.socialmediarestapi.controller;

import com.qwerty.socialmediarestapi.model.Post;
import com.qwerty.socialmediarestapi.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("users/{id}/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<String> createPost(@RequestParam(value = "file1", required = false) MultipartFile file1,
                                        @RequestParam(value = "file2", required = false) MultipartFile file2,
                                        @RequestParam(value = "file3", required = false) MultipartFile file3,
                                        Post post) throws IOException {
        postService.savePost(post, file1, file2, file3);
        return ResponseEntity.ok("Post successfully created");
    }

    @GetMapping()
    public ResponseEntity<List<Post>> getPostsByUserId(@PathVariable Long id){
        return ResponseEntity.ok(postService.getPostsByUserID(id));
    }

    @PatchMapping("/{postId}")
    public ResponseEntity<String> updatePost(@RequestParam(value = "file1", required = false) MultipartFile file1,
                                             @RequestParam(value = "file2", required = false) MultipartFile file2,
                                             @RequestParam(value = "file3", required = false) MultipartFile file3,
                                             Post post, @PathVariable Long postId ) throws IOException {
            postService.updatePostById(post, postId, file1, file2, file3);
        return ResponseEntity.ok("Post successfully updated");
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Long postId ) {
        postService.deletePostById(postId);
        return ResponseEntity.ok("Post successfully deleted");
    }
}
