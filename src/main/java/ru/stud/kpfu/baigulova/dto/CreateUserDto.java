package ru.stud.kpfu.baigulova.dto;


import javax.validation.constraints.NotBlank;

public class CreateUserDto {

    @NotBlank(message = "Name shouldn't be blank!")
    private String name;

    @NotBlank(message = "Email shouldn't be blank!")
    private String email;

    @NotBlank(message = "Password shouldn't be blank!")
    private String password;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public CreateUserDto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}

