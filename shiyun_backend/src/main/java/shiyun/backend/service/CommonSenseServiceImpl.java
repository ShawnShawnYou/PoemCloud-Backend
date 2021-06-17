package shiyun.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shiyun.backend.entity.Common_sense;
import shiyun.backend.mapper.CommonSenseMapper;

import java.util.List;

@Service
public class CommonSenseServiceImpl implements CommonSenseService {

    @Autowired
    CommonSenseMapper commonSenseMapper;

    @Override
    public Common_sense getCommonSenseById(int id_common_sense) {
        return commonSenseMapper.getCommonSenseById(id_common_sense);
    }

    @Override
    public List<Common_sense> getCommonSenseBetweenLowHigh(int low_id, int high_id, int id_theme) {
        return commonSenseMapper.getCommonSenseBetweenLowHigh(low_id, high_id, id_theme);
    }
}
