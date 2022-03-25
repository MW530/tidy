package priv.mw.mapper.essay;

import priv.mw.domain.Essay;

public interface EssayMapper {
    public void addEssay(Essay essay);
    public void delEssay(Integer id);
    public void updateEssay(Essay essay);
    public Essay[] findAllEssays();
    public Essay findEssayById(Integer id);
}
