package com.example.phonebook.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Transient
    @CreationTimestamp
    @Column(name = "created")
    private LocalDateTime created;
    @Transient
    @UpdateTimestamp
    @Column(name = "updated")
    private LocalDateTime updated;

}
