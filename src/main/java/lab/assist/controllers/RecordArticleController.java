package lab.assist.controllers;

import lab.assist.constants.AppConstant;
import lab.assist.model.entity.Article;
import lab.assist.model.entity.User;
import lab.assist.model.service.ArticlesService;
import lab.assist.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RecordArticleController {
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

    @RequestMapping(value = AppConstant.RECORD_ARTICLE_URL, method = RequestMethod.POST)
    public String recordArticle(@RequestParam(AppConstant.USER_ID_COL) int userID,
                                @RequestParam(AppConstant.HEADER_COL) String header,
                                @RequestParam(AppConstant.SHORT_DESCRIPTION_COL) String shortDescription,
                                @RequestParam(AppConstant.TEXT_ARTICLES_COL) String textArticle,
                                @RequestParam(AppConstant.DATE_CREATE_COL) String dateCreate,
                                @RequestParam(AppConstant.AUTHOR_COL) String author,
                                Model model) {
        User user = userService.getUserById(userID);
        articlesService.createArticle(header, shortDescription, textArticle, dateCreate, author);
        Article article = articlesService.getArticle(header, shortDescription, textArticle, dateCreate, author);
        user.addArticle(article);
        model.addAttribute(AppConstant.USER_ATTR, user);

        return AppConstant.MAIN_PATH;
    }
}
