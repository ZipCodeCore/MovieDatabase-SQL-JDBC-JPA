package io.zipcoder.persistenceapp.humans.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.zipcoder.persistenceapp.humans.model.Person;
import io.zipcoder.persistenceapp.humans.service.PersonService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class PersonControllerTest {

    @MockBean
    private PersonService personService;

    @InjectMocks
    private PersonController personController;
    private MockMvc mvc;

    private Long personId;
    private Person person;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        personController = new PersonController(personService);
        mvc = MockMvcBuilders.standaloneSetup(personController).build();
        personId = 13245363L;
        person = new Person();
        person.setId(personId);
    }

    @Test
    public void testCreatePerson() throws Exception {
        String predictedEntity = new ObjectMapper().writeValueAsString(person);

        when(personService.createPerson(person))
                .thenReturn(person);

        mvc.perform(post("/people")
            .contentType(MediaType.APPLICATION_JSON)
            .content(predictedEntity))
            .andExpect(status().isCreated());

        /**
         * Find out how to verify business logic (either retrieve a representation of the Person object
         * from the mockMvc response or verify that the service was called once)
         * */
//        verify(personService, times(1))
//                .createPerson(eq(person));

    }

}
