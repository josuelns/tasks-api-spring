# tasks-api-spring

API REST para **tarefas com responsáveis**: relacionamento `Task ↔ User`, migrações versionadas com **Flyway** e validação de schema no boot.

Projeto de consolidação em **Java/Spring Boot** — JPA, DTOs com MapStruct e MySQL containerizado.

## Stack

| Camada | Tecnologias |
|---|---|
| Runtime | Java 23, Spring Boot 3.4 |
| API | REST, Bean Validation, MapStruct |
| Dados | Spring Data JPA, MySQL 8, Flyway |
| Infra | Docker Compose |

## Destaques

- **Relacionamento JPA**: `Todo` vinculado a `User` com integridade referencial
- **Flyway**: migrações `V1` (schema) e `V2` (seed)
- **DTOs tipados**: requests de criação/atualização separados das entidades
- **Exception handler global**: respostas HTTP consistentes

## Como rodar

```bash
# 1. MySQL
docker compose up -d

# 2. API
./mvnw spring-boot:run
```

| Serviço | URL / Porta |
|---|---|
| API | http://localhost:8080 |
| MySQL | `localhost:3306` — db `todo_api` (root / `MyPassword!`) |

## Endpoints REST

### Users

| Método | Rota | Descrição |
|---|---|---|
| `GET` | `/users` | Lista usuários |
| `GET` | `/users/{id}` | Busca por ID |
| `POST` | `/users` | Cria usuário |
| `PUT` | `/users/{id}` | Atualiza usuário |
| `DELETE` | `/users/{id}` | Remove usuário |

### Todos

| Método | Rota | Descrição |
|---|---|---|
| `GET` | `/todos` | Lista tarefas |
| `GET` | `/todos/{id}` | Busca por ID |
| `POST` | `/todos` | Cria tarefa (com `userId`) |
| `PUT` | `/todos/{id}` | Atualiza tarefa |
| `DELETE` | `/todos/{id}` | Remove tarefa |

## Testes

```bash
./mvnw test
```

## Projetos relacionados

- [cloud-parking-spring](https://github.com/josuelns/cloud-parking-spring) — API Spring Boot com Redis e testes de domínio
- [todolist-mvc](https://github.com/josuelns/todolist-mvc) — versão simplificada com H2 em memória
- [auth-api-prisma](https://github.com/josuelns/auth-api-prisma) — autenticação JWT + **Swagger/OpenAPI** (Node.js)

---

[Portfólio](https://josuelns.github.io/) · [GitHub](https://github.com/josuelns) · [LinkedIn](https://www.linkedin.com/in/josue-leandro-navarro)
