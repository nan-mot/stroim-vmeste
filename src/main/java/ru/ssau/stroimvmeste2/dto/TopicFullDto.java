package ru.ssau.stroimvmeste2.dto;

import lombok.Data;

import java.util.List;

@Data
public class TopicFullDto {

    private final Integer id;
    private final String topicName;
    private final String topicDescription;
    private final List<MessageDto> topicMessagesDto;

}
