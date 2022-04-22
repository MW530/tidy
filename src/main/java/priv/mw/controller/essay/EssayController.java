package priv.mw.controller.essay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.mw.annotation.UserId;
import priv.mw.domain.Essay;
import priv.mw.service.essay.EssayService;

@RestController("EssayController")
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

    @GetMapping("/delEssay")
    public void delEssay(Integer id){
        essayService.delEssay(id);
    }

    @PostMapping("/updateEssay")
    public void updateEssay(@UserId Essay essay){
        essayService.updateEssay(essay);
    }

    @GetMapping("/getEssayById")
    public Essay getEssayById(int id){
        return essayService.findEssayById(id);
    }

    @GetMapping("/allEssay")
    public Essay[] allEssay(){
        return essayService.findEssays();
    }
}
