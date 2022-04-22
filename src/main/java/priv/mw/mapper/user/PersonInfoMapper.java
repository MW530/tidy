package priv.mw.mapper.user;

import org.apache.ibatis.annotations.Param;

public interface PersonInfoMapper {
    public void updateAvatar(@Param("avatarId") int avatarId,@Param("uId") int uId);
    public void updateShowName(@Param("showName")String showName,@Param("uId") int uId);
    public void updateDescription(@Param("description")String description,@Param("uId") int uId);
}
