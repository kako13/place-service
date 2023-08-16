# Place Service

<p>
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Desafio&color=8257E5&labelColor=000000" alt="Desafio " />
</p>

### Projeto Spring-Boot que disponibiliza uma API de lugares

Seguindo a proposta no canal de **[Giuliana Bezerra](https://www.youtube.com/@giulianabezerra)** *(https://github.com/giuliana-bezerra)* no Youtube, este é um
[desafio](https://github.com/RocketBus/quero-ser-clickbus/tree/master/testes/backend-developer) para desenvolvedores 
back-end destinado a candidatos na ClickBus. Uma API para gerenciar lugares (CRUD).

## Tecnologias:

* ###### [Java 20](https://www.oracle.com/news/announcement/oracle-releases-java-20-2023-03-21/)
* ###### [Spring Boot 3.1.2](https://spring.io/projects/spring-boot)
* ###### [Spring Webflux](https://docs.spring.io/spring-framework/reference/web/webflux.html)
* ###### [Spring Data + R2DBC](https://spring.io/projects/spring-data-r2dbc)
* ###### [H2](https://www.h2database.com/html/main.html)
* ###### [Slugfy](https://github.com/slugify) 
* ###### [Lombok](https://projectlombok.org/features/)

#### Motivações
- Uso do WebFlux - Atender requisições de forma assincrona para aplicações reativas
- Uso do R2DBC - Interações com o banco de dados de forma reativa
- Uso do H2 - Banco de dados em memória
- Uso do Slugfy - Gerar slug (slug-name)


## Práticas:
- SOLID
- Testes automatizados
- Uso de DTOs para API
- Injeção de Dependências
- API reativa na web e na camada de banco
- Geração de slugs automática com o Slugify
- Auditoria sobre criação e atualização da entidade via anotações (Desta forma o framework proverá as datas, não o cliente e nem o banco)
- Testes automatizados

  [//]: # (- Utilizando Slugfy para criar strings intercaladas de hífens a partir do nome do Place &#40;lugar&#41;)
  [//]: # (- Consultas com filtros dinâmicos usando o Query By Example)
  [//]: # (- Geração automática do Swagger com a OpenAPI 3)

## Como Executar

- Clone este repositório [git](https://github.com/kako13/place-service)
######
- Utilizando o Maven Wrapper e construa o projeto:
```
./mvnw clean package
```
### Local

- Rode a aplicação:
```
java -jar place-service/target/place-service-0.0.1-SNAPSHOT.jar
```
### Ou:

### Docker

- Utilizando o Maven Wrapper e crie a imagem do projeto para o docker:
```
.\mvnw spring-boot:build-image
```

- Rode a aplicação:
```
docker run --name place-service -p 8080:8080 -d place-service:0.0.1-SNAPSHOT
```

### Por fim:

Acesse a API em [localhost:8080](http://localhost:8080).

