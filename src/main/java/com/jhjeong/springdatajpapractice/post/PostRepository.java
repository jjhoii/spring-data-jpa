package com.jhjeong.springdatajpapractice.post;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {

  List<Post> findByTitleStartsWith(String title);

  List<Post> findByTitleNamedQuery(String title);

  @Query("SELECT p FROM Post AS p WHERE p.title = ?1")
  List<Post> findByTitleQuery(String title);
}
