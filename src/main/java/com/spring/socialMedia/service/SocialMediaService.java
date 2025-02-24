package com.spring.socialMedia.service;

import com.spring.socialMedia.model.SocialUser;
import com.spring.socialMedia.repository.SocialGroupRepo;
import com.spring.socialMedia.repository.SocialPostRepo;
import com.spring.socialMedia.repository.SocialProfileRepo;
import com.spring.socialMedia.repository.SocialUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialMediaService {
    @Autowired
    SocialGroupRepo socialGroupRepo;
    @Autowired
    SocialUserRepo socialUserRepo;
    @Autowired
    SocialPostRepo socialPostRepo;
    @Autowired
    SocialProfileRepo socialProfileRepo;
    public List<SocialUser> getUsers() {
        return socialUserRepo.findAll();
    }
    public SocialUser saveUser(SocialUser socialUser) {
        return socialUserRepo.save(socialUser);
    }
}
