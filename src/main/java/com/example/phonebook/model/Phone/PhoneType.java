package com.example.phonebook.model.Phone;

import com.example.phonebook.model.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "phone-type")
public class PhoneType extends BaseEntity {

    @Column(name = "name")
    private String name;


    @ManyToOne
    @JoinColumn(name = "phone_id", referencedColumnName = "id")
    private Phone phoneNumber;
}
