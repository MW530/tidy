package priv.mw.domain;

import lombok.Data;

@Data
public class PlainUser {
    private Integer id;
    private String name;
    private String email;
    private String showName;
    private boolean activated;
}
