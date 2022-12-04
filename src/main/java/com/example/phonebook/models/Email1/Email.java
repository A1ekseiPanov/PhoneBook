package com.example.phonebook.models.Email1;

import com.example.phonebook.models.BaseEntity;
import com.example.phonebook.models.Person.Person;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "email")
public class Email extends BaseEntity  implements Serializable {



    @Column(name = "email")
    private String name;

    @OneToMany(mappedBy = "email")
    private List<EmailType> emailType;

    @ManyToOne()
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person user;

}
