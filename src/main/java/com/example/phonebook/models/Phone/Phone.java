package com.example.phonebook.models.Phone;

import com.example.phonebook.models.BaseEntity;
import com.example.phonebook.models.Person.Person;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "phone")
public class Phone extends BaseEntity implements Serializable {

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "phoneNumber")
    private List <PhoneType> phoneTypes;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person user;
}
