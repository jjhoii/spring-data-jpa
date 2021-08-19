package com.jhjeong.springdatajpapractice.post;

public interface CommentSummary {

  String getComment();

  int getUp();

  int getDown();

  // Open Projection (< java 8)
  // 최적화 X
  // @Value("#{target.up + ' ' + target.down}")
  // String getVotes();

  // Closed Projection (>= java 8)
  // 최적화 O
  default String getVotes() {
    return getUp() + " " + getDown();
  }
}
