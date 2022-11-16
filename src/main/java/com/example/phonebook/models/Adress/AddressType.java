package com.example.phonebook.models.Adress;

import com.example.phonebook.models.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "address_type")
public class AddressType extends BaseEntity {


    @Column (name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

}
