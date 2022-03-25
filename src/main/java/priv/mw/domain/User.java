package priv.mw.domain;

import lombok.Data;
import priv.mw.service.user.impl.RegisterServiceImpl;

import java.time.LocalDateTime;

@Data
public class User {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String storedPassword;
    private RegisterServiceImpl.PERMISSIONS permissions;
    private String showName;
    private boolean enabled;
    private boolean activated;
    private LocalDateTime registerTime;
    private String avatar;
    private String description;
}
