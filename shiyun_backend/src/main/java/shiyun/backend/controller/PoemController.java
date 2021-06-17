package shiyun.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shiyun.backend.entity.Poem;
import shiyun.backend.service.PoemService;
import shiyun.backend.service.UserService;

import java.util.List;

@RestController
public class PoemController {

    @Autowired
    PoemService poemService;

    @GetMapping("/getPoemById")
    public Poem getPoemById(@RequestParam("id_poem") int id_poem) {
        return poemService.getPoemById(id_poem);
    }

    @GetMapping("/getPoemBetweenLowHigh")
    public List<Poem> getPoemBetweenLowHigh(@RequestParam("low_id") int low_id,
                                            @RequestParam("high_id") int high_id) {
        return poemService.getPoemBetweenLowHigh(low_id, high_id);
    }

}
