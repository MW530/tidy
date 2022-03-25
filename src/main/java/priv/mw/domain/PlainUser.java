package priv.mw.domain;

import lombok.Data;
import priv.mw.service.user.impl.RegisterServiceImpl;

@Data
public class PlainUser {
    private Integer id;
    private String name;
    private String email;
    private String showName;
    private boolean enabled;
    private RegisterServiceImpl.PERMISSIONS permissions;
    private boolean activated;
    private String token;
}
