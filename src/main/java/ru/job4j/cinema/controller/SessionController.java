package ru.job4j.cinema.controller;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.cinema.model.Ticket;
import ru.job4j.cinema.model.User;
import ru.job4j.cinema.service.SessionService;
import ru.job4j.cinema.util.UserSession;

import javax.servlet.http.HttpSession;

@ThreadSafe
@Controller
public class SessionController {
    private SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }


    @GetMapping("/movieSelection/{movieId}")
    public String movieSelection(Model model, @PathVariable("movieId") int id, HttpSession session) {
        User user = UserSession.getUser(session);
        model.addAttribute("user", user);
        session.setAttribute("movie_id", id);
        return "sessions";
    }

    @GetMapping("/rowSelection")
    public String rowSelection(Model model, @RequestParam(name = "row_id") int value, HttpSession session) {
        User user = UserSession.getUser(session);
        model.addAttribute("user", user);
        session.setAttribute("row_id", value);
        return "cell";
    }

    @GetMapping("/cellSelection")
    public String cellSelection(Model model, @RequestParam(name = "cell_id") int value, HttpSession session) {
        User user = UserSession.getUser(session);
        model.addAttribute("user", user);
        model.addAttribute("ticket",
                new Ticket(0, sessionService.findById((int) session.getAttribute("movie_id")),
                        (int) session.getAttribute("row_id"), value, user.getId()));
        return "addTicket";
    }

}
