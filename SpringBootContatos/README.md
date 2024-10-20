# Simple API Java

Aplicação API voltado para envio e recebimento de e-mail, integrado ao Mailtrap, conectado ao banco de dados Oracle utilizando método db.migration para controle de versionamento no próprio banco.
O aplicativo foi desenvolvido utilizando spring boot.

## Pré-requisitos

- Java 17
- Git
- Docker
- Docker Hub

## Build e execução

```sh
docker compose up --build
```

## Testes unitários (validação)

./mvnw test


## Documentação online (OpenAPI)

http://localhost:8080/swagger-ui/index.html

![](/assets/images/swagger.png)