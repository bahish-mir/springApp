package lab.assist.controllers;

import lab.assist.constants.AppConstant;
import lab.assist.model.entity.User;
import lab.assist.model.exceptions.DAOException;
import lab.assist.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizationController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = AppConstant.AUTHORIZATION_URL, method = RequestMethod.GET)
    public String logIn(@RequestParam(value = AppConstant.LOGIN_COL) String login,
                        @RequestParam(value = AppConstant.PASSWORD_COL) String password,
                        Model model) {
        User user = null;

        try {
            user = userService.getUser(login, password);
            if (user == null) {
                throw new DAOException(AppConstant.USER_NOT_FOUND_MESSAGE);
            }
            model.addAttribute(AppConstant.USER_JSP_ATTR, user);

            return AppConstant.MAIN_PATH;
        } catch (DAOException e) {
            model.addAttribute(AppConstant.MESSAGE_ATTR, e.getMessage());

            return AppConstant.REGISTRATION_PATH;
        }
    }
}
