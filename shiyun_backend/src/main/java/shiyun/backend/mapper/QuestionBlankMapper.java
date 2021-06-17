package shiyun.backend.mapper;

import org.apache.ibatis.annotations.*;
import shiyun.backend.entity.QuestionBlank;
import shiyun.backend.entity.QuestionChoice;

@Mapper
public interface QuestionBlankMapper {

    @Results(
            id = "questionBlankList",value = {
            @Result(property="id_question", column="id_question"),
            @Result(property="text", column="text"),
            @Result(property="answer", column="answer")
    })
    @Select("select * from question_fill_in_blank where id_question = #{id_question};\n")
    QuestionBlank getBlankById(@Param("id_question") int id_question);

}
