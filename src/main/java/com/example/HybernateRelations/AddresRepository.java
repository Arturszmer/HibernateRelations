package com.example.HybernateRelations;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddresRepository extends JpaRepository<Addres, Long> {

    Optional<Addres> findByStreet(String street);

}
