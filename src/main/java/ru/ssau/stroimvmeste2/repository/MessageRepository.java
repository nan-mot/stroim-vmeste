package ru.ssau.stroimvmeste2.repository;

import org.springframework.data.repository.CrudRepository;
import ru.ssau.stroimvmeste2.model.Message;

public interface MessageRepository extends CrudRepository<Message, Integer> {
}
