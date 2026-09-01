# Todo List CRUD REST API

API REST para gerenciamento de tarefas (Todo List) com responsáveis (Users), construída com **Spring Boot 3**, **JPA**, **MySQL** e **Flyway**.

## Tecnologias

- Java 23
- Spring Boot 3.4
- Spring Data JPA
- Bean Validation
- MapStruct
- MySQL
- Flyway
- Lombok

## Pré-requisitos

- Java 23+
- MySQL rodando em `localhost:3306`
- Credenciais configuradas em `application.yaml`

## Como executar

```sh
./mvnw spring-boot:run
```

A API sobe em `http://localhost:8080`.

## Endpoints — Users

| Método   | Rota          | Descrição           | Status de sucesso |
|----------|---------------|---------------------|-------------------|
| `GET`    | `/users`      | Listar usuários     | 200               |
| `GET`    | `/users/{id}` | Buscar usuário      | 200 / 404         |
| `POST`   | `/users`      | Criar usuário       | 201               |
| `PUT`    | `/users/{id}` | Atualizar usuário   | 200 / 404         |
| `DELETE` | `/users/{id}` | Remover usuário     | 204 / 404         |

## Endpoints — Todos

| Método   | Rota          | Descrição           | Status de sucesso |
|----------|---------------|---------------------|-------------------|
| `GET`    | `/todos`      | Listar tarefas      | 200               |
| `GET`    | `/todos/{id}` | Buscar tarefa       | 200 / 404         |
| `POST`   | `/todos`      | Criar tarefa        | 201 / 400         |
| `PUT`    | `/todos/{id}` | Atualizar tarefa    | 200 / 404 / 400   |
| `DELETE` | `/todos/{id}` | Remover tarefa      | 204 / 404         |

> Cada tarefa possui um **responsável** (`userId`) obrigatório.

## Exemplos de requisição

### Criar usuário

```http
POST /users
Content-Type: application/json

{
  "name": "João Silva",
  "email": "joao@email.com"
}
```

### Criar tarefa

```http
POST /todos
Content-Type: application/json

{
  "title": "Estudar Java",
  "description": "Revisar collections e streams",
  "completed": false,
  "userId": 1
}
```

Resposta `201 Created`:

```json
{
  "id": 1,
  "title": "Estudar Java",
  "description": "Revisar collections e streams",
  "completed": false,
  "responsible": {
    "id": 1,
    "name": "Ana Silva",
    "email": "ana.silva@email.com"
  }
}
```

### Atualizar tarefa

```http
PUT /todos/1
Content-Type: application/json

{
  "title": "Estudar Java",
  "description": "Revisar collections, streams e lambdas",
  "completed": true,
  "userId": 2
}
```

### Erro — responsável não encontrado

```http
POST /todos
Content-Type: application/json

{
  "title": "Nova tarefa",
  "userId": 999
}
```

Resposta `400 Bad Request`:

```json
{
  "userId": "Responsável não encontrado"
}
```

## Estrutura do projeto

```
com.josueleando.todoapi/
├── controllers/
│   ├── TodoController.java
│   ├── UserController.java
│   └── GlobalExceptionHandler.java
├── dtos/
│   ├── TodoDto.java
│   ├── CreateTodoRequest.java
│   ├── UpdateTodoRequest.java
│   ├── UserDto.java
│   ├── CreateUserRequest.java
│   └── UpdateUserRequest.java
├── entities/
│   ├── Todo.java
│   └── User.java
├── mappers/
│   ├── TodoMapper.java
│   └── UserMapper.java
└── repositories/
    ├── TodoRepository.java
    └── UserRepository.java
```

## Banco de dados

O Flyway cria as tabelas `users` e `todos` (com FK `user_id`) e insere dados de exemplo.

Se o banco já existia com schema antigo, recrie o banco ou rode:

```sh
./mvnw flyway:clean flyway:migrate
```
