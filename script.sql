create table users
(
    id       bigint auto_increment
        primary key,
    name     varchar(255) not null,
    email    varchar(255) not null,
    password varchar(255) not null
);

create table addresses
(
    id      bigint auto_increment
        primary key,
    street  varchar(255) not null,
    city    varchar(255) not null,
    zipcode varchar(255) not null,
    user_id bigint       not null,
    constraint addresses_users_id_fk
        foreign key (user_id) references users (id)
);

-- Dados de teste para GET /users no Opera: http://localhost:8080/users
INSERT INTO users (name, email, password) VALUES
('Ana Silva', 'ana.silva@email.com', 'senha123'),
('Bruno Costa', 'bruno.costa@email.com', 'senha123'),
('Carla Mendes', 'carla.mendes@email.com', 'senha123'),
('Diego Oliveira', 'diego.oliveira@email.com', 'senha123'),
('Elena Ferreira', 'elena.ferreira@email.com', 'senha123'),
('Felipe Santos', 'felipe.santos@email.com', 'senha123'),
('Gabriela Lima', 'gabriela.lima@email.com', 'senha123'),
('Henrique Alves', 'henrique.alves@email.com', 'senha123'),
('Isabela Rocha', 'isabela.rocha@email.com', 'senha123'),
('João Pereira', 'joao.pereira@email.com', 'senha123');

