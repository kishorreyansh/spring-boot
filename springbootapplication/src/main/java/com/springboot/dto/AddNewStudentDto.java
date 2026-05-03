package com.springboot.dto;

import lombok.Data;

@Data
public class AddNewStudentDto {

    private String name;
    private String email;

    public AddNewStudentDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public AddNewStudentDto() {
    }
}
