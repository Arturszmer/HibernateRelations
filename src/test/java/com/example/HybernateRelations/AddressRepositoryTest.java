package com.example.HybernateRelations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
    Person person = new Person("Andrzej", "Duda", 49);
    Address address1 = new Address("Sosnowiec", "Bankowa", "41-200", "25/2b");
    address1.setPerson(person);
    adressRepository.save(address1);
    //when
        List<Address> addressList = adressRepository.findAll();
        int size = 1;
    //then
        assertThat(addressList.size()).isEqualTo(size);
    }

    @Test
    public void removeUnusedEntity(){
    //given
        Person person = new Person("Andrzej", "Duda", 49);
        Address address1 = new Address("Sosnowiec", "Bankowa", "41-200", "25/2b");
        address1.setPerson(person);
        adressRepository.save(address1);
        Person person2 = new Person("Marian", "Duda", 50);
        Address address2 = new Address("Wrocław", "Wysoka", "40-500", "22/2b");
        address2.setPerson(person2);
        adressRepository.save(address2);
    //when
        address1.removePerson();
        List<Address> addressList = adressRepository.findAll();
        addressList.remove(address1);
        List<Person> personList = personRepository.findAll();
        int size = 1;
        //then
        assertThat(addressList.size()).isEqualTo(size);
    }


}