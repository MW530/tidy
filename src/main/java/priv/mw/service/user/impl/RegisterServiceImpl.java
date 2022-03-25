package priv.mw.service.user.impl;

import lombok.SneakyThrows;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.mw.domain.User;
import priv.mw.exception.ClientException;
import priv.mw.mapper.user.RegisterMapper;
import priv.mw.service.user.RegisterService;
import priv.mw.utils.EncodeUtils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

@Service("RegisterService")
public class RegisterServiceImpl implements RegisterService {

    public enum PERMISSIONS {
        MEMBER,
        ADMIN
    }

    private RegisterMapper registerMapper;

    @Autowired
    public void setRegisterMapper(RegisterMapper registerMapper) {
        this.registerMapper = registerMapper;
    }

    @SneakyThrows
    @Override
    public void register(User user) throws ClientException{
        LocalDateTime registerTime = LocalDateTime.now();
        user.setRegisterTime(registerTime);
        user.setEnabled(true);
        user.setActivated(false);
        user.setShowName("tidy");
        user.setPermissions(PERMISSIONS.MEMBER);
        String storedPassword = EncodeUtils.getEncodePass(user, registerTime);
        user.setStoredPassword(storedPassword);
        if(registerMapper.isUserExists(user) == 1){
            throw new ClientException("用户已存在");
        }
        registerMapper.register(user);
    }
}
