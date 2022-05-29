package ru.ssau.stroimvmeste2.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProjectFullDto {
    private final Integer id;
    private final String projectName;
    private final String projectDescription;
    private final Integer district;
    private final List<TopicLiteDto> projectTopics;
}
