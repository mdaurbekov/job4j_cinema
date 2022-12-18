CREATE TABLE ticket (
    id SERIAL PRIMARY KEY,
    session_id INT NOT NULL REFERENCES sessions(id),
    posRow INT NOT NULL,
    cell INT NOT NULL,
    userId INT NOT NULL REFERENCES users(id)
);