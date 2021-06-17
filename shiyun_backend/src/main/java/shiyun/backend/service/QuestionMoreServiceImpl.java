package shiyun.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shiyun.backend.entity.Question;
import shiyun.backend.entity.QuestionBasis;
import shiyun.backend.entity.QuestionBlank;
import shiyun.backend.entity.QuestionChoice;
import shiyun.backend.mapper.QuestionBlankMapper;
import shiyun.backend.mapper.QuestionChoiceMapper;

@Service
public class QuestionMoreServiceImpl implements QuestionMoreService {

    @Autowired
    QuestionChoiceMapper questionChoiceMapper;

    @Autowired
    QuestionBasisService questionBasisService;

    @Autowired
    QuestionBlankMapper questionBlankMapper;

    @Override
    public Question getQuestionById(int id_question) {
        int type = questionBasisService.getQuestionTypeById(id_question);
        if (type == 0)
            return questionBlankMapper.getBlankById(id_question);
        else if (type == 1)
            return questionChoiceMapper.getChoiceById(id_question);
        return null;
    }



    @Override
    public int recordDidQuestion(int id_user, int id_question, boolean right_flag) {
        // 做对了返回1，做错了返回0，异常返回-1
        QuestionBasis questionBasis  = questionBasisService.getQuestionBasisById(id_question);
        if (questionBasis == null)
            return -1;

        return questionBasisService.doQuestion(id_user, id_question, right_flag);
    }

    @Override
    public QuestionBlank getBlankById(int id_question) {
        if (questionBasisService.getQuestionTypeById(id_question) == 0) {
            return questionBlankMapper.getBlankById(id_question);
        }
        return null;
    }

    @Override
    public QuestionChoice getChoiceById(int id_question) {
        if (questionBasisService.getQuestionTypeById(id_question) == 1) {
            return questionChoiceMapper.getChoiceById(id_question);
        }
        return null;
    }
}
