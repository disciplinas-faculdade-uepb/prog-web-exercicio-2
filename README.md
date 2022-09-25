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
