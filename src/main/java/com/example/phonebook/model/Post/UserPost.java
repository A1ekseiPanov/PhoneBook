package com.example.phonebook.model.Post;

import com.example.phonebook.model.BaseEntity;
import com.example.phonebook.model.Organisation.Organisation;
import com.example.phonebook.model.User.User;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "post")
public class UserPost extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name = "organisation_post",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "organisation_id"))
    private List<Organisation> organisation;

    @OneToMany(mappedBy = "post")
    private List<User> users;
}
