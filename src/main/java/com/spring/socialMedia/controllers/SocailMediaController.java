package com.spring.socialMedia.controllers;

import com.spring.socialMedia.model.SocialUser;
import com.spring.socialMedia.service.SocialMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SocailMediaController {

    @Autowired
    private SocialMediaService socialMediaService;

    @GetMapping("/users")
    public ResponseEntity<List<SocialUser>> getUsers(){
        return new ResponseEntity<>(socialMediaService.getUsers() ,HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<SocialUser> addUser(@RequestBody SocialUser user){
        return new ResponseEntity<>(socialMediaService.saveUser(user), HttpStatus.CREATED);
    }
}
