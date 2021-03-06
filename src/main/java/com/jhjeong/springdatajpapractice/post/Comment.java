package com.jhjeong.springdatajpapractice.post;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Comment {

  @Id
  @GeneratedValue
  private Long id;

  private String comment;

  @ManyToOne(fetch = FetchType.LAZY)
  private Post post;

  private int up;

  private int down;

  private boolean best;

  @CreatedDate
  private Date created;

  @CreatedBy
  @ManyToOne
  private Account createdBy;

  @LastModifiedDate
  private Date updatedd;

  @LastModifiedBy
  @ManyToOne
  private Account updatedBy;

  public int getUp() {
    return up;
  }

  public void setUp(int up) {
    this.up = up;
  }

  public int getDown() {
    return down;
  }

  public void setDown(int down) {
    this.down = down;
  }

  public boolean isBest() {
    return best;
  }

  public void setBest(boolean best) {
    this.best = best;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Post getPost() {
    return post;
  }

  public void setPost(Post post) {
    this.post = post;
  }
}
