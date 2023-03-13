package com.live.feign.clientFeign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.live.feign.DTO.PostDTO;

@FeignClient(name = "post", url = "${api.post.url}")
public interface PostClient {

    @GetMapping(value = "/posts")
    List<PostDTO> getAllPosts();

    @GetMapping(value = "/posts/{id}")
    PostDTO getPostById(@RequestParam(value = "id") Integer id);

    @PostMapping(value = "/posts")
    ResponseEntity<String> postPosts(@RequestBody PostDTO post);

    @PutMapping(value = "/posts/{id}")
    ResponseEntity<String> putPost(@RequestParam(value = "id") Integer id, @RequestBody PostDTO post);

    @DeleteMapping(value = "/posts/{id}")
    ResponseEntity<String> deletePost(@RequestParam(value = "id") Integer id);
}
