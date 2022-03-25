package priv.mw.domain;

import lombok.Data;

//@Data
public class Essay {
    private Integer id;
    private Integer uid;
    private String name;
    private String content;
    private Tag[] tags;
    private Integer articleId;
    private Groups groups;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Tag[] getTags() {
        return tags;
    }

    public void setTags(Tag[] tags) {
        this.tags = tags;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups group) {
        this.groups = group;
    }
}
