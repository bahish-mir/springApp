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

import java.util.LinkedList;

@Controller
public class DeleteController {
    private UserService userService;
    private ArticlesService articlesService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setArticlesService(ArticlesService articlesService) {
        this.articlesService = articlesService;
    }

    @RequestMapping(value = AppConstant.DELETE_URL, method = RequestMethod.DELETE)
    public String deleteArticles(@RequestParam(value = AppConstant.USER_ID_COL) int userID,
                               Model model, @RequestParam(value = AppConstant.IDS_PARAM) int... ids) {
        User user = userService.getUserById(userID);

        for (int id : ids) {
            articlesService.deleteArticleById(id);
        }
        LinkedList<Article> articles = articlesService.getArticlesByUser(user);
        user.setArticles(articles);

        model.addAttribute(AppConstant.USER_ATTR, user);

        return "main";
    }
}
