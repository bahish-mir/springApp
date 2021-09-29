package by.itClass.model.entity;

import by.itClass.constants.AppConstant;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = AppConstant.ARTICLE_TABLE)
@Data
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String header;
    private String shortDescription;

    @Column(name = AppConstant.TEXT_ARTICLES_NAME_COLUMN)
    private String textArticle;
    private String dateCreate;
    private String author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = AppConstant.USER_ID_ATTR)
    private User user;
}
