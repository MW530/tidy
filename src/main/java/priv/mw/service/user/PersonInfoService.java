package priv.mw.service.user;

public interface PersonInfoService {
    public void updateAvatar(int avatarId, int uId);
    public void updateShowName(String name, int uId);
    public void updateDescription(String description, int uId);
}
