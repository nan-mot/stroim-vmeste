package ru.ssau.stroimvmeste2.dto;

import lombok.Data;


@Data
public class UserLiteDto {
    private final Integer id;

    private final String userName;
    private final String userDistrict;
}
