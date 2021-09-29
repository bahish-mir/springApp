package by.itClass.model.repositories;

import by.itClass.constants.AppConstant;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@NoRepositoryBean
public interface CUArticlesRepo {

    @Modifying
    @Transactional
    @Query(value = AppConstant.INSERT_ARTICLE_QUERY, nativeQuery = true)
    void createArticle(@Param(AppConstant.HEADER_COL) String header,
                       @Param(AppConstant.SHORT_DESCRIPTION_COL) String shortDescription,
                       @Param(AppConstant.TEXT_ARTICLES_COL) String textArticles,
                       @Param(AppConstant.DATE_CREATE_COL) String dateCreate,
                       @Param(AppConstant.AUTHOR_COL) String author);

    @Modifying
    @Transactional
    @Query(value = AppConstant.UPDATE_ARTICLE_FROM_ARTICLES_QUERY, nativeQuery = true)
    void editArticle(@Param(AppConstant.HEADER_COL) String header,
                     @Param(AppConstant.SHORT_DESCRIPTION_COL) String shortDescription,
                     @Param(AppConstant.TEXT_ARTICLES_COL) String textArticles,
                     @Param(AppConstant.DATE_CREATE_COL) String dateCreate,
                     @Param(AppConstant.AUTHOR_COL) String author,
                     @Param(AppConstant.ID_COL) int id);
}
