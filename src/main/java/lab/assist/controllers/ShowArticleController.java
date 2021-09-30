package lab.assist.controllers;

import lab.assist.constants.AppConstant;
import lab.assist.model.entity.Article;
import lab.assist.model.exceptions.DAOException;
import lab.assist.model.service.ArticlesService;
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

    @RequestMapping(value = AppConstant.SHOW_ARTICLE_URL, method = RequestMethod.GET, path = AppConstant.ID_DYNAMIC_PARAM)
    public String show(@PathVariable(AppConstant.ID_COL) int id, Model model) {
        try {
            Article article = articlesService.getArticleById(id);
            if (article == null) {
                throw new DAOException();
            }
            model.addAttribute(AppConstant.ARTICLE_ATTR, article);

            return AppConstant.FULL_ARTICLE_PATH;
        } catch (DAOException e) {
            model.addAttribute(AppConstant.MESSAGE_ATTR, e.getMessage());

            return AppConstant.NOT_FOUND_PATH;
        }
    }
}
