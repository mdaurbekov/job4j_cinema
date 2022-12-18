package ru.job4j.cinema.controller;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.cinema.model.Ticket;
import ru.job4j.cinema.model.User;
import ru.job4j.cinema.service.TicketService;
import ru.job4j.cinema.service.UserService;
import ru.job4j.cinema.util.UserSession;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@ThreadSafe
@Controller
public class TicketController {

    private TicketService ticketService;
    private UserService userService;

    public TicketController(TicketService ticketService, UserService userService) {
        this.ticketService = ticketService;
        this.userService = userService;
    }

    @PostMapping("/createTicket")
    public String createTicket(@ModelAttribute Ticket ticket, Model model, HttpSession session) {
        User user = UserSession.getUser(session);
        model.addAttribute("user", user);
        Optional<Ticket> optionalTicket = ticketService.add(ticket);
        if (optionalTicket.isEmpty()) {
            model.addAttribute("isfail", true);
            return "fail";
        }
        return "index";
    }

    @PostMapping("/cancelTicket")
    public String cancelTicket(@ModelAttribute Ticket ticket) {
        return "index";
    }

}
