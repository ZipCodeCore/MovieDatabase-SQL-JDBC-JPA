package io.zipcoder.persistenceapp.humans.service;

import io.zipcoder.persistenceapp.humans.model.Person;
import io.zipcoder.persistenceapp.humans.repository.PersonRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    private PersonService personService;
    private Long personId;
    private Person person;

    @Before
    public void init() {
        personService = new PersonService(personRepository);
        personId = 12345L;
        person = new Person();
        person.setId(personId);
    }

    @Test
    public void testCreatePerson() {
        when(personRepository.save(person))
                .thenReturn(person);

        Person returnedPerson = personService.createPerson(person);

        Long returnedPersonId = returnedPerson.getId();
        Assert.assertEquals("The expected entity is not returned", personId, returnedPersonId);
    }

}
