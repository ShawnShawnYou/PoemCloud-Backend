package shiyun.backend.service;

import org.apache.ibatis.annotations.Param;
import shiyun.backend.entity.QuestionBasis;

import java.util.List;

public interface QuestionBasisService {

    int getQuestionTypeById(int id_question);

    QuestionBasis getQuestionBasisById(int id_question);

    List<QuestionBasis> getWrongQuestionListByIdUser(int id_user);

    int getIdQuestionByIdUser(int id_user, int id_theme, int type);

    int insertQuestionFinish(int id_user, int id_question);

    int doQuestion(int id_user, int id_question, boolean true_or_false);

    int updateWrongFlagByIdUserQuestion(int id_user, int id_question, int wrong_flag);

    List<Integer> getIdQuestionList(int id_theme, int type, int limit);
}
