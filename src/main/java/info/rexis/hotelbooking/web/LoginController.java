package info.rexis.hotelbooking.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class LoginController {
    public static final String LOGIN_FORM = "login";

    @GetMapping(LOGIN_FORM)
    public String showLoginForm(@RequestParam(name = "error", required = false) String error, Model model) {
        if ("true".equals(error)) {
            model.addAttribute("loginerror", "true");
        }
        return LOGIN_FORM;
    }
}