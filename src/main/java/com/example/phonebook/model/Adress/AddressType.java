package com.example.phonebook.model.Adress;

import com.example.phonebook.model.BaseEntity;
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
