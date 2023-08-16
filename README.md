# Place Service

<p>
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Desafio&color=8257E5&labelColor=000000" alt="Desafio " />
</p>

### Projeto Spring-Boot que disponibiliza uma API de lugares

Seguindo a proposta no canal de **[Giuliana Bezerra](https://www.youtube.com/@giulianabezerra)** *(https://github.com/giuliana-bezerra)* no Youtube, este é um
[desafio](https://github.com/RocketBus/quero-ser-clickbus/tree/master/testes/backend-developer) para desenvolvedores 
Back-end destinado a candidatos na ClickBus. Uma API para gerenciar lugares (CRUD).

## Tecnologias:

* ###### [Java 20](https://www.oracle.com/news/announcement/oracle-releases-java-20-2023-03-21/)
* ###### [Spring Boot 3.1.2](https://spring.io/projects/spring-boot)
* ###### [Spring Webflux](https://docs.spring.io/spring-framework/reference/web/webflux.html)
* ###### [Spring Data + R2DBC](https://spring.io/projects/spring-data-r2dbc)
* ###### [H2](https://www.h2database.com/html/main.html)
* ###### [Slugfy](https://github.com/slugify) 
* ###### [Lombok](https://projectlombok.org/features/)
* ###### [OpenAPI](https://springdoc.org)

#### Motivações
- Uso do WebFlux - Atender requisições de forma assincrona para aplicações reativas
- Uso do R2DBC - Interações com o banco de dados de forma reativa
- Uso do H2 - Banco de dados em memória
- Uso do Slugfy - Gerar slug (slug-name)
- Uso de OpenAPI - Documentar e testar a nossa API


## Práticas:
- SOLID
- Testes automatizados
- Uso de DTOs para API
- Injeção de Dependências
- API reativa na web e na camada de banco
- Geração de slugs automática com o Slugify
- Auditoria sobre criação e atualização da entidade via anotações (Desta forma o framework proverá as datas, não o cliente e nem o banco)
- Testes automatizados
- Documentação


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



Faça as requisições abaixo utilizando swagger, Postman, bash ou outra ferramenta da sua preferência:
###
#### **[- documentação swagger-ui](http://localhost:8080/swagger-ui.html)**
#### **[- swagger editor](https://editor.swagger.io)** (baixando o **[.json](http://localhost:8080/v3/api-docs)** ou **[.yaml](http://localhost:8080/v3/api-docs.yaml)** do projeto e colando no área de edição)
##
#### Create - [ POST ] [localhost:8080/places](localhost:8080/places)

```
curl --location 'localhost:8080/places' \
--header 'Content-Type: application/json' \
--data '{
    "name": "My Home", 
    "state": "Busy"
}'
```
#### Response
```
{
    "name": "My Home", 
    "slug": "my-home",
    "state": "Busy",
    "createdAt": "2023-08-16T07:40:04.9008813",
    "updatedAt": "2023-08-16T07:40:04.9008813"
}
```

##
#### Find - [ GET ] [localhost:8080/places/1](localhost:8080/places/1)
```
curl --location 'localhost:8080/places/1'
```
#### Response
```
{
    "name": "My Home", 
    "slug": "my-home",
    "state": "Busy",
    "createdAt": "2023-08-16T07:40:04.9008813",
    "updatedAt": "2023-08-16T07:40:04.9008813"
}
```

##
#### Update - [ PUT ] [localhost:8080/places/1](localhost:8080/places/1)
```
curl --location --request PUT 'localhost:8080/places/1' \
--header 'Content-Type: application/json' \
--data '{
    "name": "My new Home", 
    "state": "Available",
}'
```
#### Response
```
{
    "name": "My new Home", 
    "slug": "my-new-home",
    "state": "Available",
    "createdAt": "2023-08-16T07:40:04.9008813",
    "updatedAt": "2023-08-16T07:40:04.9008813"
}
```

##
#### List - [ GET ] [localhost:8080/places](localhost:8080/places)
```
curl --location 'localhost:8080/places'
```
```
[
    {
      "name": "My new Home", 
      "slug": "my-new-home",
      "state": "Available",
      "createdAt": "2023-08-16T07:40:04.9008813",
      "updatedAt": "2023-08-16T07:40:04.9008813"
    }
    ...
]
```

##
#### Remove - [ DELETE ] [localhost:8080/places](localhost:8080/places)
```
curl --location --request DELETE 'localhost:8080/places/1'
```
```
 (Nothing)
```



###
Acesse a API em [localhost:8080](http://localhost:8080).

