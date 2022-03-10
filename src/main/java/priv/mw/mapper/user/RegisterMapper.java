package priv.mw.mapper.user;

import priv.mw.domain.User;

public interface RegisterMapper {
    public void register(User user);
    public int isUserExists(User user);
}
