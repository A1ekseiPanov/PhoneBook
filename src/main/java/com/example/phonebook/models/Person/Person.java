package com.example.phonebook.models.Person;

import com.example.phonebook.models.Address.Address;
import com.example.phonebook.models.BaseEntity;
import com.example.phonebook.models.Email1.Email;
import com.example.phonebook.models.Organisation.Organisation;
import com.example.phonebook.models.Phone.Phone;
import com.example.phonebook.models.Post.Post;
import com.example.phonebook.security.User;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "person")
public class Person extends BaseEntity {

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
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateOfBirthday;


    @OneToMany(mappedBy = "user")
    private List<Email> email;

    @OneToMany(mappedBy = "user")
    private List<Phone> phone;

    @OneToMany(mappedBy = "user" )
    private List<Address> address;

    @ManyToOne
    @JoinColumn(name = "organisation_id", referencedColumnName = "id")
    private Organisation organisation;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Post post;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;



}
