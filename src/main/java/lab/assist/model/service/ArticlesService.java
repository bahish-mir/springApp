package lab.assist.model.service;

import lab.assist.model.entity.Article;
import lab.assist.model.entity.User;
import lab.assist.model.repositories.ArticlesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class ArticlesService {
    private ArticlesRepo articlesRepo;

    @Autowired
    public void setArticlesRepo(ArticlesRepo articlesRepo) {
        this.articlesRepo = articlesRepo;
    }

    public Article getArticleById(int id) {
        return articlesRepo.findArticleById(id);
    }

    public Article getArticle(String header, String shortDescription, String textArticles, String dateCreate, String author) {
        return articlesRepo.findArticle(header, shortDescription, textArticles, dateCreate, author);
    }

    public LinkedList<Article> getArticlesByUser(User user) {
        return articlesRepo.findArticlesByUser(user);
    }

    public void deleteArticlesByUser(User user) {
        articlesRepo.deleteArticlesByUser(user);
    }

    public void deleteArticleById(int id){
        articlesRepo.deleteArticlesById(id);
    }

    public void createArticle(String header, String shortDescription, String textArticles, String dateCreate, String author) {
        articlesRepo.createArticle(header, shortDescription, textArticles, dateCreate, author);
    }

    public void editArticle(String header, String shortDescription, String textArticles, String dateCreate, String author, int id) {
        articlesRepo.editArticle(header, shortDescription, textArticles, dateCreate, author, id);
    }
}
