package ru.ssau.stroimvmeste2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserFullDto {

    private Integer id;

    private String firstName;

    private String lastName;

    private String userName;

    private String email;

    public String userRole;

    private String district;
}
