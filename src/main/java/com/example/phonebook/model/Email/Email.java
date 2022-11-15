package com.example.phonebook.model.Email;

import com.example.phonebook.model.BaseEntity;
import com.example.phonebook.model.User.User;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "email")
public class Email extends BaseEntity {
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "email")
    private List<EmailType> emailType;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

}
