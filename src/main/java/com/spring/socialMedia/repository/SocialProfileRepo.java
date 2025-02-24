package com.spring.socialMedia.repository;

import com.spring.socialMedia.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialProfileRepo extends JpaRepository<Profile , Long> {
}
