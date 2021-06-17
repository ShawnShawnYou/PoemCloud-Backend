package shiyun.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shiyun.backend.entity.User;
import shiyun.backend.service.UserService;
import shiyun.backend.service.UserServiceImpl;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getScoreById")
    public int getScoreById(@RequestParam("id_user") int id_user) {
        return userService.getScoreById(id_user);
    }

    @GetMapping("/getScoreByEmail")
    public int getScoreByEmail(@RequestParam("email") String email) {
        return userService.getScoreByEmail(email);
    }

    @GetMapping("/getIdByEmail")
    public int getIdByEmail(@RequestParam("email") String email) {
        return userService.getUserByEmail(email).getId_user();
    }

    @GetMapping("/addScore")
    public int addScore(@RequestParam("id_user") int id_user,
                        @RequestParam("add_score") int score) {
        if (score <= 0)
            return -1;
        return userService.addScore(id_user, score);

    }

    @GetMapping("/getUserListOrderly")
    public List<User> getUserListOrderly(@RequestParam("order") String order) {
        return userService.getUserListOrderlyByScore(order);
    }









}
