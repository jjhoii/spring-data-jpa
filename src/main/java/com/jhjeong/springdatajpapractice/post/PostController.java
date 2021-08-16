package com.jhjeong.springdatajpapractice.post;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostController {

  private final PostRepository postRepository;

  @GetMapping("/posts/{id}")
  public String getPost(@PathVariable Long id) {
    Optional<Post> byId = postRepository.findById(id);
    return byId.get().getTitle();
  }
}
