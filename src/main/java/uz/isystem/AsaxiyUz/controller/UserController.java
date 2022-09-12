package uz.isystem.AsaxiyUz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.isystem.AsaxiyUz.dto.UserDto;
import uz.isystem.AsaxiyUz.model.User;
import uz.isystem.AsaxiyUz.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid UserDto user){
        UserDto result = userService.create(user);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        User result = userService.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid UserDto user,
                                    @PathVariable("id") Integer id){
        boolean result = userService.update(id,user);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        boolean result = userService.delete(id);
        return ResponseEntity.ok(result);
    }

}
