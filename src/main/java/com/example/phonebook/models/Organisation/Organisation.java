package com.example.phonebook.models.Organisation;

import com.example.phonebook.models.BaseEntity;
import com.example.phonebook.models.Person.Person;
import com.example.phonebook.models.Post.Post;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "organisation")
public class Organisation extends BaseEntity {


    @Column(name = "name")
    private String name;

    @ManyToMany()
    @JoinTable(name = "organisation_post",
            joinColumns = @JoinColumn(name = "organisation_id"),
            inverseJoinColumns = @JoinColumn(name = "post_id"))
    private List<Post> posts;

    @OneToMany(mappedBy = "organisations")
    private List<Person> user;


}
