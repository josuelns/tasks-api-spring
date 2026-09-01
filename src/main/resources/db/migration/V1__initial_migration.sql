CREATE TABLE users
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id),
    CONSTRAINT users_email_unique UNIQUE (email)
);

CREATE TABLE todos
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    title       VARCHAR(255) NOT NULL,
    description TEXT NULL,
    completed   BOOLEAN NOT NULL DEFAULT FALSE,
    user_id     BIGINT NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id),
    CONSTRAINT todos_user_id_fk FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE INDEX todos_user_id_fk ON todos (user_id);
