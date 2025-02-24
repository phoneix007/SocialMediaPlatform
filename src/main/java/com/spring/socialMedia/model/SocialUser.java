package com.spring.socialMedia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "user" , cascade = CascadeType.ALL)
    private Profile profile;

    @OneToMany(mappedBy = "user")
    List<Post> posts = new ArrayList<>();

    @ManyToMany
            @JoinTable(
                    name = "user_group",
                    joinColumns = @JoinColumn(name = "user_id"),
                    inverseJoinColumns = @JoinColumn(name = "group_id")
            )

    Set<SocialGroup> groups = new HashSet<>();

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
        if (profile != null && profile.getUser() == null) { // Prevent infinite recursion
            profile.setUser(this);
        }
    }
}
