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
                "nome": "Dummy"
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
- POST ```/agendas```: Cria uma nova agenda.
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
- GET ```/alunos```: Retorna lista de todos os alunos.
- GET ```/tutores```: Retorna lista de todos os tutores.
- GET ```/agendas```: Retorna lista de todas as agendas.
- GET ```/materias```: Retorna lista de todos os materiais.

- GET ```/alunos/:id```: Retorna apenas o aluno com id informado.
- GET ```/tutores/:id```: Retorna apenas o tutor com id informado.
- GET ```/agendas/:id```: Retorna apenas a agenda com id informado.
- GET ```/materias/:id```: Retorna apenas o material com id informado.

### UPDATE
- PUT ```/alunos/:id```: Altera os dados do aluno com id informado.
    * RequestBody:
      ```json
            {
                "nome": "Dummy"
            }
        ```
- PUT ```/tutores/:id```: Altera os dados do tutor com id informado.
- PUT ```/agendas/:id```: Altera os dados da agenda com id informado.
- PUT ```/materias/:id```: Altera os dados do material com id informado.

### DELETE
- DELETE  ```/alunos/:id```: Exclui apenas o aluno com id informado.
- DELETE  ```/tutores/:id```: Exclui apenas o tutor com id informado.
- DELETE  ```/agendamentos/:id```: Exclui apenas a agenda com id informado.
- DELETE  ```/materias/:id```: Exclui apenas o material com id informado.

--- 
## 📋 Todo List
- [x] [Exercício 1 - Setup: Projeto de tutoria](#-m1s10-ex-1---setup-projeto-de-tutoria)
- [x] [Exercício 2 - CRUD Alunos](#-m1s10-ex-2---crud-alunos)
- [ ] [Exercício 3 - CRUD Tutores](#-m1s10-ex-3---crud-tutores)
- [ ] [Exercício 4 - CRUD Agendamento](#-m1s10-ex-4---crud-agendamento)
- [ ] [Exercício 5 - CRUD Materiais](#-m1s10-ex-5---crud-materiais)
- [ ] [Exercício 6 - Consultar agendamentos](#-m1s10-ex-6---consultar-agendamentos)
- [ ] [Exercício 7 - Consultar próximos agendamentos](#-m1s10-ex-7---consultar-próximos-agendamentos)


## 📂 Descrição dos exercícios
### 📖 [M1S10] Ex 1 - Setup: Projeto de tutoria
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

### 📖 [M1S10] Ex 2 - CRUD Alunos
Criar CRUD para a entidade Aluno.<br/>
Utilize adequadamente os padrões REST e MVC.<br/>
Não se esqueça do tratamento de exceções, status de resposta e seus métodos HTTP.

### 📖 [M1S10] Ex 3 - CRUD Tutores
Criar CRUD para a entidade Tutor.<br/>
Utilize adequadamente os padrões REST e MVC.<br/>
Não se esqueça do tratamento de exceções, status de resposta e seus métodos HTTP.

### 📖 [M1S10] Ex 4 - CRUD Agendamento
Criar CRUD para a entidade Agenda.<br/>
Utilize adequadamente os padrões REST e MVC.<br/>
Não se esqueça do tratamento de exceções, status de resposta e seus métodos HTTP.

### 📖 [M1S10] Ex 5 - CRUD Materiais
Criar CRUD para a entidade Material.<br/>
Utilize adequadamente os padrões REST e MVC.<br/>
Não se esqueça do tratamento de exceções, status de resposta e seus métodos HTTP.

### 📖 [M1S10] Ex 6 - Consultar agendamentos
Criar endpoints para consultar TODOS os agendamentos pertencentes para alunos e tutores.<br/>
Endpoints:
- GET /agendamentos/aluno-id/{alunoId}
- GET /agendamentos/tutor-id/{tutorId}
1. Retornar os registros em ordem crescente de data
2. Utilize adequadamente os padrões REST e MVC.

Não se esqueça do tratamento de exceções, status de resposta e seus métodos HTTP.

### 📖 [M1S10] Ex 7 - Consultar próximos agendamentos
1. Criar endpoints para consultar OS PRÓXIMOS agendamentos pertencentes para alunos e tutores.
2. Criar endpoints distintos para alunos e tutores, assim como o exercício anterior.
3. Retornar os registros em ordem crescente de data
4. Utilize adequadamente os padrões REST e MVC.

Não se esqueça do tratamento de exceções, status de resposta e seus métodos HTTP.
