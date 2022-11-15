package com.example.phonebook.model.Organisation;

import com.example.phonebook.model.BaseEntity;
import com.example.phonebook.model.User.User;
import com.example.phonebook.model.Post.UserPost;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "organisation")
public class Organisation extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "organisation")
    private List<UserPost> usersPosts;

    @OneToMany(mappedBy = "organisation")
    private List<User> user;


}
