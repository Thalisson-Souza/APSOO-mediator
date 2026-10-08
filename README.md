# Etapa 2 - Implementação e revisão crítica

## Prompt utilizado

```text
to fazendo uma atividade do padrão Mediator. o cenário é um sistema de negociação entre países, tem um comprador do brasil que oferta em real, um da frança que oferta em euro, um vendedor dos eua que coloca o preço em dólar e um conversor que passa tudo pra dólar. eles não podem se conhecer direto, tudo tem que passar pelo Mediator. o Mediator guarda os dois compradores, o vendedor e o conversor e tem os métodos pra registrar eles. o proporOferta recebe a quantia e a moeda, pede pro conversor passar pra dólar, manda pro vendedor e devolve se ele aceitou ou não

meu diagrama ta assim: interface Mediator com os registrar e o proporOferta, MediatorNegociacao implementando ela (ConcreteMediator), classe abstrata Participante que guarda o Mediator (Colleague) e CompradorBrasil, CompradorFranca e VendedorEUA estendendo ela (ConcreteColleague). o ConversorDolar só o Mediator usa e o Aplicativo cria tudo e registra no Mediator

Implemente seguindo o diagrama. faz um Aplicativo que deixe escolher o comprador e digitar o valor da oferta. java 11 com maven sem dependência externa
```

## O que foi feito na `v2-p1`

Commit da implementação inicial: [ver commit](https://github.com/Thalisson-Souza/APSOO-mediator/commit/15d258d)

Implementação do Mediator com base no diagrama da v1.
`Mediator` é o Mediator, `MediatorNegociacao` é o ConcreteMediator, `Participante`
é o Colleague e `CompradorBrasil`, `CompradorFranca` e `VendedorEUA` são os
ConcreteColleagues. O `ConversorDolar` só é usado pelo Mediator e o `Aplicativo`
cria e registra todo mundo.

## Revisão crítica

### O que está correto

- Os compradores só conhecem o `Mediator` e chamam o `proporOferta` com a sua moeda, igual ao diagrama. Nenhum deles sabe que o vendedor ou o conversor existem
- O `VendedorEUA` só compara o valor em dólar com o preço e não sabe de onde veio a oferta
- O `proporOferta` faz o caminho que a atividade pede, converte pelo `ConversorDolar`, manda pro vendedor e devolve a resposta pra quem ofertou
- O `ConversorDolar` não é Colleague e só o Mediator usa ele, como está no diagrama

### O que está incompleto ou inadequado

- O Mediator tem um campo e um método de registro pra cada comprador (`registrarCompradorBrasil`, `registrarCompradorFranca`). Um comprador novo obriga a mexer na interface e no ConcreteMediator. E esses compradores registrados nem são usados no `proporOferta`, então dá pra ofertar numa moeda que nenhum comprador registrado usa
- O `ConversorDolar` tem as taxas presas num `if` por moeda e devolve 0 quando não conhece a moeda. A oferta vira só "recusada" sem avisar que a moeda não existe, e moeda nova obriga a mexer no conversor
- Não tem validação. Sem vendedor ou conversor registrado o `proporOferta` estoura `NullPointerException`, oferta zero ou negativa passa normal e no `Aplicativo` qualquer texto que não é número no valor derruba o programa

## Melhorias na v2-p2

Registro dos compradores pela moeda num `registrarComprador` só, conversor com taxas cadastradas e erro pra moeda desconhecida e validação no Mediator e no `Aplicativo`.

[v2-p2 — implementação melhorada](https://github.com/Thalisson-Souza/APSOO-mediator/tree/v2-p2)
