package com.example.phonebook.models.User;

import com.example.phonebook.models.Adress.Address;
import com.example.phonebook.models.BaseEntity;
import com.example.phonebook.models.Email.Email;
import com.example.phonebook.models.Organisation.Organisation;
import com.example.phonebook.models.Phone.Phone;
import com.example.phonebook.models.Post.UserPost;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "user")
public class User extends BaseEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "image_url")
    private String image_url;

    @Column(name = "date_of_birthday")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy") //дд/мм/гггг
    private Date dateOfBirthday;

    @OneToMany(mappedBy = "user")
    private List<Email> email;

    @OneToMany(mappedBy = "user")
    private List<Phone> phone;

    @OneToMany(mappedBy = "user")
    private List<Address> address;

    @ManyToOne
    @JoinColumn(name = "organisation_id", referencedColumnName = "id")
    private Organisation organisation;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private UserPost post;

    @Column(name = "password")
    private String password;

    @Column(name = "comment")
    private String comment;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;




}
