package priv.mw.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.mw.annotation.SingleJSONParam;
import priv.mw.annotation.UserId;
import priv.mw.service.user.PersonInfoService;

@RestController("PersonInfoController")
@RequestMapping("/personInfo")
public class PersonInfoController {

    private PersonInfoService personInfoService;

    @Autowired
    public void setPersonInfoService(PersonInfoService personInfoService) {
        this.personInfoService = personInfoService;
    }

    @PostMapping("/updateAvatar")
    public void updateAvatar(@UserId("base") int uId,@SingleJSONParam int avatar){
        personInfoService.updateAvatar(avatar, uId);
    }

    @PostMapping("/updateShowName")
    public void updateShowName(@UserId("base") int uId,@SingleJSONParam  String showName){
        personInfoService.updateShowName(showName, uId);
    }

    @PostMapping("/updateDescription")
    public void updateDescription(@UserId("base") int uId,@SingleJSONParam String description){
        personInfoService.updateDescription(description, uId);
    }
}
