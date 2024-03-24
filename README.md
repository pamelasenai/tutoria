![logo](images/logo.png)

# Projeto Tutoria
#### _Exercícios da Semana 10 - (18/03/2024 a 22/03/2024)_

## ✏️ Descrição
Este projeto Java baseado em Spring com PostgreSQL e JPA foi desenvolvido como uma solução para as atividades propostas
pelo professor no contexto de um sistema de biblioteca. <br/>
O objetivo é ser uma plataforma que conecta alunos que precisam de assistência adicional em disciplinas específicas com tutores qualificados.

## 📌 Entidades do Projeto
### Aluno
- Nome

### Tutor
- Nome
- Especialidade

### Agenda
- Aluno
- Tutor
- Data
- Status
- Tema
- Descrição breve

### Material
- Agenda
- Descrição
- Caminho do Arquivo (URLs ou caminhos de pastas)

---
## 🎯 Endpoints
### CREATE
- POST ```/alunos```: Cria um novo aluno.
    * RequestBody:
      ```json
            {
                "titulo": "titulo",
                "autor": "autor",
                "anoPublicacao": 2025
            }
        ```
- POST ```/tutores```: Cria um novo tutor.
    * RequestBody:
      ```json
            {
                "titulo": "titulo",
                "autor": "autor",
                "anoPublicacao": 2025
            }
        ```
- POST ```/agendamentos```: Cria uma nova agenda.
    * RequestBody:
      ```json
            {
                "titulo": "titulo",
                "autor": "autor",
                "anoPublicacao": 2025
            }
        ```
- POST ```/materias```: Cria um novo material.
    * RequestBody:
      ```json
            {
                "titulo": "titulo",
                "autor": "autor",
                "anoPublicacao": 2025
            }
        ```
<!-- //TODO alterar RequestBody-->

### READ
- GET ```/alunos```:
- GET ```/tutores```:
- GET ```/agendamentos```:
- GET ```/materias```:

- GET ```/alunos/:id```:
- GET ```/tutores/:id```:
- GET ```/agendamentos/:id```:
- GET ```/materias/:id```:

### UPDATE
- PUT ```/alunos/:id```:
- PUT ```/tutores/:id```:
- PUT ```/agendamentos/:id```:
- PUT ```/materias/:id```:

### DELETE
- DELETE  ```/alunos/:id```:
- DELETE  ```/tutores/:id```:
- DELETE  ```/agendamentos/:id```:
- DELETE  ```/materias/:id```:

--- 
## 📋 Todo List
- [ ] [Exercício 1 - Setup: Projeto de tutoria](#ex-1)
- [ ] [Exercício 2 - CRUD Alunos](#ex-2)
- [ ] [Exercício 3 - CRUD Tutores](#ex-3)
- [ ] [Exercício 4 - CRUD Agendamento](#ex-4)
- [ ] [Exercício 5 - CRUD Materiais](#ex-5)
- [ ] [Exercício 6 - Consultar agendamentos](#ex-6)
- [ ] [Exercício 7 - Consultar próximos agendamentos](#ex-7)

## EX 1
Criar uma plataforma que conecte alunos que precisam de ajuda extra em determinadas disciplinas com tutores qualificados.
A plataforma deve incluir:
- Agendamento de sessões de tutoria.
- Compartilhamento de materiais de estudo.

Criar entidades:
- Aluno
- - Nome
- Tutor
- - Nome
- - Especialidade
- Agenda
- - Aluno
- - Tutor
- - Data
- - Status
- - Tema
- - Descrição breve
- Material
- - Agenda
- - Descrição
- - Caminho do arquivo (armazenar URLs ou caminhos de pastas)

## Ex 2
Criar CRUD para a entidade Aluno.<br/>
Utilize adequadamente os padrões REST e MVC.<br/>
Não se esqueça do tratamento de exceções, status de resposta e seus métodos HTTP.

## Ex 3
Criar CRUD para a entidade Tutor.<br/>
Utilize adequadamente os padrões REST e MVC.<br/>
Não se esqueça do tratamento de exceções, status de resposta e seus métodos HTTP.

## Ex 4
Criar CRUD para a entidade Agenda.<br/>
Utilize adequadamente os padrões REST e MVC.<br/>
Não se esqueça do tratamento de exceções, status de resposta e seus métodos HTTP.

## Ex 5
Criar CRUD para a entidade Material.<br/>
Utilize adequadamente os padrões REST e MVC.<br/>
Não se esqueça do tratamento de exceções, status de resposta e seus métodos HTTP.

## Ex 6
Criar endpoints para consultar TODOS os agendamentos pertencentes para alunos e tutores.<br/>
Endpoints:
- GET /agendamentos/aluno-id/{alunoId}
- GET /agendamentos/tutor-id/{tutorId}
1. Retornar os registros em ordem crescente de data
2. Utilize adequadamente os padrões REST e MVC.

Não se esqueça do tratamento de exceções, status de resposta e seus métodos HTTP.

## Ex 7
1. Criar endpoints para consultar OS PRÓXIMOS agendamentos pertencentes para alunos e tutores.
2. Criar endpoints distintos para alunos e tutores, assim como o exercício anterior.
3. Retornar os registros em ordem crescente de data
4. Utilize adequadamente os padrões REST e MVC.

Não se esqueça do tratamento de exceções, status de resposta e seus métodos HTTP.
