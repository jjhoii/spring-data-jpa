package com.jhjeong.springdatajpapractice;

import com.jhjeong.springdatajpapractice.post.Account;
import java.util.Optional;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Service;

@Service
public class AccountAuditAware implements AuditorAware<Account> {

  @Override
  public Optional<Account> getCurrentAuditor() {
    System.out.println("check user");
    return Optional.empty();
  }
}
