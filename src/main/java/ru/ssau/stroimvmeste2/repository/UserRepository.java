package ru.ssau.stroimvmeste2.repository;

import org.springframework.data.repository.CrudRepository;
import ru.ssau.stroimvmeste2.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
