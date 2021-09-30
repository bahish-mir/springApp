package lab.assist.controllers;

import lab.assist.constants.AppConstant;
import lab.assist.constants.ConfigConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExitController {

    @RequestMapping(AppConstant.LOG_OUT_URL)
    public String logOut() {
        return ConfigConstant.ROOT_MAPPING;
    }
}
