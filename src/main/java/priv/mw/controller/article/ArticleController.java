package priv.mw.controller.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.mw.annotation.UserId;
import priv.mw.domain.Article;
import priv.mw.service.article.ArticleService;

@RestController("ArticleController")
@RequestMapping("/article")
public class ArticleController {

    private ArticleService articleService;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/addArticle")
    public void addArticle(@UserId Article article){
        articleService.addArticle(article);
    }

    @GetMapping("delArticle")
    public void delArticle(int id){
        articleService.delArticle(id);
    }

    @PostMapping("/updateArticle")
    public void updateArticle(@UserId Article article){
        articleService.updateArticle(article);
    }

    @GetMapping("getArticleById")
    public Article getArticleById(int id){
        return articleService.findArticleById(id);
    }

    @GetMapping("allArticle")
    public Article[] allArticle(){
        return articleService.findAllArticles();
    }
}
