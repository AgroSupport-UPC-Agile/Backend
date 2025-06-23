package com.agrosupport.api.iam.interfaces.rest;

import com.agrosupport.api.AgrosupportApplication;
import com.agrosupport.api.iam.interfaces.rest.resources.SignInResource;
import com.agrosupport.api.iam.interfaces.rest.resources.SignUpResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = AgrosupportApplication.class)
@AutoConfigureMockMvc
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@ActiveProfiles("test")
class AuthenticationControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void signUpWithValidDataReturnsCreated() throws Exception {
        // Arrange
        SignUpResource request = new SignUpResource(
                "user_" + UUID.randomUUID() + "@test.com", "password", List.of("ROLE_USER")
        );
        // Act
        mockMvc.perform(post("/api/v1/authentication/sign-up")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                // Assert
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.username").value(request.username()));
    }

    @Test
    void signInWithCorrectCredentialsReturnsOk() throws Exception {
        // Arrange
        String username = "validuser@test.com";
        String password = "password";

        // Act
        SignUpResource signUp = new SignUpResource(username, password, List.of("ROLE_USER"));
        mockMvc.perform(post("/api/v1/authentication/sign-up")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(signUp)))
                .andExpect(status().isCreated());

        SignInResource signIn = new SignInResource(username, password);
        mockMvc.perform(post("/api/v1/authentication/sign-in")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(signIn)))
                // Assert
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").isNotEmpty())
                .andExpect(jsonPath("$.id").isNumber());
    }


}
