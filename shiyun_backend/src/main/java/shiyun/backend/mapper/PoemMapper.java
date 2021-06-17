package shiyun.backend.mapper;

import org.apache.ibatis.annotations.*;
import shiyun.backend.entity.Poem;
import shiyun.backend.entity.User;

import java.util.List;

@Mapper
public interface PoemMapper {

    @Select("SELECT * FROM poem_basis \n" +
            "WHERE id_poem BETWEEN #{low_id} AND #{high_id} ;")
    List<Poem> getPoemBetweenLowHigh(@Param("low_id") int low_id,
                                    @Param("high_id") int high_id);

    @Select("SELECT * FROM poem_basis where id_poem = #{id_poem};")
    Poem getPoemById(@Param("id_poem") int id_poem);

}
