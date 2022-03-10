package priv.mw.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
public class TidyUserDetail implements UserDetails {
    private String username;
    private String password;
    private boolean activated;
    private boolean enabled;
    private String permissions;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> permissionsList = new ArrayList<>();
        for (String s : permissions.split(";")) {
            TidyGrantedAuthority authority = new TidyGrantedAuthority(s);
            permissionsList.add(authority);
        }
        return permissionsList;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.activated;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
