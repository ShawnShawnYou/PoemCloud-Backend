package shiyun.backend.entity;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user_login")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int id_user;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "score",nullable = false)
    private int score;

}
