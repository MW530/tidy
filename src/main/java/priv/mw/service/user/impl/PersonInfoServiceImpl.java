package priv.mw.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.mw.mapper.user.PersonInfoMapper;
import priv.mw.service.user.PersonInfoService;

@Service("PersonInfoServiceImpl")
public class PersonInfoServiceImpl implements PersonInfoService {

    private PersonInfoMapper personInfoMapper;

    @Autowired
    public void setPersonInfoMapper(PersonInfoMapper personInfoMapper) {
        this.personInfoMapper = personInfoMapper;
    }

    @Override
    public void updateAvatar(int avatarId, int uId) {
        personInfoMapper.updateAvatar(avatarId, uId);
    }

    @Override
    public void updateShowName(String name, int uId) {
        personInfoMapper.updateShowName(name, uId);
    }

    @Override
    public void updateDescription(String description, int uId) {
        personInfoMapper.updateDescription(description, uId);
    }
}
