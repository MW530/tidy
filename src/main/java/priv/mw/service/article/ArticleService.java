package priv.mw.service.article;

import priv.mw.domain.Article;

public interface ArticleService {
    public void addArticle(Article article);
    public void delArticle(int id);
    public void updateArticle(Article article);
    public Article findArticleById(int id);
    public Article[] findAllArticles();
}
