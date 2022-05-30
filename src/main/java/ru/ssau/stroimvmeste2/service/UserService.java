package ru.ssau.stroimvmeste2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ssau.stroimvmeste2.dto.UserLiteDto;
import ru.ssau.stroimvmeste2.model.District;
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
            users.add(new UserLiteDto(
                    user.getId(),
                    user.getUserName(),
                    Optional.ofNullable(user.getDistrict()).orElse(new District()).getDistrictName()));
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
        Optional<User> userOptional = usersRepository.findById(user.getId());
        if (userOptional.isPresent()) {
            userOptional.get().setUserName(user.getUserName());
            userOptional.get().setFirstName(user.getFirstName());
            userOptional.get().setLastName(user.getLastName());
            userOptional.get().setEmail(user.getEmail());
            return usersRepository.save(userOptional.get());
        } else {
            return null;
        }
    }

    public void deleteUser(Integer id) {
        usersRepository.deleteById(id);
    }

}
