package ru.ssau.stroimvmeste2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ssau.stroimvmeste2.dto.ProjectFullDto;
import ru.ssau.stroimvmeste2.dto.ProjectLiteDto;
import ru.ssau.stroimvmeste2.dto.TopicLiteDto;
import ru.ssau.stroimvmeste2.model.District;
import ru.ssau.stroimvmeste2.model.Project;
import ru.ssau.stroimvmeste2.model.Topic;
import ru.ssau.stroimvmeste2.repository.ProjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {

    public final ProjectRepository projectRepository;

    public List<ProjectLiteDto> getAllProjects() {
        List<ProjectLiteDto> projectLiteDtos = new ArrayList<>();
        for (Project project : projectRepository.findAll()) {
            projectLiteDtos.add( new ProjectLiteDto(
                    project.getId(),
                    project.getProjectName(),
                    Optional.ofNullable(project.getDistrict()).orElse(new District()).getDistrictName()));
        }
        return projectLiteDtos;
    }


    public Optional<ProjectFullDto> getProject(Integer id) {
        Optional<Project> projectOptional = projectRepository.findById(id);
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            List<TopicLiteDto> topicLiteDtos = new ArrayList<>();
            for (Topic topic : project.getProjectTopics()) {
                topicLiteDtos.add(new TopicLiteDto(topic.getId(), topic.getTopicName()));
            }
            return Optional.of(new ProjectFullDto(project.getId(), project.getProjectName(), project.getProjectDescription(), project.getDistrict().getDistrictName(), topicLiteDtos));
        } else {
            return Optional.empty();
        }
    }

    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(Project project) {
        Optional<Project> projectOptional = projectRepository.findById(project.getId());
        if (projectOptional.isPresent()) {
            projectOptional.get().setProjectName(project.getProjectName());
            projectOptional.get().setProjectDescription(project.getProjectDescription());
            return projectRepository.save(projectOptional.get());
        } else {
            return null;
        }
    }

    public void deleteProject(Integer id) {
        projectRepository.deleteById(id);
    }

    public List<String> findProjectNamesByKeyword(String keyword) {
        return projectRepository.findProjectNamesByKeyword(keyword);
    }

}
