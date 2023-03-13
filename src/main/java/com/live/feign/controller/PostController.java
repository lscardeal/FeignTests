package com.live.feign.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.live.feign.DTO.PostDTO;
import com.live.feign.clientFeign.PostClient;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    private PostClient postClient;

    @GetMapping
    public List<PostDTO> getAllPosts() {
        return postClient.getAllPosts();
    }

    @GetMapping(value = "/{id}")
    public PostDTO getPostById(@PathVariable Integer id) {
        return postClient.getPostById(id);
    }

    @PostMapping
    public ResponseEntity<String> postPost(@RequestBody PostDTO post) {
        return postClient.postPosts(post);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> putPost(@PathVariable Integer id, @RequestBody PostDTO post) {
        return postClient.putPost(id, post);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Integer id) {
        return postClient.deletePost(id);
    } 
}