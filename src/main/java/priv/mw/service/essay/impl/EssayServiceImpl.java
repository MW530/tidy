package priv.mw.service.essay.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import priv.mw.domain.Essay;
import priv.mw.domain.Groups;
import priv.mw.domain.Tag;
import priv.mw.mapper.essay.EssayMapper;
import priv.mw.mapper.group.GroupMapper;
import priv.mw.mapper.tag.TagMapper;
import priv.mw.service.essay.EssayService;

@Service
public class EssayServiceImpl implements EssayService {

    private EssayMapper essayMapper;
    private TagMapper tagMapper;
    private GroupMapper groupMapper;

    @Autowired
    public void setEssayMapper(EssayMapper essayMapper) {
        this.essayMapper = essayMapper;
    }

    @Autowired
    public void setTagMapper(TagMapper tagMapper) {
        this.tagMapper = tagMapper;
    }

    @Autowired
    public void setGroupMapper(GroupMapper groupMapper) {
        this.groupMapper = groupMapper;
    }

    @Override
    @Transactional
    public void addEssay(Essay essay) {
        // tags装配
        Tag[] tags = essay.getTags();
        for (int i = 0; i <tags.length; i++) {
            Tag newTag = tagMapper.findTagByName(tags[i].getName());
            if(newTag != null){
                tags[i] = newTag;
            }else {
                tagMapper.addTag(tags[i]);
            }
        }

        // group装配
        Groups group = essay.getGroups();
        Groups newGroups = groupMapper.findGroupByName(group.getName());
        if(newGroups != null){
            essay.setGroups(newGroups);
        }else{
            groupMapper.addGroup(group);
        }
        essayMapper.addEssay(essay);
    }

    @Override
    public void delEssay(Integer id) {

    }

    @Override
    public void updateEssay(Essay essay) {

    }

    @Override
    public void findEssayById(Integer id) {

    }
}
