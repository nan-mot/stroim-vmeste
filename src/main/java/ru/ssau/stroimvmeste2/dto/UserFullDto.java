package ru.ssau.stroimvmeste2.dto;

import lombok.Data;

@Data
public class UserFullDto {

    private final Integer id;

    private final String firstName;

    private final String lastName;

    private final String userName;

    private final String email;

    private final String district;
}
