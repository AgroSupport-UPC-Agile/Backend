package com.agrosupport.api.appointment.interfaces.rest;

import com.agrosupport.api.appointment.interfaces.rest.resources.CreateReviewResource;
import com.agrosupport.api.appointment.interfaces.rest.resources.UpdateReviewResource;
import com.agrosupport.api.iam.domain.model.aggregates.User;
import com.agrosupport.api.iam.domain.model.commands.SignInCommand;
import com.agrosupport.api.iam.domain.model.commands.SignUpCommand;
import com.agrosupport.api.iam.domain.model.entities.Role;
import com.agrosupport.api.iam.domain.model.valueobjects.Roles;
import com.agrosupport.api.iam.domain.services.UserCommandService;
import com.agrosupport.api.profile.domain.model.aggregates.Profile;
import com.agrosupport.api.profile.domain.model.commands.CreateAdvisorCommand;
import com.agrosupport.api.profile.domain.model.commands.CreateFarmerCommand;
import com.agrosupport.api.profile.domain.model.commands.CreateProfileCommand;
import com.agrosupport.api.profile.domain.model.entities.Advisor;
import com.agrosupport.api.profile.domain.model.entities.Farmer;
import com.agrosupport.api.profile.domain.services.AdvisorCommandService;
import com.agrosupport.api.profile.infrastructure.persistence.jpa.repositories.AdvisorRepository;
import com.agrosupport.api.profile.infrastructure.persistence.jpa.repositories.FarmerRepository;
import com.agrosupport.api.profile.infrastructure.persistence.jpa.repositories.ProfileRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class ReviewsControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserCommandService userCommandService;

    @Autowired
    private AdvisorRepository advisorRepository;

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private Advisor advisor;
    private Farmer farmer;
    private String token;
    private Long reviewId;

    @BeforeEach
    void setup() {
        Optional<User> doctorUser = userCommandService.handle(
                new SignUpCommand("doctoruser@example.com", "password", List.of(
                        new Role(Roles.ROLE_USER)
                ))
        );

        String token = userCommandService.handle(new SignInCommand("doctoruser@example.com", "password")).orElseThrow().getRight();

        this.token = token;
        CreateProfileCommand doctorProfileCommand = new CreateProfileCommand(
                null, // userId no es necesario aquí, se toma del User
                "DoctorNombre", "DoctorApellido", "Ciudad", "País",
                LocalDate.of(1990, 1, 1), "Descripción", "foto.jpg", "Ocupación", 5
        );
        profileRepository.save(new Profile(doctorProfileCommand, doctorUser.get()));

        advisor = new Advisor(doctorUser.get());
        advisorRepository.save(advisor);

        Optional<User> patientUser = userCommandService.handle(
                new SignUpCommand("patientuser@example.com", "password", List.of(
                        new Role(Roles.ROLE_USER)
                ))
        );
        CreateProfileCommand patientProfileCommand = new CreateProfileCommand(
                null,
                "PacienteNombre", "PacienteApellido", "Ciudad", "País",
                LocalDate.of(1995, 2, 2), "Descripción", "foto2.jpg", "Ocupación", 2
        );
        profileRepository.save(new Profile(patientProfileCommand, patientUser.get()));

        farmer = farmerRepository.save(new Farmer(new CreateFarmerCommand(patientUser.get().getId()), patientUser.get()));
    }

    @Test
    void createReview_returnsCreated_andReviewData() throws Exception {
        CreateReviewResource createReview = new CreateReviewResource(
                advisor.getId(),
                farmer.getId(),
                "Comentario de prueba",
                4
        );

        mockMvc.perform(post("/api/v1/reviews")
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createReview)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.advisorId").value(advisor.getId()))
                .andExpect(jsonPath("$.farmerId").value(farmer.getId()))
                .andExpect(jsonPath("$.comment").value("Comentario de prueba"))
                .andExpect(jsonPath("$.rating").value(4));
    }


}