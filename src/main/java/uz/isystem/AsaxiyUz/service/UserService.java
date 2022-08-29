package uz.isystem.AsaxiyUz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.isystem.AsaxiyUz.dto.UserDto;
import uz.isystem.AsaxiyUz.exception.BadRequest;
import uz.isystem.AsaxiyUz.model.User;
import uz.isystem.AsaxiyUz.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDto create(UserDto userDto) {
        User user = new User();
        user.setHired(true);
        user.setCreatedAt(LocalDateTime.now());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setAge(userDto.getAge());
        user.setAddress(userDto.getAddress());
        user.setCountryOfOrigin(userDto.getCountryOfOrigin());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setHired(userDto.getHired());
        userRepository.save(user);
        userDto.setId(user.getId());
        return userDto;
    }

    public User get(Integer id) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isEmpty()) {
            throw new BadRequest("User not found");
        }
        return optional.get();
    }

    public boolean update(Integer id, UserDto userDto) {
        User update = check(id);
        update.setUpdatedAt(LocalDateTime.now());
        update.setName(userDto.getName());
        update.setSurname(userDto.getSurname());
        update.setAge(userDto.getAge());
        update.setAddress(userDto.getAddress());
        update.setCountryOfOrigin(userDto.getCountryOfOrigin());
        update.setEmail(userDto.getEmail());
        update.setPhone(userDto.getPhone());
        update.setHired(userDto.getHired());
        userRepository.save(update);
        return true;
    }

    public boolean delete(Integer id) {
        User user = check(id);
        user.setDeletedAt(LocalDateTime.now());
        userRepository.delete(user);
        return true;
    }


    public User check(Integer id) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isEmpty()) {
            throw new BadRequest("User not found");
        }
        return optional.get();
    }
}
