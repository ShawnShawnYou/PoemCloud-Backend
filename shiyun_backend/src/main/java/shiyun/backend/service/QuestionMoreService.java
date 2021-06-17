package shiyun.backend.service;

import shiyun.backend.entity.Question;
import shiyun.backend.entity.QuestionBlank;
import shiyun.backend.entity.QuestionChoice;

public interface QuestionMoreService {

    Question getQuestionById(int id_question);

    int recordDidQuestion(int id_user, int id_question, boolean right_flag);

    QuestionBlank getBlankById(int id_question);

    QuestionChoice getChoiceById(int id_question);

}
