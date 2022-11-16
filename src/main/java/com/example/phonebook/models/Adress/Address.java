package com.example.phonebook.models.Adress;

import com.example.phonebook.models.BaseEntity;
import com.example.phonebook.models.User.User;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "address")
public class Address extends BaseEntity {



    @Column(name = "name")
    private String address;

    @OneToMany(mappedBy = "address")
    private List<AddressType> addressType;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
