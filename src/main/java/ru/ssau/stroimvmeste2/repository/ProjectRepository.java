package ru.ssau.stroimvmeste2.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.ssau.stroimvmeste2.model.Project;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Integer> {

    @Query(value = "SELECT project_name FROM project WHERE project_name LIKE %?1%", nativeQuery = true)
    List<String> findProjectNamesByKeyword(String keyword);
}
