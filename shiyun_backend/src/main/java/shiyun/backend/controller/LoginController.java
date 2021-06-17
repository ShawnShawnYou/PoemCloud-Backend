package shiyun.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shiyun.backend.entity.User;
import shiyun.backend.service.UserService;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        HttpSession session) {
        if (email.isEmpty())
            return "Login failed (invalid email)";
        if (password.isEmpty())
            return "Login failed (invalid password)";
        User user = userService.getUserByEmail(email);
        if (user == null)
            return "Login failed (unregistered email)";
        if (!user.getPassword().equals(password))
            return "Login failed (unmatched password)";

        session.setAttribute(String.valueOf(user.getId_user()), user);
        return "Login succeed";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "Logout succeed";
    }

    @GetMapping("/register")
    public String Register(@RequestParam("email")  String email,
                             @RequestParam("password") String password) {

        if (email.isEmpty())
            return "Register failed (invalid email)";
        if (password.isEmpty())
            return "Register failed (invalid password)";
        if (userService.getUserByEmail(email) != null)
            return "Register failed (has been registered)";

        userService.insertUser(email, password);
        return "Register succeed";
    }



}
