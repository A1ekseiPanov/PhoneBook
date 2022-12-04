package com.example.phonebook.models.Email1;

import com.example.phonebook.models.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "email_type")
public class EmailType extends BaseEntity {


    @Column(name = "name")
    private String name;

    @ManyToOne()
    @JoinColumn(name = "email_id", referencedColumnName = "id")
    private Email email;

}
