package priv.mw.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.mw.domain.PlainUser;
import priv.mw.domain.User;
import priv.mw.exception.AuthException;
import priv.mw.mapper.user.LoginMapper;
import priv.mw.service.user.LoginService;
import priv.mw.utils.DateTimeUtils;
import priv.mw.utils.EncodeUtils;
import priv.mw.utils.JWTUtils;

import java.util.HashMap;

@Service
public class LoginServiceImpl implements LoginService {
    private LoginMapper loginMapper;

    @Autowired
    public void setLoginMapper(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    @Override
    public User getUserById(int id) {
        return loginMapper.getUserById(id);
    }

    @Override
    public HashMap login(User user) throws AuthException {
        User existingUser = loginMapper.getUserByName(user.getName());
        if(existingUser == null){
            // 账号不存在
            throw new AuthException("账号或密码错误！");
        }
        String encodePass = EncodeUtils.getEncodePass(user, existingUser.getRegisterTime());
        if(existingUser.getPassword().equals(encodePass)){
            HashMap<String, Object> map = new HashMap<>(){{
                put("id", existingUser.getId());
                put("name", existingUser.getName());
            }};
            String token = JWTUtils.generateToken(map);
            HashMap<String, Object> res = new HashMap<>(){{
                putAll(map);
                put("token", token);
                put("email", existingUser.getEmail());
                put("permissions", String.valueOf(existingUser.getPermissions()));
                put("showName", existingUser.getShowName());
                put("enabled", existingUser.isEnabled());
                put("activated", existingUser.isActivated());
                put("registerTime", DateTimeUtils.localDateTime2timeStamp(existingUser.getRegisterTime()));
            }};
            return res;
        }else{
            // 密码错误
            throw new AuthException("账号或密码错误！");
        }
    }
}
