package shiyun.backend.service;

import org.apache.ibatis.binding.BindingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shiyun.backend.entity.QuestionBasis;
import shiyun.backend.mapper.QuestionBasisMapper;

import java.util.List;

@Service
public class QuestionBasisServiceImpl implements QuestionBasisService {

    @Autowired
    QuestionBasisMapper questionBasisMapper;

    @Autowired
    UserService userService;

    @Override
    public int getQuestionTypeById(int id_question) {
        // 找到的时候返回type，没找到返回-1
        int ret;
        try {
            ret = questionBasisMapper.getQuestionTypeById(id_question);
        } catch (BindingException e) {
            ret = -1;
        }
        return ret;
    }

    @Override
    public QuestionBasis getQuestionBasisById(int id_question) {
        return questionBasisMapper.getQuestionBasisById(id_question);
    }

    @Override
    public List<QuestionBasis> getWrongQuestionListByIdUser(int id_user) {
        if (userService.getUserById(id_user) == null)
            return null;
        return questionBasisMapper.getWrongQuestionListByIdUser(id_user);
    }

    @Override
    public int getIdQuestionByIdUser(int id_user, int id_theme, int type) {
        int ret;
        try {
            ret = questionBasisMapper.getIdQuestionByIdUser(id_user, id_theme, type);
//            List<Integer> id_list = questionBasisMapper.getIdQuestionListByIdUser(id_user, id_theme, type);
//            System.out.println(id_list);
//            if (id_list.size() <= 0) {
//                ret = questionBasisMapper.getRandIdQuestion(id_theme, type);
//            } else {
//                ret = id_list.get(0);
//            }
//            System.out.println(ret);

        } catch (BindingException e) {
            ret = -1;
        }
        return ret;
    }

    @Override
    public int insertQuestionFinish(int id_user, int id_question) {
        if (userService.getUserById(id_user) == null)
            return -1;
        return questionBasisMapper.insertQuestionFinish(id_user, id_question);
    }

    @Override
    public int doQuestion(int id_user, int id_question, boolean right_flag) {
        int ret = 1;

        try {
            questionBasisMapper.getIdRecord(id_user, id_question);  // 如果找不到抛出异常
            questionBasisMapper.increaseQuestionCount(id_user, id_question);
        } catch (BindingException e) {
            questionBasisMapper.insertQuestionFinish(id_user, id_question);
        }
        if (!right_flag) {
            questionBasisMapper.increaseQuestionWrongCount(id_user, id_question);
            ret = 0;
        }

        return ret;
    }

    @Override
    public int updateWrongFlagByIdUserQuestion(int id_user, int id_question, int wrong_flag) {
        return questionBasisMapper.updateWrongFlagByIdUserQuestion(id_user, id_question, wrong_flag);
    }

    @Override
    public List<Integer> getIdQuestionList(int id_theme, int type, int limit) {
        return questionBasisMapper.getIdQuestionList(id_theme, type, limit);
    }
}
