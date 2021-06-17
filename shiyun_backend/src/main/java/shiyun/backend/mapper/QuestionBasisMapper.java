package shiyun.backend.mapper;

import org.apache.ibatis.annotations.*;
import shiyun.backend.entity.QuestionBasis;
import shiyun.backend.entity.User;

import java.util.List;

@Mapper
public interface QuestionBasisMapper {

    // 获取新的题目id (0是填空题，1是单选题，2是多选题)
    @Select("SELECT MIN(t1.id_question) FROM \n" +
            "question_basis AS t1 \n" +
            "LEFT JOIN \n" +
            "(SELECT * FROM question_answer_station WHERE id_user = #{id_user} ) AS t2\n" +
            "ON t1.id_question = t2.id_question\n" +
            "WHERE t2.id_question IS NULL \n" +
            "AND id_theme = #{id_theme} AND question_type = #{question_type};\n")
    int getIdQuestionByIdUser(@Param("id_user") int id_user,
                              @Param("id_theme") int id_theme,
                              @Param("question_type") int question_type);

    @Select("SELECT t1.id_question FROM \n" +
            "question_basis AS t1 \n" +
            "LEFT JOIN \n" +
            "(SELECT * FROM question_answer_station WHERE id_user = #{id_user} ) AS t2\n" +
            "ON t1.id_question = t2.id_question\n" +
            "WHERE t2.id_question IS NULL \n" +
            "AND id_theme = #{id_theme} AND question_type = #{question_type} LIMIT 10;\n")
    List<Integer> getIdQuestionListByIdUser(@Param("id_user") int id_user,
                                            @Param("id_theme") int id_theme,
                                            @Param("question_type") int question_type);


    @Select(" SELECT id_question FROM question_basis\n" +
            " WHERE id_theme = #{id_theme} AND question_type = #{question_type} LIMIT #{limit} ;")
    List<Integer> getIdQuestionList(@Param("id_theme") int id_theme,
                                    @Param("question_type") int question_type,
                                    @Param("limit") int limit);


    @Select("SELECT * FROM \n" +
            "(SELECT * FROM question_basis WHERE id_theme = #{id_theme} AND question_type = #{question_type}) t1\n" +
            "JOIN \n" +
            "(SELECT RAND() * (SELECT MAX(id_question) FROM question_basis WHERE id_theme = #{id_theme} AND question_type = #{question_type}) AS nid) t2\n" +
            "ON t1.id_question > t2.nid LIMIT 1;")
    int getRandIdQuestion(@Param("id_theme") int id_theme,
                          @Param("question_type") int question_type);


    // 通过题目ID获取题目类
    @ResultType(QuestionBasis.class)
    @Select("SELECT * FROM question_basis WHERE id_question = #{id_question}")
    QuestionBasis getQuestionBasisById(@Param("id_question") int id_question);

    // 获取错题记录
    @Results(
            id = "questionBasisList",value = {
            @Result(property="id_question", column="id_question"),
            @Result(property="title", column="title"),
            @Result(property="question_type", column="question_type"),
            @Result(property="id_theme", column="id_theme"),
            @Result(property="point", column="point")
    })
    @Select("SELECT * FROM \n" +
            "(SELECT id_question FROM question_answer_station \n" +
            "WHERE id_user = #{id_user} AND wrong_flag = 1) t1\n" +
            "NATURAL JOIN question_basis")
    List<QuestionBasis> getWrongQuestionListByIdUser(@Param("id_user") int id_user);

    @Select("SELECT id_question FROM \n" +
            "(SELECT id_question FROM question_answer_station \n" +
            "WHERE id_user = #{id_user} AND wrong_flag = 1) t1\n" +
            "NATURAL JOIN question_basis \n" +
            "WHERE id_theme = #{id_theme} AND question_type = #{question_type}")
    List<Integer> getWrongQuestionIdListByIdUser(@Param("id_user") int id_user,
                                                 @Param("id_theme") int id_theme,
                                                 @Param("question_type") int question_type);

    // 获取题目类型
    @Select("SELECT question_type FROM question_basis WHERE id_question = #{id_question};")
    int getQuestionTypeById(@Param("id_question") int id_question);

    // 计算分数
    @Select("SELECT COUNT(id_question) FROM question_answer_station AS t\n" +
            "WHERE id_user = #{id_user} AND t.count > t.wrong_count")
    int countUserScoreById(@Param("id_user") int id_user);

    // 获取做题记录id
    @Select("SELECT id FROM question_answer_station \n" +
            "WHERE id_user = #{id_user} AND id_question = #{id_question};")
    int getIdRecord(@Param("id_user") int id_user,
                    @Param("id_question") int id_question);

    // 加入做题记录
    @Insert("INSERT INTO question_answer_station(id_user, id_question) " +
            "VALUES (#{id_user}, #{id_question});")
    int insertQuestionFinish(@Param("id_user") int id_user,
                             @Param("id_question") int id_question);

    @Update("UPDATE question_answer_station AS t \n" +
            "SET t.wrong_count = t.wrong_count + 1\n" +
            "WHERE id_user = #{id_user} AND id_question = #{id_question}; ")
    int increaseQuestionWrongCount(@Param("id_user") int id_user,
                                   @Param("id_question") int id_question);

    @Update("UPDATE question_answer_station AS t \n" +
            "SET t.count = t.count + 1\n" +
            "WHERE id_user = #{id_user} AND id_question = #{id_question}; ")
    int increaseQuestionCount(@Param("id_user") int id_user,
                              @Param("id_question") int id_question);


    // 修改错题标记
    @Update("UPDATE question_answer_station SET wrong_flag = #{wrong_flag} " +
            "WHERE id_user = #{id_user} AND id_question = #{id_question};")
    int updateWrongFlagByIdUserQuestion(@Param("id_user") int id_user,
                                        @Param("id_question") int id_question,
                                        @Param("wrong_flag") int wrong_flag);




}
