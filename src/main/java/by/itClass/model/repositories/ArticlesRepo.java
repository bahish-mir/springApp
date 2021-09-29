package by.itClass.model.repositories;

import by.itClass.constants.AppConstant;
import by.itClass.model.entity.Article;
import by.itClass.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;

@Repository
public interface ArticlesRepo extends JpaRepository<Article, Integer>, CUArticlesRepo {
    Article findArticleById(int id);
    LinkedList<Article> findArticlesByUser(User user);

    @Query(value = AppConstant.SELECT_ONE_ARTICLE_BY_PARAMS_QUERY, nativeQuery = true)
    Article findArticle(@Param(AppConstant.HEADER_COL) String header,
                        @Param(AppConstant.SHORT_DESCRIPTION_COL) String shortDescription,
                        @Param(AppConstant.TEXT_ARTICLES_COL) String textArticles,
                        @Param(AppConstant.DATE_CREATE_COL) String dateCreate,
                        @Param(AppConstant.AUTHOR_COL) String author);

    void deleteArticlesByUser(User user);
    void deleteArticlesById(int id);
}
