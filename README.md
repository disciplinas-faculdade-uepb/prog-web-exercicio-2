<div align="center">
  <h1>Exercicio 2</h1>
</div>

## Rodar o projeto

### Containers do `PgAdmin` e o `PostgreSQL`

```
docker-compose up -d pgadmindb
```

> Após os containers do PgAdmin e o PostgreSQL você pode acessar o PGadmin em `http://localhost:16543`


### Container da aplicação

```
docker-compose up --build backend
```

## Rotas Insomnia

No arquivo `Insomnia_2022-09-24.json` você pode importar no `Insomnia` para usar a API.

### Rotas

- Alunos
  - **GET**: `/api/v1/alunos`
  - **GET**: `/api/v1/alunos/{id}`
  - **POST**: `/api/v1/alunos`
    ```
      {
        "name": "Ciclaninho 3",
        "mail": "ciclaninho3@de.tal",
        "register": "1m2891dniqwnxqbyuxmkasjnx3"
      }
    ```
  - **PUT**: `/api/v1/alunos/{id}`
    ```
      {
        "name": "Ciclaninho 3",
        "mail": "ciclaninho3@de.tal",
        "register": "1m2891dniqwnxqbyuxmkasjnx3"
      }
    ```
  - **DELETE**: `/api/v1/alunos/{id}`

- Professores
  - **GET**: `/api/v1/professores`
  - **GET**: `/api/v1/professores/{id}`
  - **POST**: `/api/v1/professores`
    ```
    {
      "name": "Fulaninho 2",
      "mail": "fulaninho2@de.tal",
      "formation": "Fulanagem",
      "register": "hcjabd1i2uhikncekj223"
    }
    ```
  - **PUT**: `/api/v1/professores/{id}`
    ```
    {
      "name": "Fulaninho 2",
      "mail": "fulaninho2@de.tal",
      "formation": "Fulanagem",
      "register": "hcjabd1i2uhikncekj223"
    }
    ```
  - **DELETE**: `/api/v1/professores/{id}`

- Turmas
  - **GET**: `/api/v1/turmas`
  - **GET**: `/api/v1/turmas/{id}`
  - **POST**: `/api/v1/turmas`
    ```
    {
      "discipline_name": "Ciencia da fulanagem - 1",
      "room": "Turma 321",
      "teacher_id": 1
    }
    ```
  - **PUT**: `/api/v1/turmas/{id}`
    ```
    {
      "discipline_name": "Ciencia da fulanagem - 1 (UPDATE)",
      "room": "Turma 321",
      "teacher_id": 1
    }
    ```
  - **DELETE**: `/api/v1/turmas/{id}`
  - **PATCH**: `/api/v1/turmas/{turmaId}/matricularAluno/{alunoId}`
