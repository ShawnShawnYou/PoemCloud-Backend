package shiyun.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import shiyun.backend.entity.User;
import shiyun.backend.mapper.UserMapper;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public int insertUser(String email, String password) {

        if (userMapper.getUserByEmail(email) == null) {
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            userMapper.insertUser(user);
        }

        return userMapper.getUserByEmail(email).getId_user();
    }

    @Override
    public User getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }

    @Override
    public User getUserById(int id_user) {
        return userMapper.getUserById(id_user);
    }

    @Override
    public int getScoreById(int id_user) {
        if (getUserById(id_user) == null)
            return -1;
        return userMapper.getUserById(id_user).getScore();
    }

    @Override
    public int getScoreByEmail(String email) {
        if (getUserByEmail(email) == null)
            return -1;
        return userMapper.getUserByEmail(email).getScore();
    }

    @Override
    public int addScore(int id_user, int add_score) {
        int old_score = getScoreById(id_user);
        int new_score = old_score + add_score;
        return userMapper.updateScoreById(id_user, new_score);
    }

    @Override
    public List<User> getUserListOrderlyByScore(String order) {
        return userMapper.getUserListOrderlyByScore(order);
    }
}
