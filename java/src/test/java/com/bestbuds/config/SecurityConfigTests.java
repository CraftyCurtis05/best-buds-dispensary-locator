package com.bestbuds.config;

import com.bestbuds.dao.UserDao;
import com.bestbuds.model.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;

@SpringBootTest(
        properties = {
                "app.cors.allowed-origin=http://localhost:5173"
        }
)
@AutoConfigureMockMvc
public class SecurityConfigTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserDao userDao;

    @Test
    public void protected_endpoint_rejects_unauthenticated_request()
            throws Exception {

        mockMvc.perform(
                        get("/api/test")
                )
                .andExpect(
                        status().isUnauthorized()
                );
    }

    @Test
    public void protected_endpoint_allows_authenticated_user()
            throws Exception {

        User user =
                userDao.getUserByUsername(
                        "user1"
                );

        userDao.confirmAge(
                user.getId()
        );

        mockMvc.perform(
                        get("/api/test")
                                .with(
                                        user("user1")
                                )
                )
                .andExpect(
                        status().isNotFound()
                );
    }

    @Test
    public void protected_endpoint_rejects_user_without_age_confirmation()
            throws Exception {

        mockMvc.perform(
                        get("/api/test")
                                .with(
                                        user("user2")
                                )
                )
                .andExpect(
                        status().isForbidden()
                );
    }

    @Test
    public void auth_endpoint_allows_unauthenticated_request()
            throws Exception {

    mockMvc.perform(
                    post("/api/auth/register")
                            .contentType("application/json")
                            .content(
                                    """
                                    {
                                            "username": "",
                                            "password": "",
                                            "confirmPassword": ""
                                    }
                                    """
                            )
            )
            .andExpect(
                    status().isBadRequest()
            )
            .andExpect(
                    jsonPath("$.status")
                            .value(400)
            )
            .andExpect(
                    jsonPath("$.error")
                            .value("Bad Request")
            )
            .andExpect(
                    jsonPath("$.message")
                            .isNotEmpty()
            )
            .andExpect(
                    jsonPath("$.path")
                            .value("/api/auth/register")
            )
            .andExpect(
                    jsonPath("$.timestamp")
                            .isNotEmpty()
            );
    }

    @Test
    public void register_with_mismatched_passwords_returns_bad_request()
            throws Exception {
    
    mockMvc.perform(
                    post("/api/auth/register")
                            .contentType("application/json")
                            .content(
                                    """
                                    {
                                            "username": "newuser",
                                            "email": "newuser@bestbuds.local",
                                            "password": "password123",
                                            "confirmPassword": "different123"
                                    }
                                    """
                            )
            )
            .andExpect(
                    status().isBadRequest()
            )
            .andExpect(
                    jsonPath("$.status")
                            .value(400)
            )
            .andExpect(
                    jsonPath("$.error")
                            .value("Bad Request")
            )
            .andExpect(
                    jsonPath("$.message")
                            .value("Passwords do not match.")
            )
            .andExpect(
                    jsonPath("$.path")
                            .value("/api/auth/register")
            )
            .andExpect(
                    jsonPath("$.timestamp")
                            .isNotEmpty()
            );
    }

    @Test
    public void register_with_existing_username_returns_conflict()
            throws Exception {

        mockMvc.perform(
                        post("/api/auth/register")
                                .contentType("application/json")
                                .content(
                                        """
                                        {
                                            "username": "user1",
                                            "email": "different@bestbuds.local",
                                            "password": "password123",
                                            "confirmPassword": "password123"
                                        }
                                        """
                                )
                )
                .andExpect(
                        status().isConflict()
                )
                .andExpect(
                        jsonPath("$.status")
                                .value(409)
                )
                .andExpect(
                        jsonPath("$.error")
                                .value("Conflict")
                )
                .andExpect(
                        jsonPath("$.message")
                                .value("Username is already in use.")
                )
                .andExpect(
                        jsonPath("$.path")
                                .value("/api/auth/register")
                )
                .andExpect(
                        jsonPath("$.timestamp")
                                .isNotEmpty()
                );
    }

    @Test
    public void age_confirmation_rejects_unauthenticated_user()
            throws Exception {

        mockMvc.perform(
                        post("/api/age/confirm")
                )
                .andExpect(
                        status().isUnauthorized()
                );
    }
}