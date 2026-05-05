package com.springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddNewStudentDto {

    @NotBlank(message="Name is Required")
    @Size(min = 3,max = 20, message = "Name should be between 3 to 20 Characters")
    private String name;
    @Email
    @NotBlank(message = "Email is Required")
    private String email;

    public AddNewStudentDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public AddNewStudentDto() {
    }
}
