package com.example.phonebook.models.Email1;

import com.example.phonebook.models.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "email_type")
public class EmailType extends BaseEntity {


    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "emailType")
    private List<Email> email;

}
