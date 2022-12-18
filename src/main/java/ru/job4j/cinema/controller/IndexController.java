package ru.job4j.cinema.controller;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.cinema.model.User;
import ru.job4j.cinema.service.SessionService;
import ru.job4j.cinema.util.UserSession;

import javax.servlet.http.HttpSession;

@Controller
@ThreadSafe
public class IndexController {
    private SessionService sessionService;

    public IndexController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping("/index")
    public String index(Model model, HttpSession session) {
        User user = UserSession.getUser(session);
        model.addAttribute("user", user);
        model.addAttribute("movies", sessionService.getAll());
        return "index";
    }

}
