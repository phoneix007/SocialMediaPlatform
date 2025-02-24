package com.spring.socialMedia.repository;

import com.spring.socialMedia.model.SocialUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialUserRepo extends JpaRepository<SocialUser, Long> {
}
