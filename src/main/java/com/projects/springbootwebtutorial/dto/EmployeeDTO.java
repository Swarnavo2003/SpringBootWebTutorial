package com.projects.springbootwebtutorial.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private int age;
    private LocalDate dateOfJoining;

    @JsonProperty("isActive")
    private Boolean isActive;

    public EmployeeDTO() {}

    public EmployeeDTO(Long id, String name, String email, int age, LocalDate dateOfJoining, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.dateOfJoining = dateOfJoining;
        this.isActive = isActive;
    }
}
