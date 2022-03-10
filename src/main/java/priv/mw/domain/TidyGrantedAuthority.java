package priv.mw.domain;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class TidyGrantedAuthority implements GrantedAuthority {
    private String permission;

    @Override
    public String getAuthority() {
        return permission;
    }
}
