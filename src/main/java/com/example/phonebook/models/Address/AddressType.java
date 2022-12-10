package com.example.phonebook.models.Address;

import com.example.phonebook.models.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address_type")
public class AddressType extends BaseEntity {


    @Column (name = "name")
    private String name;

    @OneToMany(mappedBy = "addressType")
    private List<Address> address;

}
