package priv.mw.domain;

import lombok.Data;

@Data
public class Article {
    private Integer id;
    private Integer uid;
    private String name;
    private String content;
    private Tag[] tags;
    private Groups groups;
}
