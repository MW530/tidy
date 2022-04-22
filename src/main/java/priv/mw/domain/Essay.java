package priv.mw.domain;

import lombok.Data;

import java.util.List;

@Data
public class Essay {
    private Integer id;
    private Integer uid;
    private String name;
    private String content;
    private Tag[] tags;
    private Integer articleId;
    private Groups groups;
    private List<Assets> assets;
}
