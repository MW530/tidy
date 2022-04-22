package priv.mw.mapper.article;

import priv.mw.domain.Article;

public interface ArticleMapper {
    public void addArticle(Article article);
    public void delArticle(int id);
    public void updateArticle(Article article);
    public Article getArticleById(int id);
    public Article[] findAllArticles();
}
