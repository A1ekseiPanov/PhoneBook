package com.example.phonebook.models.Post;

import com.example.phonebook.models.BaseEntity;
import com.example.phonebook.models.Organisation.Organisation;
import com.example.phonebook.models.Person.Person;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "post")
public class Post extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "posts")
    private List<Organisation> organisation;

    @OneToMany(mappedBy = "post",fetch = FetchType.EAGER)
    private List<Person> users;
}
