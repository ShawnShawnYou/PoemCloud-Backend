package shiyun.backend.service;

import org.apache.ibatis.annotations.Param;
import shiyun.backend.entity.Poem;

import java.util.List;

public interface PoemService {

    Poem getPoemById(int id_poem);

    List<Poem> getPoemBetweenLowHigh(int low_id, int high_id);

}
