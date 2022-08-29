package uz.isystem.AsaxiyUz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/users")
    public String user() {
        return "users";
    }
}
