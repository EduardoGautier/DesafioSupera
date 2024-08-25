# Sistema de Gerenciamento de Tarefas

## Descrição

Aplicação web para gerenciar tarefas diárias, permitindo criar, editar, listar, filtrar e excluir tarefas e listas de tarefas.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- JUnit e Mockito para testes

## Configuração do Ambiente

1. Instale o PostgreSQL e crie um banco de dados chamado `gerenciador_tarefas`.
2. Configure o arquivo `application.properties` com as credenciais do banco de dados.
3. Compile e execute o projeto usando Maven ou Gradle.

## Endpoints da API

- `GET /listas`: Lista todas as listas de tarefas.
- `POST /listas`: Cria uma nova lista de tarefas.
- `GET /listas`: Lista todas as tarefas, com opções de filtragem.
- `POST /listas`: Cria uma nova tarefa.
- `PUT /listas/`: Atualiza uma tarefa existente.
- `DELETE /listas/{id}`: Exclui uma tarefa.

## Contribuindo

- Fork o projeto.
- Crie uma branch para sua feature (`git checkout -b minha-feature`).
- Faça commit das suas alterações (`git commit -m 'Adicionei minha feature'`).
- Push para a branch (`git push origin minha-feature`).
- Crie um Pull Request.
