package shiyun.backend.service;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shiyun.backend.entity.Poem;
import shiyun.backend.mapper.PoemMapper;

import java.util.List;

@Service
public class PoemServiceImpl implements PoemService {

    @Autowired
    PoemMapper poemMapper;

    @Override
    public Poem getPoemById(int id_poem) {
        return poemMapper.getPoemById(id_poem);
    }

    @Override
    public List<Poem> getPoemBetweenLowHigh(int low_id, int high_id) {
        return poemMapper.getPoemBetweenLowHigh(low_id, high_id);
    }
}
