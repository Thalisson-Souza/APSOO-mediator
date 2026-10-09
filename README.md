# Etapa 2 - Melhorias na implementação

Melhorias feitas saindo da revisão crítica: [implementação inicial](https://github.com/Thalisson-Souza/APSOO-mediator/tree/v2-p1) e [commit](https://github.com/Thalisson-Souza/APSOO-mediator/commit/ad57d0d)

## Alterações feitas

| Alteração | Justificativa |
| --------- | ------------- |
| Criei a classe abstrata `Comprador`, que estende o `Participante` e tem o `nome()`, a `moeda()` e o `ofertar`. O Mediator troca o `registrarCompradorBrasil` e o `registrarCompradorFranca` por um `registrarComprador` só e guarda os compradores num `Map` pela moeda | O Mediator continua com referência pra todos os compradores mas não precisa mais saber a classe de cada um. Comprador novo não muda a interface nem o ConcreteMediator. O `proporOferta` agora usa esses registros e recusa moeda que nenhum comprador registrado usa |
| O `ConversorDolar` guarda as taxas num `Map` e tem o `adicionarTaxa`. Moeda que ele não conhece lança `IllegalArgumentException` | Antes a moeda desconhecida virava 0 e a oferta só aparecia como recusada. Agora o erro fala que a moeda não é suportada. Moeda nova é só cadastrar a taxa e o conversor fica igual |
| O `proporOferta` valida se o vendedor e o conversor estão registrados e se a oferta é maior que zero. O `VendedorEUA` não aceita preço zero ou negativo. O `Aplicativo` trata valor inválido e lista os compradores direto do Mediator | Antes faltando um registro dava `NullPointerException` e texto no valor derrubava o programa. Quem cuida disso é o Mediator porque é ele que conhece os participantes, o comprador continua só mandando a oferta |

## Próxima etapa

[v3 — extensão](https://github.com/Thalisson-Souza/APSOO-mediator/tree/v3)
