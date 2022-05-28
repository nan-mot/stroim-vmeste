package ru.ssau.stroimvmeste2.dto;

import lombok.Data;

@Data
public class MessageDto {
    private final Integer id;
    private final String messageText;
    private final String username;
}