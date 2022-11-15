package com.example.phonebook.model.Adress;

import com.example.phonebook.model.BaseEntity;
import com.example.phonebook.model.User.User;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "address")
public class Address extends BaseEntity {

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "address")
    private List<AddressType> addressType;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;
}
