package ru.ssau.stroimvmeste2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ssau.stroimvmeste2.model.User;
import ru.ssau.stroimvmeste2.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepository usersRepository;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        usersRepository.findAll().forEach(users::add);
        return users;
    }


    public Optional<User> getUser(Integer id) {
        return usersRepository.findById(id);
    }

    public void addUser(User user) {
        usersRepository.save(user);
    }

    public void updateUser(User user) {
        usersRepository.save(user);
    }

    public void deleteUser(Integer id) {
        usersRepository.deleteById(id);
    }

}
