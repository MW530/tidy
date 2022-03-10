package priv.mw.service.user;

import priv.mw.domain.User;
import priv.mw.exception.ClientException;

public interface RegisterService {
    public void register(User user) throws ClientException;
}
