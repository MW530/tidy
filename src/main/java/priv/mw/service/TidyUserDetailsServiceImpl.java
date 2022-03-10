package priv.mw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import priv.mw.domain.TidyUserDetail;
import priv.mw.domain.User;
import priv.mw.mapper.user.LoginMapper;

@Service
public class TidyUserDetailsServiceImpl implements UserDetailsService {

    private LoginMapper loginMapper;

    @Autowired
    public void setLoginMapper(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = loginMapper.getUserByName(s);
        UserDetails userDetails = new TidyUserDetail(user.getName(), user.getPassword(), user.isActivated(), user.isEnabled(), user.getPermissions());
        return userDetails;
    }
}
