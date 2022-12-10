package com.example.phonebook.models.Phone;

import com.example.phonebook.models.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "phone_type")
public class PhoneType extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "phoneType")
    private List<Phone> phoneNumber;
}
