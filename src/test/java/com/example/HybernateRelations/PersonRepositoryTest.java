package com.example.HybernateRelations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    AddresRepository addresRepository;



    @Test
    public void addPerson(){
    //given
    Addres adres1 = new Addres("Sosnowiec", "Staszica", "41-200", "14/1");
    Person person1 = new Person("Artur", "Szmer", 33, adres1);
    personRepository.save(person1);
    //when
        List<Person> person = personRepository.findAll();
        int size = 1;
    //then
        assertThat(person.size()).isEqualTo(size);
    }

    @Test
    public void removePerson(){
    //given
        Addres adres1 = new Addres("Sosnowiec", "Staszica", "41-200", "14/1");
        Person person1 = new Person("Artur", "Szmer", 33, adres1);
        personRepository.save(person1);
    //when
        List<Person> person = personRepository.findAll();
        person.remove(person1);
        //then
        assertThat(person.isEmpty());
    }
    @Test
    public void changeAddres(){
    //given
        Addres adres1 = new Addres("Sosnowiec", "Staszica", "41-200", "14/1");
        Person person1 = new Person("Artur", "Szmer", 33, adres1);
        Person save = personRepository.save(person1);
        //when
        save.getAdress().setStreet("Wysoka");
        Optional<Addres> person = addresRepository.findByStreet("Wysoka");
        //then
        assertThat(person.isPresent()).isTrue();
    }



}