package priv.mw.service.user.impl;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import priv.mw.domain.User;
import priv.mw.exception.ClientException;
import priv.mw.mapper.user.RegisterMapper;
import priv.mw.service.user.RegisterService;

@Service("RegisterService")
public class RegisterServiceImpl implements RegisterService {

    private RegisterMapper registerMapper;

    @Autowired
    public void setRegisterMapper(RegisterMapper registerMapper) {
        this.registerMapper = registerMapper;
    }

    @SneakyThrows
    @Override
    public void register(User user) throws ClientException{
        if(registerMapper.isUserExists(user) == 1){
            throw new ClientException("用户已存在");
        }
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePass);
        registerMapper.register(user);
    }
}
