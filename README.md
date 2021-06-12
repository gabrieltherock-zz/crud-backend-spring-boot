# crud-backend-spring-boot

Backend de um CRUD de filmes para a disciplina de Laboratório de Engenharia de Software.

Feito usando Spring Boot com banco de dados MySQL. Usei a biblioteca logbook para logar todas as requisições que chegaram ao backend.

# endpoints

GET /filmes --> retorna uma lista com todos os filmes no seguinte formato:

    {
        "id": 13,
        "titulo": "Gabriel da Rocha Souza",
        "diretor": "Fatec Zona Leste",
        "genero": "Ação",
        "ano": "2021"
    }

GET /filmes?titulo=gabriel --> retorna todos os filmes cujo título contém a palavra "gabriel", por exemplo

POST /filmes --> adiciona um filme

PUT /filmes/{id} --> atualiza o filme com id={id}

DELETE /filmes/{id} --> deleta o filme com id={id}

DELETE /filmes --> deleta todos os filmes
