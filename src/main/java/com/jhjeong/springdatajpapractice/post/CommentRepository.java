package com.jhjeong.springdatajpapractice.post;

import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

  @EntityGraph(attributePaths = "post", type = EntityGraphType.LOAD)
  Comment getById(Long id);

  List<CommentSummary> findByPost_Id(Long id);
}
