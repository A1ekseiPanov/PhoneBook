package com.example.phonebook.models.Email1;

import com.example.phonebook.models.BaseEntity;
import com.example.phonebook.models.Person.Person;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "email")
public class Email extends BaseEntity  implements Serializable {



    @Column(name = "email")
    private String name;

    @ManyToOne()
    @JoinColumn(name = "email_type_id", referencedColumnName = "id")
    private EmailType emailType;

    @ManyToOne()
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person user;

}
