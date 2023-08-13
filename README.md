# place-service
### Projeto Spring-Boot que disponibiliza uma API de lugares

Seguindo a solução proposta no canal de [Giuliana Bezerra](https://www.youtube.com/@giulianabezerra) no Youtube sobre o seguinte 
[desafio](https://github.com/RocketBus/quero-ser-clickbus/tree/master/testes/backend-developer). para que seja 
desenvolvida uma API de lugares. Foi utilizada uma abordagem alternativa para aplicações reativas, por consequência, 
nossa camada de persistencia deve acompanhar a mesma abordagem reativa.

Configuração / Como rodar:
###### Projeto Spring-Boot. Clone o projeto, importe em sua IDE de preferência e execute

Dependências:

* ###### H2
* ###### R2DBC (para interações com o banco de dados de forma reativa)
* ###### Webflux (alternativa reativa que escala bem em soluções web com Java e Spring)
* ###### Lombok

Banco de dados:

* ###### Em memória (H2)