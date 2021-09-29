package by.itClass.controllers;

import by.itClass.constants.AppConstant;
import by.itClass.model.entity.Article;
import by.itClass.model.entity.User;
import by.itClass.model.service.ArticlesService;
import by.itClass.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditArticleController {
    private ArticlesService articlesService;
    private UserService userService;

    @Autowired
    public void setArticlesService(ArticlesService articlesService) {
        this.articlesService = articlesService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = AppConstant.EDIT_ARTICLE_URL, method = RequestMethod.PUT)
    public String editArticle(@RequestParam(AppConstant.USER_ID_COL) int userID,
                              @RequestParam(AppConstant.ARTICLE_ID_COL) int articleID,
                              @RequestParam(AppConstant.HEADER_COL) String header,
                              @RequestParam(AppConstant.SHORT_DESCRIPTION_COL) String shortDescription,
                              @RequestParam(AppConstant.TEXT_ARTICLES_COL) String textArticle,
                              @RequestParam(AppConstant.DATE_CREATE_COL) String dateCreate,
                              @RequestParam(AppConstant.AUTHOR_COL) String author,
                              Model model) {
        User user = userService.getUserById(userID);

        articlesService.editArticle(header, shortDescription, textArticle, dateCreate, author, articleID);
        Article article = articlesService.getArticleById(articleID);
        user.updateArticle(article);
        model.addAttribute(AppConstant.USER_ATTR, user);

        return "main";
    }
}
