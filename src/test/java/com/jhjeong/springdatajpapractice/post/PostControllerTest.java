package com.jhjeong.springdatajpapractice.post;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
// @ActiveProfiles("test") // 다른 프로파일을 사용할 경우
class PostControllerTest {

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void getPost() throws Exception {
    Post post = new Post();
    post.setTitle("Spring Data JPA");
    postRepository.save(post);


    mockMvc.perform(get("/posts/" + post.getId()))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string("Spring Data JPA"));
  }
}