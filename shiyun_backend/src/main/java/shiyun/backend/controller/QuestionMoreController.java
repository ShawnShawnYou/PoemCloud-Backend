package shiyun.backend.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shiyun.backend.entity.Question;
import shiyun.backend.entity.QuestionChoice;
import shiyun.backend.service.QuestionBasisService;
import shiyun.backend.service.QuestionMoreService;

@RestController
public class QuestionMoreController {

    @Autowired
    QuestionBasisService questionBasisService;

    @Autowired
    QuestionMoreService questionMoreService;

    @GetMapping("/getQuestionById")
    public Question getQuestionById(@RequestParam("id_question") int id_question) {
        return questionMoreService.getQuestionById(id_question);
    }


    // 做对了返回1，做错了返回0，异常返回-1
    @PostMapping("/recordDidQuestion")
    public int recordDidQuestion(@RequestParam("id_user") int id_user,
                         @RequestParam("id_question") int id_question,
                         @RequestParam("right_flag") boolean right_flag) {
        return questionMoreService.recordDidQuestion(id_user, id_question, right_flag);
    }




}
