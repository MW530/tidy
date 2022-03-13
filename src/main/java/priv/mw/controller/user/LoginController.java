package priv.mw.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import priv.mw.domain.User;
import priv.mw.exception.ServerException;
import priv.mw.service.user.LoginService;
import priv.mw.utils.JWTUtils;

import java.time.Period;
import java.util.HashMap;

import priv.mw.utils.JWTUtils;

@RestController("login")
public class LoginController {

    private LoginService loginService;

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/getUserById")
    public User getUserById(int id){
        HashMap hashMap = new HashMap<String, String>(){{
            put("name", "乔沃维奇");
            put("id", "232322");
        }};
        System.out.println(new JWTUtils().generateToken(hashMap));
        return loginService.getUserById(id);
    }

    @PostMapping("/login")
    public HashMap Login(@RequestBody User user){
        HashMap hashMap = new HashMap<String, String>(){{
            put("name", "乔沃维奇");
            put("id", "232322");
        }};
        System.out.println(user);
        return hashMap;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
