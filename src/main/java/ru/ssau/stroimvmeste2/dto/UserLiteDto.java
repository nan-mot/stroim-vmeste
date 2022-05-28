package ru.ssau.stroimvmeste2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
public class UserLiteDto {
    private Integer id;

    private String userName;

    public String userRole;

    private String userDistrict;
}
