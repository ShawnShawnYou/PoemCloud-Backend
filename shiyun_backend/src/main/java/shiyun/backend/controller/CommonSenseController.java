package shiyun.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shiyun.backend.entity.Common_sense;
import shiyun.backend.entity.Poem;
import shiyun.backend.service.CommonSenseService;
import shiyun.backend.service.PoemService;

import java.util.List;

@RestController
public class CommonSenseController {

    @Autowired
    CommonSenseService commonSenseService;

    @GetMapping("/getCommonSenseById")
    public Common_sense getCommonSenseById(@RequestParam("id_common_sense") int id_common_sense) {
        return commonSenseService.getCommonSenseById(id_common_sense);
    }

    @GetMapping("/getCommonSenseBetweenLowHigh")
    public List<Common_sense> getCommonSenseBetweenLowHigh(@RequestParam("low_id") int low_id,
                                                           @RequestParam("high_id") int high_id,
                                                           @RequestParam("id_theme") int id_theme) {
        return commonSenseService.getCommonSenseBetweenLowHigh(low_id, high_id, id_theme);
    }

}
