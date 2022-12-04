package com.example.phonebook.models.Adress;

import com.example.phonebook.models.BaseEntity;
import com.example.phonebook.models.Person.Person;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "address")
public class Address extends BaseEntity  implements Serializable {



    @Column(name = "name")
    private String address;

    @OneToMany(mappedBy = "address")
    private List<AddressType> addressType;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person user;
}
