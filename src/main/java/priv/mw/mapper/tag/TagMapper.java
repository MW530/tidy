package priv.mw.mapper.tag;

import priv.mw.domain.Tag;

public interface TagMapper {
    public void addTag(Tag tag);
    public Tag findTagByName(String name);
}
