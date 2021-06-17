package shiyun.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "question_fill_in_blank")
public class QuestionBlank extends Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_question")
    public int id_question;

    @Column(name = "text")
    public String text;

    @Column(name = "answer")
    public String answer;


}
