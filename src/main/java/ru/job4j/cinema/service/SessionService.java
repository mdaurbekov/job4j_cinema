package ru.job4j.cinema.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cinema.model.Session;
import ru.job4j.cinema.repository.SessionRepository;

import java.util.List;

@Service
@ThreadSafe
public class SessionService {
    private SessionRepository repository;

    public SessionService(SessionRepository store) {
        this.repository = store;
    }

    public List<Session> getAll() {
        return repository.findAll();
    }
    public Session findById(int id) {
        return repository.findById(id);
    }
}
