package com.jhjeong.springdatajpapractice.post;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CommentRepositoryTest {

  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  private PostRepository postRepository;

  @Test
  public void getComment() {
    // given
    Post post = new Post();
    post.setTitle("Spring Data JPA");
    post = postRepository.save(post);
    Comment comment = new Comment();
    comment.setComment("comment");
    comment.setPost(post);
    commentRepository.save(comment);

    // when
    List<Comment> all = commentRepository.findAll();
    Comment one = all.get(0);

    // then
    assertThat(one.getComment()).isEqualTo("comment");
    assertThat(one.getPost().getTitle()).isEqualTo("Spring Data JPA");
  }

  @Test
  public void getSomeComment() {
    // given
    Post post = new Post();
    post.setTitle("title");
    Post savedPost = postRepository.save(post);

    Comment comment = new Comment();
    comment.setComment("comment");
    comment.setUp(10);
    comment.setDown(5);
    comment.setBest(true);
    commentRepository.save(comment);

    // when
    commentRepository.findByPost_Id(savedPost.getId(), CommentSummary.class).forEach(commentSummary -> {
      // then
      assertThat(commentSummary.getComment()).isEqualTo("comment");
      assertThat(commentSummary.getUp()).isEqualTo(10);
      assertThat(commentSummary.getDown()).isEqualTo(5);
      assertThat(commentSummary.getVotes()).isEqualTo("10 5");
    });
  }
}