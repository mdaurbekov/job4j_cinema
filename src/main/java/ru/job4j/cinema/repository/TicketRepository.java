package ru.job4j.cinema.repository;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import ru.job4j.cinema.model.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

@Repository
public class TicketRepository {
    private static final Logger LOG = LogManager.getLogger(SessionRepository.class.getName());
    private static final String ADD = "INSERT INTO ticket (session_id, posRow, cell, userId) VALUES (?, ?, ?, ?)";
    private BasicDataSource pool;

    public TicketRepository(BasicDataSource pool) {
        this.pool = pool;
    }

    public Optional<Ticket> add(Ticket ticket) {
        Optional<Ticket> optionalTicket = Optional.empty();
        try (Connection cn = pool.getConnection();
             PreparedStatement ps = cn.prepareStatement(ADD,
                     PreparedStatement.RETURN_GENERATED_KEYS)
        ) {
            ps.setInt(1, ticket.getSession().getId());
            ps.setInt(2, ticket.getPosRow());
            ps.setInt(3, ticket.getCell());
            ps.setInt(4, ticket.getUserId());
            ps.execute();
            try (ResultSet id = ps.getGeneratedKeys()) {
                if (id.next()) {
                    ticket.setId(id.getInt(1));
                    optionalTicket = Optional.of(ticket);
                }
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return optionalTicket;
    }
}
