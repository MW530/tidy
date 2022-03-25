package priv.mw.controller.essay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.mw.annotation.UserId;
import priv.mw.domain.Essay;
import priv.mw.service.essay.EssayService;

@RestController
@RequestMapping("/essay")
public class EssayController {

    private EssayService essayService;

    @Autowired
    public void setEssayService(EssayService essayService) {
        this.essayService = essayService;
    }

    @PostMapping("/addEssay")
    public void addEssay(@UserId Essay essay){
        essayService.addEssay(essay);
    }
}
