package com.example.phonebook.models.Phone;

import com.example.phonebook.models.BaseEntity;
import com.example.phonebook.models.User.User;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "phone")
public class Phone extends BaseEntity {

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "phoneNumber")
    private List <PhoneType> phoneTypes;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
