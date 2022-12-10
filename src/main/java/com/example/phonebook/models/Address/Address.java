package com.example.phonebook.models.Address;

import com.example.phonebook.models.BaseEntity;
import com.example.phonebook.models.Person.Person;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "address")
public class Address extends BaseEntity  implements Serializable {



    @Column(name = "name")
    private String address;


    @ManyToOne()
    @JoinColumn(name = "adresstype_id",referencedColumnName = "id")
    private AddressType addressType;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person user;
}
