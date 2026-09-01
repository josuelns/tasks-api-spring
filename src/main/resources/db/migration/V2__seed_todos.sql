INSERT INTO users (name, email) VALUES
('Ana Silva', 'ana.silva@email.com'),
('Bruno Costa', 'bruno.costa@email.com'),
('Carla Mendes', 'carla.mendes@email.com');

INSERT INTO todos (title, description, completed, user_id) VALUES
('Estudar Spring Boot', 'Revisar controllers, services e repositories', false, 1),
('Fazer exercícios', 'Praticar CRUD com JPA', true, 1),
('Ler documentação', 'Validação com Bean Validation', false, 2),
('Configurar banco', 'MySQL + Flyway migrations', true, 2),
('Criar testes', 'Testar endpoints da API', false, 3);
