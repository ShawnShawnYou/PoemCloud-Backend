package shiyun.backend.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shiyun.backend.entity.*;
import shiyun.backend.service.QuestionBasisService;
import shiyun.backend.service.QuestionMoreService;
import shiyun.backend.service.UserService;

import java.util.List;

@RestController
public class QuestionBasisController {

    @Autowired
    QuestionBasisService questionBasisService;

    @Autowired
    QuestionMoreService questionMoreService;

    @Autowired
    UserService userService;

    @GetMapping("/getQuestionTypeById")
    public int getQuestionTypeById(@RequestParam int id_question) {
        return questionBasisService.getQuestionTypeById(id_question);
    }


    @GetMapping("/getWrongQuestionListByIdUser")
    public List<QuestionBasis> getWrongQuestionListByIdUser(@RequestParam("id_user") int id_user) {
        return questionBasisService.getWrongQuestionListByIdUser(id_user);
    }

    @GetMapping("/updateWrongFlagByIdUserQuestion")
    public int updateWrongFlagByIdUserQuestion(@RequestParam("id_user") int id_user,
                                               @RequestParam("id_question") int id_question,
                                               @RequestParam("wrong_flag") int wrong_flag) {
        return questionBasisService.updateWrongFlagByIdUserQuestion(id_user, id_question, wrong_flag);
    }

    @GetMapping("/getIdQuestionByIdUser")
    public int getIdQuestionByIdUser(@RequestParam("id_user") int id_user,
                                        @RequestParam("id_theme") int id_theme,
                                        @RequestParam("type") int type) {


        if (userService.getUserById(id_user) == null ||
                !(1 <= id_theme && id_theme <= 5) ||
                !(type == 0 || type == 1))
            return -1;

        return questionBasisService.getIdQuestionByIdUser(id_user, id_theme, type);
    }

    @GetMapping("/getIdQuestionList")
    public List<Integer> getIdQuestionList(@RequestParam("id_theme") int id_theme,
                                           @RequestParam("type") int type,
                                           @RequestParam("limit") int limit) {
        return questionBasisService.getIdQuestionList(id_theme, type, limit);
    }



}
