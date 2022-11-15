package com.example.phonebook.model.Phone;

import com.example.phonebook.model.BaseEntity;
import com.example.phonebook.model.User.User;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "phone")
public class Phone extends BaseEntity {

    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "phoneNumber")
    private List <PhoneType> phoneTypes;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;
}
