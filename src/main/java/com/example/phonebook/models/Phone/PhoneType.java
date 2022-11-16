package com.example.phonebook.models.Phone;

import com.example.phonebook.models.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "phone_type")
public class PhoneType extends BaseEntity {

    @Column(name = "name")
    private String name;


    @ManyToOne
    @JoinColumn(name = "phone_id", referencedColumnName = "id")
    private Phone phoneNumber;
}
