package shiyun.backend.service;

import shiyun.backend.entity.User;

import java.util.List;

public interface UserService {

    int insertUser(String email, String password);

    User getUserByEmail(String email);

    User getUserById(int id_user);

    int getScoreById(int id_user);

    int getScoreByEmail(String email);

    int addScore(int id_user, int add_score);

    List<User> getUserListOrderlyByScore(String order);
}
