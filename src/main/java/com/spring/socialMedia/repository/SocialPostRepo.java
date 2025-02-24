package com.spring.socialMedia.repository;

import com.spring.socialMedia.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialPostRepo extends JpaRepository<Post, Long> {
}
