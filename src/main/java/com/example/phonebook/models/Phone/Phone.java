package com.example.phonebook.models.Phone;

import com.example.phonebook.models.BaseEntity;
import com.example.phonebook.models.Person.Person;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "phone")
public class Phone extends BaseEntity implements Serializable {

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne()
    @JoinColumn(name ="phonetype_id", referencedColumnName = "id")
    private PhoneType phoneType;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person user;
}
