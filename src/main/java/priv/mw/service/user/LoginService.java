package priv.mw.service.user;

import priv.mw.domain.PlainUser;
import priv.mw.domain.User;
import priv.mw.exception.AuthException;

import java.util.HashMap;

public interface LoginService {
    public User getUserById(int id);

    public HashMap login(User user) throws AuthException;
}
