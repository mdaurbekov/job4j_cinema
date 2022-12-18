package ru.job4j.cinema.model;

import java.util.Objects;

public class Ticket {
    private int id;
    private Session session;
    private int posRow;
    private int cell;
    private int userId;

    public Ticket() {
    }

    public Ticket(int id, Session session, int posRow, int cell, int userId) {
        this.id = id;
        this.session = session;
        this.posRow = posRow;
        this.cell = cell;
        this.userId = userId;
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

    public int getPosRow() {
        return posRow;
    }

    public void setPosRow(int posRow) {
        this.posRow = posRow;
    }

    public int getCell() {
        return cell;
    }

    public void setCell(int cell) {
        this.cell = cell;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
