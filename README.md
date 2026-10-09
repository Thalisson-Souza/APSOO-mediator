# Mediator

## Cenário

Imagine que você está desenvolvendo um sistema de negociação de produtos entre
compradores e vendedores de diferentes países.

Tem um comprador brasileiro que oferta em reais, um comprador francês que oferta
em euros, um vendedor americano que define o preço em dólares e um conversor que
passa as moedas pra dólar.

Os participantes não se conhecem. Toda oferta passa pelo Mediator, que converte o
valor pra dólar, manda pro vendedor e devolve pro comprador se a oferta foi aceita
ou não.

## Estrutura

- `Mediator`: Mediator. Interface com os métodos de registrar e o `proporOferta`
- `MediatorNegociacao`: ConcreteMediator. Guarda os compradores, o vendedor e o conversor e faz a negociação
- `Participante`: Colleague. Guarda a referência pro Mediator
- `CompradorBrasil`, `CompradorFranca`, `CompradorJapao` e `VendedorEUA`: ConcreteColleagues
- `ConversorDolar`: converte as moedas pra dólar. Só o Mediator usa
- `Aplicativo`: cria os objetos, registra no Mediator e deixa fazer as ofertas

## Organização das entregas

As etapas foram organizadas nas seguintes branches:

- [v1 — diagrama UML](https://github.com/Thalisson-Souza/APSOO-mediator/tree/v1)
- [v2-p1 — implementação e revisão crítica](https://github.com/Thalisson-Souza/APSOO-mediator/tree/v2-p1)
- [v2-p2 — implementação melhorada](https://github.com/Thalisson-Souza/APSOO-mediator/tree/v2-p2)
- [v3 — extensão com o comprador do Japão](https://github.com/Thalisson-Souza/APSOO-mediator/tree/v3)
- [v4 — análise de uma solução alternativa](https://github.com/Thalisson-Souza/APSOO-mediator/tree/v4)
