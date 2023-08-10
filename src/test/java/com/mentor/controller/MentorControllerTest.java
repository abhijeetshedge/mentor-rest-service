package com.mentor.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.mentor.model.Category;
import com.mentor.model.Mentor;
import com.mentor.model.Skill;
import com.mentor.service.MentorService;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {MentorController.class})
@ExtendWith(SpringExtension.class)
class MentorControllerTest {
    @Autowired
    private MentorController mentorController;

    @MockBean
    private MentorService mentorService;

    /**
     * Method under test: {@link MentorController#logInMentor(Map)}
     */
    @Test
    void testLogInMentor() throws Exception {
        when(mentorService.verifyLogInDetails(Mockito.<Map<String, String>>any())).thenReturn("Verify Log In Details");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/mentor/login");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(mentorController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(500))
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Verify Log In Details"));
    }

    /**
     * Method under test: {@link MentorController#registerMentor(Mentor)}
     */
    @Test
    void testRegisterMentor() throws UnsupportedEncodingException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Java 8 date/time type `java.time.LocalDateTime` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling (through reference chain: com.mentor.model.Mentor["createdAt"])
        //       at com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(InvalidDefinitionException.java:77)
        //       at com.fasterxml.jackson.databind.SerializerProvider.reportBadDefinition(SerializerProvider.java:1308)
        //       at com.fasterxml.jackson.databind.ser.impl.UnsupportedTypeSerializer.serialize(UnsupportedTypeSerializer.java:35)
        //       at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:732)
        //       at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:772)
        //       at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:178)
        //       at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider._serialize(DefaultSerializerProvider.java:479)
        //       at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.serializeValue(DefaultSerializerProvider.java:318)
        //       at com.fasterxml.jackson.databind.ObjectMapper._writeValueAndClose(ObjectMapper.java:4719)
        //       at com.fasterxml.jackson.databind.ObjectMapper.writeValueAsString(ObjectMapper.java:3964)
        //   See https://diff.blue/R013 to resolve this issue.

        MentorController mentorController = new MentorController();

        Category category = new Category();
        category.setCategory("Category");
        category.setCategoryId(1);

