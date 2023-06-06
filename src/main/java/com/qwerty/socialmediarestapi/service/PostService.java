package com.qwerty.socialmediarestapi.service;

import com.qwerty.socialmediarestapi.model.Image;
import com.qwerty.socialmediarestapi.model.Post;
import com.qwerty.socialmediarestapi.model.User;
import com.qwerty.socialmediarestapi.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final ImageService imageService;

    public void savePost(Post post, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        Image image1;
        Image image2;
        Image image3;
        if (file1.getSize() != 0) {
            image1 = imageService.toImageEntity(file1);
            post.addImageToPost(image1);
        }
        if (file1.getSize() != 0) {
            image2 = imageService.toImageEntity(file1);
            post.addImageToPost(image2);
        }
        if (file1.getSize() != 0) {
            image3 = imageService.toImageEntity(file1);
            post.addImageToPost(image3);
        }
        post.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        postRepository.save(post);
    }

    public void updatePostById(Post post, Long postId, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        Post oldPost = postRepository.findById(postId).orElseThrow();
        Long currentUserId = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        if (oldPost.getUser().getId().equals(currentUserId)) {
        Image image1;
        Image image2;
        Image image3;
        if (file1.getSize() != 0) {
            image1 = imageService.toImageEntity(file1);
            oldPost.addImageToPost(image1);
        }
        if (file1.getSize() != 0) {
            image2 = imageService.toImageEntity(file1);
            oldPost.addImageToPost(image2);
        }
        if (file1.getSize() != 0) {
            image3 = imageService.toImageEntity(file1);
            oldPost.addImageToPost(image3);
        }
        oldPost.setTitle(post.getTitle());
        oldPost.setDescription(post.getDescription());
        postRepository.save(oldPost);
        } else throw new RuntimeException("It's not your post");
    }

    public void deletePostById(Long id){
        postRepository.deleteById(id);
    }
    public List<Post> getPostsByUserID(Long id) {
        return postRepository.getPostsByUserId(id);
    }
}
