# place-service
### Projeto Spring-Boot que disponibiliza uma API de lugares

Seguindo a solução proposta no canal de **[Giuliana Bezerra](https://www.youtube.com/@giulianabezerra)** no Youtube sobre o seguinte 
[desafio](https://github.com/RocketBus/quero-ser-clickbus/tree/master/testes/backend-developer). para que seja 
desenvolvida uma API de lugares. Foi utilizada uma abordagem alternativa para aplicações reativas, por consequência, 
nossa camada de persistencia deve acompanhar a mesma abordagem reativa.

Configuração / Como rodar:
###### Clone o projeto, importe para sua IDE de preferência e execute
* ###### Java 20
* ###### Spring Boot
* ###### R2DBC (para interações com o banco de dados de forma reativa)

Dependências:
* ###### H2
* ###### R2DBC (para interações com o banco de dados de forma reativa)
* ###### Webflux (alternativa reativa que escala bem em soluções web com Java e Spring)
* ###### Lombok
Banco de dados:
* ###### Em memória (H2)


Práticas:

* ###### Uso de DTO para requests e responses
* ###### Uso de anotações de geração de datas de auditoria (Desta forma o framework proverá as datas, não o cliente e nem o banco)


##### Anotações de entendimento:
###### Transformar o DTO de entrada (PlaceRequest) num Place (domínio) **faz parte da regra de negócio**. 
###### Enquanto que, montar a resposta é responsabilidade do controlador, não é responsabilidade do service (like use cases) pois não é regra de negócio, é uma responsabilidade da interface da api, a camada web O DTO não deve retornar o id
###### Ao utilizar as anotações de geração de datas de auditoria  @CreatedDate e @LastModifiedDate, anotar a classe de configuração do Bean do dominio em questão com @EnableR2dbcAuditing
###### Desta forma o framework proverá as datas, não o cliente e nem o banco