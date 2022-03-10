package priv.mw.domain;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String permissions;
    private String showName;
    private boolean enabled;
    private boolean activated;
}
