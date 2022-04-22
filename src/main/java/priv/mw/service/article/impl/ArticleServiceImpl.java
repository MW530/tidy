package priv.mw.service.article.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.mw.domain.Article;
import priv.mw.domain.Essay;
import priv.mw.domain.Groups;
import priv.mw.domain.Tag;
import priv.mw.mapper.article.ArticleMapper;
import priv.mw.mapper.group.GroupMapper;
import priv.mw.mapper.tag.TagMapper;
import priv.mw.service.article.ArticleService;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    private ArticleMapper articleMapper;
    private TagMapper tagMapper;
    private GroupMapper groupMapper;

    @Autowired
    public void setArticleMapper(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
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
    public void addArticle(Article article) {
        assembleArticle(article);
        articleMapper.addArticle(article);
    }

    @Override
    public void delArticle(int id) {
        articleMapper.delArticle(id);
    }

    @Override
    public void updateArticle(Article article) {
        assembleArticle(article);
        articleMapper.updateArticle(article);
    }

    @Override
    public Article findArticleById(int id) {
        return articleMapper.getArticleById(id);
    }

    @Override
    public Article[] findAllArticles() {
        return articleMapper.findAllArticles();
    }

    private void assembleArticle(Article article){
        // tags装配
        Tag[] tags = article.getTags();
        for (int i = 0; i <tags.length; i++) {
            Tag newTag = tagMapper.findTagByName(tags[i].getName());
            if(newTag != null){
                tags[i] = newTag;
            }else {
                tagMapper.addTag(tags[i]);
            }
        }

        // group装配
        Groups group = article.getGroups();
        Groups newGroups = groupMapper.findGroupByName(group.getName());
        if(newGroups != null){
            article.setGroups(newGroups);
        }else{
            groupMapper.addGroup(group);
        }
    }
}
