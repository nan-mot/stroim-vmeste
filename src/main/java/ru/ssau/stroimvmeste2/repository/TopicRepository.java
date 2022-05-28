package ru.ssau.stroimvmeste2.repository;

import org.springframework.data.repository.CrudRepository;
import ru.ssau.stroimvmeste2.model.Topic;

public interface TopicRepository extends CrudRepository<Topic, Integer> {
}
