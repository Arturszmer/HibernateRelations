package com.example.HybernateRelations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class AdressRepositoryTest {

    @Autowired
    AdressRepository adressRepository;
    @Autowired
    PersonRepository personRepository;

    @Test
    public void addToAddresses(){
    //given
        Person person1 = new Person("Artur", "Szmer", 25);
        Person person2 = new Person("Bartosz", "Grzesiak", 80);
        Adress adress1 = new Adress("Sosnowiec", "Wysoka", "41-200", "20b",
                new HashSet<>(Arrays.asList(person1, person2)));
    //when
        adressRepository.save(adress1);

        List<Adress> adress = adressRepository.findAll();
    //then
        assertThat(adress.size()).isEqualTo(1);
    }

    @Test
    public void changeLastName(){
    //given
        Person person1 = new Person("Artur", "Szmer", 25);
        Person person2 = new Person("Bartosz", "Grzesiak", 80);
        Adress adress1 = new Adress("Sosnowiec", "Wysoka", "41-200", "20b",
                new HashSet<>(Arrays.asList(person1, person2)));
        Adress prop1 = adressRepository.save(adress1);
        //when
        Person newLastName = prop1.getPerson().stream().filter(p -> p.getLastName().equals("Szmer")).findFirst().get();
        newLastName.setLastName("Bąk");
        //then
        assertThat(personRepository.findByLastName("Bąk").isPresent()).isTrue();
    }



}