package com.spring.socialMedia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JsonIgnore
    private SocialUser user;

    public void setUser(SocialUser user) {
        this.user = user;
        if (user != null && user.getProfile() == null) {  // Prevent infinite loop
            user.setProfile(this);
        }
    }
}
