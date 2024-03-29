package priv.mw.mapper.user;

import priv.mw.domain.PlainUser;
import priv.mw.domain.User;

public interface LoginMapper {
    public User getUserById(int id);
    public User getUserByName(String name);
}
