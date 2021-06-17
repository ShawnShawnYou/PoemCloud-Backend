package shiyun.backend.mapper;

import org.apache.ibatis.annotations.*;
import shiyun.backend.entity.QuestionChoice;

@Mapper
public interface QuestionChoiceMapper {

    // @ResultType(QuestionChoice.class)
    @Results(
            id = "questionChoiceList",value = {
            @Result(property="id_question", column="id_question"),
            @Result(property="text", column="text"),
            @Result(property="answer", column="answer"),
            @Result(property="single_flag", column="single_flag"),
            @Result(property="option_a", column="option_a"),
            @Result(property="option_b", column="option_b"),
            @Result(property="option_c", column="option_c"),
            @Result(property="option_d", column="option_d")
    })
    @Select("select * from question_choice where id_question = #{id_question};\n")
    QuestionChoice getChoiceById(@Param("id_question") int id_question);

}
