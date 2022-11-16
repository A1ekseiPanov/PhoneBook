package com.example.phonebook.models.Email;

import com.example.phonebook.models.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "email_type")
public class EmailType extends BaseEntity {


    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "email_id", referencedColumnName = "id")
    private Email email;

}