        Mentor mentor = new Mentor();
        mentor.setActive(true);
        mentor.setBio("Bio");
        mentor.setCategory(category);
        mentor.setCompany("Company");
        mentor.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        mentor.setEmail("jane.doe@example.org");
        mentor.setEmployeeId(1);
        mentor.setFirstName("Jane");
        mentor.setGender("Gender");
        mentor.setImage("AXAXAXAX".getBytes("UTF-8"));
        mentor.setJobTitle("Dr");
        mentor.setLastName("Doe");
        mentor.setLocation("Location");
        mentor.setPassword("iloveyou");
        mentor.setSkills(new ArrayList<>());
        ResponseEntity<Object> actualRegisterMentorResult = mentorController.registerMentor(mentor);
        assertEquals("Cannot invoke \"com.mentor.service.MentorService.registerMentor(com.mentor.model.Mentor)\" because"
                + " \"this.mentorService\" is null", actualRegisterMentorResult.getBody());
        assertEquals(409, actualRegisterMentorResult.getStatusCodeValue());
        assertTrue(actualRegisterMentorResult.getHeaders().isEmpty());
    }

    /**
     * Method under test: {@link MentorController#registerMentor(Mentor)}
     */
    @Test
    void testRegisterMentor2() throws UnsupportedEncodingException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Java 8 date/time type `java.time.LocalDateTime` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling (through reference chain: com.mentor.model.Mentor["createdAt"])
        //       at com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(InvalidDefinitionException.java:77)
        //       at com.fasterxml.jackson.databind.SerializerProvider.reportBadDefinition(SerializerProvider.java:1308)
        //       at com.fasterxml.jackson.databind.ser.impl.UnsupportedTypeSerializer.serialize(UnsupportedTypeSerializer.java:35)
        //       at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:732)
        //       at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:772)
        //       at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:178)
        //       at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider._serialize(DefaultSerializerProvider.java:479)
        //       at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.serializeValue(DefaultSerializerProvider.java:318)
        //       at com.fasterxml.jackson.databind.ObjectMapper._writeValueAndClose(ObjectMapper.java:4719)
        //       at com.fasterxml.jackson.databind.ObjectMapper.writeValueAsString(ObjectMapper.java:3964)
        //   See https://diff.blue/R013 to resolve this issue.

        MentorController mentorController = new MentorController();

        Category category = new Category();
        category.setCategory("Category");
        category.setCategoryId(1);
        Mentor mentor = mock(Mentor.class);
        doNothing().when(mentor).setActive(anyBoolean());
        doNothing().when(mentor).setBio(Mockito.<String>any());
        doNothing().when(mentor).setCategory(Mockito.<Category>any());
        doNothing().when(mentor).setCompany(Mockito.<String>any());
        doNothing().when(mentor).setCreatedAt(Mockito.<LocalDateTime>any());
        doNothing().when(mentor).setEmail(Mockito.<String>any());
        doNothing().when(mentor).setEmployeeId(anyInt());
        doNothing().when(mentor).setFirstName(Mockito.<String>any());
        doNothing().when(mentor).setGender(Mockito.<String>any());
        doNothing().when(mentor).setImage(Mockito.<byte[]>any());
        doNothing().when(mentor).setJobTitle(Mockito.<String>any());
        doNothing().when(mentor).setLastName(Mockito.<String>any());
        doNothing().when(mentor).setLocation(Mockito.<String>any());
        doNothing().when(mentor).setPassword(Mockito.<String>any());
        doNothing().when(mentor).setSkills(Mockito.<List<Skill>>any());
        mentor.setActive(true);
        mentor.setBio("Bio");
        mentor.setCategory(category);
        mentor.setCompany("Company");
        mentor.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        mentor.setEmail("jane.doe@example.org");
        mentor.setEmployeeId(1);
        mentor.setFirstName("Jane");
        mentor.setGender("Gender");
        mentor.setImage("AXAXAXAX".getBytes("UTF-8"));
        mentor.setJobTitle("Dr");
        mentor.setLastName("Doe");
        mentor.setLocation("Location");
        mentor.setPassword("iloveyou");
        mentor.setSkills(new ArrayList<>());
        ResponseEntity<Object> actualRegisterMentorResult = mentorController.registerMentor(mentor);
        assertEquals("Cannot invoke \"com.mentor.service.MentorService.registerMentor(com.mentor.model.Mentor)\" because"
                + " \"this.mentorService\" is null", actualRegisterMentorResult.getBody());
        assertEquals(409, actualRegisterMentorResult.getStatusCodeValue());
        assertTrue(actualRegisterMentorResult.getHeaders().isEmpty());
        verify(mentor).setActive(anyBoolean());
        verify(mentor).setBio(Mockito.<String>any());
        verify(mentor).setCategory(Mockito.<Category>any());
        verify(mentor).setCompany(Mockito.<String>any());
        verify(mentor).setCreatedAt(Mockito.<LocalDateTime>any());
        verify(mentor).setEmail(Mockito.<String>any());
        verify(mentor).setEmployeeId(anyInt());
        verify(mentor).setFirstName(Mockito.<String>any());
        verify(mentor).setGender(Mockito.<String>any());
        verify(mentor).setImage(Mockito.<byte[]>any());
        verify(mentor).setJobTitle(Mockito.<String>any());
        verify(mentor).setLastName(Mockito.<String>any());
        verify(mentor).setLocation(Mockito.<String>any());
        verify(mentor).setPassword(Mockito.<String>any());
        verify(mentor).setSkills(Mockito.<List<Skill>>any());
    }

    /**
     * Method under test: {@link MentorController#logInMentor(Map)}
     */
    @Test
    void testLogInMentor2() throws Exception {
        when(mentorService.verifyLogInDetails(Mockito.<Map<String, String>>any())).thenReturn("Valid User");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/mentor/login");
        MockMvcBuilders.standaloneSetup(mentorController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Valid User"));
    }

    /**
     * Method under test: {@link MentorController#logInMentor(Map)}
     */
    @Test
    void testLogInMentor3() throws Exception {
        when(mentorService.verifyLogInDetails(Mockito.<Map<String, String>>any())).thenReturn("Wrong Password");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/mentor/login");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(mentorController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(401))
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Wrong Password"));
    }

    /**
     * Method under test: {@link MentorController#logInMentor(Map)}
     */
    @Test
    void testLogInMentor4() throws Exception {
        when(mentorService.verifyLogInDetails(Mockito.<Map<String, String>>any()))
                .thenReturn("User doesn't exist with given username");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/mentor/login");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(mentorController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(401))
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("User doesn't exist with given username"));
    }
}

