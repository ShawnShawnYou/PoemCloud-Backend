package shiyun.backend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import shiyun.backend.entity.Common_sense;
import shiyun.backend.entity.Poem;

import java.util.List;

@Mapper
public interface CommonSenseMapper {

    @Select("SELECT * FROM common_sense_basis \n" +
            "WHERE id_common_sense BETWEEN #{low_id} AND #{high_id} " +
            "AND id_theme = #{id_theme};")
    List<Common_sense> getCommonSenseBetweenLowHigh(@Param("low_id") int low_id,
                                                    @Param("high_id") int high_id,
                                                    @Param("id_theme") int id_theme);

    @Select("SELECT * FROM common_sense_basis " +
            "WHERE id_common_sense = #{id_common_sense};")
    Common_sense getCommonSenseById(@Param("id_common_sense") int id_common_sense);

}
