package priv.mw.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.mw.annotation.UserId;
import priv.mw.domain.Essay;
import priv.mw.domain.User;
import priv.mw.exception.AuthException;
import priv.mw.service.user.LoginService;
import java.util.HashMap;

@RestController("login")
@RequestMapping("/login")
public class LoginController {

    private LoginService loginService;

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/hello")
    public String Hello(){
//        System.out.println(essay);
        HashMap hashMap = new HashMap<String, String>(){{
            put("name", "乔沃维奇");
            put("id", "232322");
        }};
        return "axcdff";
    }

    @PostMapping("/plainLogin")
    public HashMap Login(@RequestBody User user) throws AuthException {
        return loginService.login(user);
    }
}
