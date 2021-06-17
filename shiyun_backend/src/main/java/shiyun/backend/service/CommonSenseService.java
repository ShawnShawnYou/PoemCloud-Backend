package shiyun.backend.service;

import shiyun.backend.entity.*;

import java.util.List;

public interface CommonSenseService {

    Common_sense getCommonSenseById(int id_common_sense);

    List<Common_sense> getCommonSenseBetweenLowHigh(int low_id, int high_id, int id_theme);

}
