package com.example.phonebook.repositories;

import com.example.phonebook.models.Phone.PhoneType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneTypeRepository extends JpaRepository<PhoneType,Long> {
}
