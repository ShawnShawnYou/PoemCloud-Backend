package shiyun.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "question_choice")
public class QuestionChoice extends Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_question")
    public int id_question;

    @Column(name = "text")
    public String text;

    @Column(name = "answer")
    public String answer;

    @Column(name = "single_flag")
    private boolean single_flag;

    @Column(name = "option_a")
    private String option_a;

    @Column(name = "option_b")
    private String option_b;

    @Column(name = "option_c")
    private String option_c;

    @Column(name = "option_d")
    private String option_d;

}
