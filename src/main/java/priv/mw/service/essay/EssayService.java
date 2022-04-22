package priv.mw.service.essay;

import priv.mw.domain.Essay;

public interface EssayService {
    public void addEssay(Essay essay);
    public void delEssay(Integer id);
    public void updateEssay(Essay essay);
    public Essay findEssayById(Integer id);
    public Essay[] findEssays();
}
