package com.example.phonebook.model.User;

import com.example.phonebook.model.Adress.Address;
import com.example.phonebook.model.BaseEntity;
import com.example.phonebook.model.Email.Email;
import com.example.phonebook.model.Organisation.Organisation;
import com.example.phonebook.model.Phone.Phone;
import com.example.phonebook.model.Post.UserPost;
import lombok.Data;

import javax.persistence.*;
import java.net.URL;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "image_url")
    private URL image_url;

    @Column(name = "date_of_birthday")
    private Date dateOfBirthday;

    @OneToMany(mappedBy = "user")
    private List<Email> email;

    @Column(name = "name")
    @OneToMany(mappedBy = "user")
    private List<Phone> phone;

    @Column(name = "name")
    @OneToMany(mappedBy = "user")
    private List<Address> address;

    @ManyToOne
    @JoinColumn(name = "organisation_id", referencedColumnName = "organisation_id")
    private Organisation organisation;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
    private UserPost post;

    @Column(name = "comment")
    private String comment;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;




}
