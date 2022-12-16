package ru.job4j.cinema.model;

import java.util.Objects;

public class Ticket {
    private int id;
    private Session session;
    private int pos_row;
    private int cell;
    private int user_id;

    public Ticket() {
    }

    public Ticket(int id, Session session, int pos_row, int cell, int user_id) {
        this.id = id;
        this.session = session;
        this.pos_row = pos_row;
        this.cell = cell;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public int getPos_row() {
        return pos_row;
    }

    public void setPos_row(int pos_row) {
        this.pos_row = pos_row;
    }

    public int getCell() {
        return cell;
    }

    public void setCell(int cell) {
        this.cell = cell;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ticket ticket = (Ticket) o;
        return id == ticket.id && Objects.equals(session, ticket.session);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, session);
    }

}
