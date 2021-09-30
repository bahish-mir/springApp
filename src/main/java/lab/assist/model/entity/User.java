package lab.assist.model.entity;

import lab.assist.constants.AppConstant;
import lombok.Data;

import javax.persistence.*;
import java.util.LinkedList;

@Entity
@Table(name = AppConstant.USERS_TABLE)
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String password;

    @OneToMany(mappedBy = AppConstant.USER_ATTR, cascade = CascadeType.ALL)
    private LinkedList<Article> articles;

    public Article getArticle(int id) {
        Article theArticle = null;
        if (!articles.isEmpty()) {
            for (Article article : articles) {
                if (article.getId() == id) {
                    theArticle = article;
                }
            }
        }

        return theArticle;
    }

    public void addArticle(Article article) {
        if (!articles.contains(article)) {
            articles.add(article);
        }
    }

    public void updateArticle(Article artic) {
        if (!articles.isEmpty()) {
            for (Article article : articles) {
                if (article.getId() == artic.getId()) {
                    int index = articles.indexOf(article);
                    articles.set(index, artic);
                }
            }
        }
    }
}
