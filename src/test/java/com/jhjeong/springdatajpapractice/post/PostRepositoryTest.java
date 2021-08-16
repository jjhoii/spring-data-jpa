package com.jhjeong.springdatajpapractice.post;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class PostRepositoryTest {

  @Autowired
  private PostRepository postRepository;

  @Test
  public void crud() {
    // given
    String title = "Spring Data JPA";
    Post post = new Post();
    post.setTitle(title);

    // when
    postRepository.save(post);
    List<Post> all = postRepository.findAll();
    Post one = all.get(0);

    // then
    assertThat(one.getTitle()).isEqualTo(title);
  }

  @Test
  public void findByTitleStartsWith() {
    // given
    String title = "Spring Data JPA";
    Post post = new Post();
    post.setTitle(title);

    // when
    postRepository.save(post);
    List<Post> all = postRepository.findByTitleStartsWith("Spring");
    Post one = all.get(0);

    // then
    assertThat(one.getTitle()).isEqualTo(title);
  }

  @Test
  public void findByTitleNamedQuery() {
    // given
    String title = "Spring Data JPA";
    Post post = new Post();
    post.setTitle(title);

    // when
    postRepository.save(post);
    List<Post> all = postRepository.findByTitleNamedQuery(title);
    Post one = all.get(0);

    // then
    assertThat(one.getTitle()).isEqualTo(title);
  }

  @Test
  public void findByTitleQuery() {
    // given
    String title = "Spring Data JPA";
    Post post = new Post();
    post.setTitle(title);

    // when
    postRepository.save(post);
    List<Post> all = postRepository.findByTitleQuery(title);
    Post one = all.get(0);

    // then
    assertThat(one.getTitle()).isEqualTo(title);
  }
}