package com.jhjeong.springdatajpapractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "accountAuditAware") // 빈 이름으로 등록
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
