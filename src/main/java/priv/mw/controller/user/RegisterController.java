package priv.mw.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.mw.domain.User;
import priv.mw.exception.ClientException;
import priv.mw.service.user.RegisterService;
import priv.mw.utils.Result;

@RestController("register")
public class RegisterController {
    private RegisterService registerService;

    @Autowired
    public void setRegisterService(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/plainRegister")
    public String register(@RequestBody User user) throws ClientException {
        System.out.println(user);
        registerService.register(user);
        return "注册成功！";
    }
}
