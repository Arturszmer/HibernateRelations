package com.example.HybernateRelations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
class AddressRepositoryTest {

    @Autowired
    AdressRepository adressRepository;
    @Autowired
    PersonRepository personRepository;

    @Test
    public void addPersonAndAddres(){
    //given
    Address address1 = new Address("Sosnowiec", "Staszica", "41-200", "12/5",
            new Person("Artur", "Szmer", 33, new Address()));
    //when

    //then
    }


}