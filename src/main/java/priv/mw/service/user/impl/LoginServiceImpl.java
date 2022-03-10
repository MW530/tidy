package priv.mw.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.mw.domain.User;
import priv.mw.exception.ServerException;
import priv.mw.mapper.user.LoginMapper;
import priv.mw.service.user.LoginService;

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
}
