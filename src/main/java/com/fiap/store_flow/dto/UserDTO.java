package com.fiap.store_flow.dto;

import com.fiap.store_flow.entities.User;
import com.fiap.store_flow.entities.value_objects.Email;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private Long id;
    private String name;
    private Email email;
    private String phone;
    private LocalDate birthDate;
    private List<String> roles = new ArrayList<>();

    public UserDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        phone = entity.getPhone();
        birthDate = entity.getBirthDate();

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<String> getRoles() {
        return roles;
    }
}
