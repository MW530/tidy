package priv.mw.mapper.group;

import priv.mw.domain.Groups;

public interface GroupMapper {
    public void addGroup(Groups groups);
    public Groups findGroupByName(String name);
}
