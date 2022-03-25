package priv.mw.controller.user;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import priv.mw.domain.User;
import priv.mw.exception.ClientException;
import priv.mw.service.user.RegisterService;

@RestController("register")
@RequestMapping("/register")
@Validated
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

    @PostMapping("/emailValidation")
    public String emailValidation(@Email(message = "电子邮箱格式验证失败！") String email){
        System.out.println(email);
        return "2";
    }
}
