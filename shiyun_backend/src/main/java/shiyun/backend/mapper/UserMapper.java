package shiyun.backend.mapper;

import org.apache.ibatis.annotations.*;
import shiyun.backend.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {

    // 注册
    @Insert("INSERT INTO user_login(email,password) VALUES (#{email},#{password});")
    @Options(useGeneratedKeys = true, keyProperty = "id_user")
    int insertUser(User user);

    @Select("SELECT id_user FROM user_login WHERE email=#{email};")
    int getIdUserByEmail(@Param("email") String email);

    @ResultType(User.class)
    @Select("SELECT * FROM user_login WHERE id_user=#{id_user};")
    User getUserById(@Param("id_user") int id_user);

    @Select("SELECT * FROM user_login WHERE email=#{email};")
    User getUserByEmail(@Param("email") String email);

    //如果已经定义过@Results，可以直接用@ResultMap来调取
    @Results(
            id = "userList",value = {
            @Result(property="email", column="email"),
            @Result(property="password", column="password"),
            @Result(property="score", column="score")
    })
    @Select("SELECT * FROM user_login ORDER BY ${order} DESC;")
    List<User> getUserListOrderlyByScore(String order);

    @Delete("DELETE FROM user_login WHERE id_user=#{id_user};")
    int deleteUserById(@Param("id_user") int id_user);

    @Update("UPDATE user_login SET email=#{email} WHERE id_user=#{id_user};")
    int updateEmailById(@Param("email") String email,
                        @Param("id_user") int id_user);

    @Update("UPDATE user_login SET score = #{score} WHERE id_user = #{id_user}")
    int updateScoreById(@Param("id_user") int id_user,
                        @Param("score") int score);
}
