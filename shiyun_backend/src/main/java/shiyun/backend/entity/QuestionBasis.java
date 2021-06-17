package shiyun.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "question_basis")
public class QuestionBasis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_question")
    private int id_question;

    @Column(name = "title")
    public String title;

    // (0是填空题，1是单选题，2是多选题)
    @Column(name = "question_type")
    private int question_type;

    @Column(name = "id_theme")
    private int id_theme;

    @Column(name = "point")
    private int point;
}
