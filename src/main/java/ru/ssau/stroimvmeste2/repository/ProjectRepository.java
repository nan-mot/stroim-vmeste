package ru.ssau.stroimvmeste2.repository;

import org.springframework.data.repository.CrudRepository;
import ru.ssau.stroimvmeste2.model.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
}
