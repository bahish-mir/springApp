package by.itClass.controllers;

import by.itClass.constants.AppConstant;
import by.itClass.model.entity.User;
import by.itClass.model.exceptions.DAOException;
import by.itClass.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = AppConstant.REGISTRATION_URL, method = RequestMethod.GET)
    public String regIn(@RequestParam(value = AppConstant.LOGIN_COL) String login,
                        @RequestParam(value = AppConstant.PASSWORD_COL) String password,
                        Model model) {
        User user = null;
        user = userService.getUser(login, password);

        try {
            if (user != null) {
                throw new DAOException(AppConstant.USER_HAVE_ALREADY_MESSAGE);
            }
            user = userService.createUser(login, password);
            model.addAttribute("userJSP", user);

            return "main";
        } catch (DAOException e) {
            model.addAttribute("message", e.getMessage());

            return "notfound";
        }
    }
}
