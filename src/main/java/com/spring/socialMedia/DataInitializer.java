package com.spring.socialMedia;

import com.spring.socialMedia.model.Post;
import com.spring.socialMedia.model.Profile;
import com.spring.socialMedia.model.SocialGroup;
import com.spring.socialMedia.model.SocialUser;
import com.spring.socialMedia.repository.SocialGroupRepo;
import com.spring.socialMedia.repository.SocialPostRepo;
import com.spring.socialMedia.repository.SocialProfileRepo;
import com.spring.socialMedia.repository.SocialUserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    private final SocialUserRepo userRepository;
    private final SocialGroupRepo groupRepository;
    private final SocialProfileRepo socialProfileRepository;
    private final SocialPostRepo postRepository;

    public DataInitializer(SocialUserRepo userRepository, SocialGroupRepo groupRepository, SocialProfileRepo socialProfileRepository, SocialPostRepo postRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.socialProfileRepository = socialProfileRepository;
        this.postRepository = postRepository;
    }

    @Bean
    public CommandLineRunner initializeData() {
        return args -> {
            // Create some users
            SocialUser user1 = new SocialUser();
            SocialUser user2 = new SocialUser();
            SocialUser user3 = new SocialUser();

            // Save users to the database
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);

            // Create some groups
            SocialGroup group1 = new SocialGroup();
            SocialGroup group2 = new SocialGroup();

            // Add users to groups
            group1.getUsers().add(user1);
            group1.getUsers().add(user2);

            group2.getUsers().add(user2);
            group2.getUsers().add(user3);

            // Save groups to the database
            groupRepository.save(group1);
            groupRepository.save(group2);

            // Associate users with groups
            user1.getGroups().add(group1);
            user2.getGroups().add(group1);
            user2.getGroups().add(group2);
            user3.getGroups().add(group2);

            // Save users back to database to update associations
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);


            // Create some posts
            Post post1 = new Post();
            Post post2 = new Post();
            Post post3 = new Post();

            // Associate posts with users
            post1.setUser(user1);
            post2.setUser(user2);
            post3.setUser(user3);

            // Save posts to the database (assuming you have a PostRepository)
            postRepository.save(post1);
            postRepository.save(post2);
            postRepository.save(post3);

            // Create some social profiles
            Profile profile1 = new Profile();
            Profile profile2 = new Profile();
            Profile profile3 = new Profile();

            // Associate profiles with users
            profile1.setUser(user1);
            profile2.setUser(user2);
            profile3.setUser(user3);

            // Save profiles to the database (assuming you have a SocialProfileRepository)
            socialProfileRepository.save(profile1);
            socialProfileRepository.save(profile2);
            socialProfileRepository.save(profile3);

            user1.setProfile(profile1);
            user2.setProfile(profile2);
            user3.setProfile(profile3);
//
//            userRepository.save(user1);
//            userRepository.save(user2);
//            userRepository.save(user3);


        };
    }
}

