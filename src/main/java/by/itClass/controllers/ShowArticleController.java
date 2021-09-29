package by.itClass.controllers;

import by.itClass.constants.AppConstant;
import by.itClass.model.entity.Article;
import by.itClass.model.exceptions.DAOException;
import by.itClass.model.service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShowArticleController {
    private ArticlesService articlesService;

    @Autowired
    public void setArticlesService(ArticlesService articlesService) {
        this.articlesService = articlesService;
    }

    @RequestMapping(value = AppConstant.SHOW_ARTICLE_URL, method = RequestMethod.GET, path = "/{id}")
    public String show(@PathVariable(AppConstant.ID_COL) int id, Model model) {
        try {
            Article article = articlesService.getArticleById(id);
            if (article == null) {
                throw new DAOException();
            }
            model.addAttribute(AppConstant.ARTICLE_ATTR, article);

            return "fullArticle";
        } catch (DAOException e) {
            model.addAttribute("message", e.getMessage());

            return "notfound";
        }
    }
}
