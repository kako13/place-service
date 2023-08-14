# Place Service

<p>
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Desafio&color=8257E5&labelColor=000000" alt="Desafio " />
</p>

### Projeto Spring-Boot que disponibiliza uma API de lugares

Seguindo a proposta no canal de **[Giuliana Bezerra](https://www.youtube.com/@giulianabezerra)** no Youtube, este é um 
um [desafio](https://github.com/RocketBus/quero-ser-clickbus/tree/master/testes/backend-developer) para desenvolvedores 
back-end destinado a candidatos na ClickBus. Uma API para gerenciar lugares.

Foi utilizada uma abordagem alternativa para aplicações reativas,
por consequência, nossa camada de persistencia deve acompanhar a mesma abordagem reativa.
## Tecnologias:

* ###### [Java 20](https://www.oracle.com/news/announcement/oracle-releases-java-20-2023-03-21/)
* ###### [Spring Boot 3.1.2](https://spring.io/projects/spring-boot)
* ###### [Spring Webflux](https://docs.spring.io/spring-framework/reference/web/webflux.html)
* ###### [Spring Data + R2DBC](https://spring.io/projects/spring-data-r2dbc)
* ###### [H2](https://www.h2database.com/html/main.html)
* ###### [Slugfy](https://github.com/slugify) 
* ###### [Lombok](https://projectlombok.org/features/)

#### Motivações
- Uso do WebFlux - Alternativa reativa que escala bem em soluções web com Java e Spring
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

### Localmente
- Clonar repositório git
- Construir o projeto:
```
./mvnw clean package
```
- Executar:
```
java -jar place-service/target/place-service-0.0.1-SNAPSHOT.jar
```

A API responderá em [localhost:8080](http://localhost:8080).

###

##### Observações sobre o código:
- Transformar o DTO de entrada (PlaceRequest) num Place (domínio) **faz parte da regra de negócio**. 
- Enquanto que, montar a resposta é responsabilidade do controlador, não é responsabilidade do service (camada de use cases) pois não é regra de negócio, é uma responsabilidade da interface da api, a camada web. O DTO não deve retornar o id 
- Ao utilizar as anotações de geração de datas de auditoria  ```@CreatedDate``` e ```@LastModifiedDate```, anotar a classe de configuração do Bean do dominio em questão com ```@EnableR2dbcAuditing```
- Desta forma o framework proverá as datas, não o cliente e nem o banco
- O Slugfy é mais conhecido no universo de front, e wordpress e é mais usado para criar o endpoint ou (slug-name) de aplicações
####
## Testes

#### Abordagens:
* Tradicional: Após o desenvolvimento
* TDD: Antes/durante o desenvolvimento

Sobre tipos de testes:

* Teste integração (fim à fim): tudo junto funcionando
* Teste unitário: um para cada camada (Controller, Service, Persistencia)

Neste projeto fizemos de forma tradicional e utilizaremos a abordagem de integração

Para criar um ambiente web no escopo do teste:

```@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)```

Para realizar requisições HTTP (alternativa ao RestTemplate):
WebTestClient webTestClient;
```
webTestClient
    .post()
    .uri("/places")
    .bodyValue(
    new PlaceRequest(name, state)
    )
    .exchange()
    .expectBody()
    .jsonPath("name").isEqualTo(name)
    .jsonPath("state").isEqualTo(state)
    .jsonPath("slug").isEqualTo(slug)
    .jsonPath("createdAt").isNotEmpty()
    .jsonPath("updatedAt").isNotEmpty();
```
A função determina que no exchange será realizada a requisição HTTP, aguardado um body de retorno, e as validações deste body.