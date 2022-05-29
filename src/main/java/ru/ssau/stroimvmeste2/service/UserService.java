package ru.ssau.stroimvmeste2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ssau.stroimvmeste2.dto.UserLiteDto;
import ru.ssau.stroimvmeste2.model.User;
import ru.ssau.stroimvmeste2.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepository usersRepository;

    public List<UserLiteDto> getAllUsers() {
        List<UserLiteDto> users = new ArrayList<>();
        for (User user : usersRepository.findAll()) {
            users.add(new UserLiteDto(user.getId(), user.getUserName(), user.getDistrict().getDistrictName()));
        }
        return users;
    }


    public Optional<User> getUser(Integer id) {
        return usersRepository.findById(id);
    }

    public User addUser(User user) {
        return usersRepository.save(user);
    }

    public User updateUser(User user) {
        return usersRepository.save(user);
    }

    public void deleteUser(Integer id) {
        usersRepository.deleteById(id);
    }

}
