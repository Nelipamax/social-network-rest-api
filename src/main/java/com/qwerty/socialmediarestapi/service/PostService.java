package com.qwerty.socialmediarestapi.service;

import com.qwerty.socialmediarestapi.model.Image;
import com.qwerty.socialmediarestapi.model.Post;
import com.qwerty.socialmediarestapi.repository.PostRepository;
import com.qwerty.socialmediarestapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;


@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final ImageService imageService;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    public void saveProduct(Post post, String token, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
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
         post.setUser(userRepository.findByEmail(jwtService.extractUserEmailFromJWT(token)).orElseThrow());
        postRepository.save(post);
    }

    public void updatePostById(Post post, long id, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
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
        postRepository.sa
        postRepository.save(post);
    }
}
