package by.itClass.controllers;

import by.itClass.constants.AppConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExitController {

    @RequestMapping(AppConstant.LOG_OUT_URL)
    public String logOut() {
        return "/";
    }
}
