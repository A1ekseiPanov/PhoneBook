package com.example.phonebook.repositories;

import com.example.phonebook.models.Address.AddressType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressTypeRepository extends JpaRepository<AddressType,Long> {
}
