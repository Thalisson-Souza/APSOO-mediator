# Etapa 4 — Análise de uma solução alternativa

## Solução analisada

Outro desenvolvedor fez a comunicação direta entre os objetos. Cada comprador
guarda o vendedor e o conversor, e o vendedor pode guardar os compradores pra
avisar o resultado:

```text
Comprador
  |
  +----> ConversorDolar
  |
  +----> VendedorEUA
```

## Análise

**1. Qual é o principal problema dessa abordagem à medida que novos participantes são adicionados ao sistema?**

Cada participante novo tem que ser ligado em vários outros, um comprador novo precisa conhecer o vendedor e o conversor e o vendedor tem que passar a conhecer ele também, então as ligações crescem bem mais rápido que as classes

**2. Quais classes passam a conhecer diretamente umas às outras?**

O `CompradorBrasil` e o `CompradorFranca` conhecem o `VendedorEUA` e o `ConversorDolar`, e o `VendedorEUA` conhece os dois compradores, então comprador e vendedor ficam dependendo um do outro

**3. Como o aumento da quantidade de participantes pode afetar o acoplamento do sistema?**

O acoplamento vai crescendo junto, com mais comprador o vendedor guarda mais referência e qualquer mudança no vendedor ou no conversor obriga a olhar todos os compradores. Aí fica difícil mudar ou testar uma classe sozinha

**4. Como o padrão Mediator distribui essa responsabilidade?**

As ligações saem dos participantes e vão tudo pro Mediator, cada um só conhece ele e ele é o único que conhece todo mundo. A conversão continua no `ConversorDolar` e quem decide se aceita é o `VendedorEUA`, o Mediator só junta as partes

**5. Qual é o papel do Mediator na comunicação entre os participantes?**

Ele recebe a oferta do comprador, pede pro conversor passar pra dólar, manda pro vendedor e devolve a resposta pra quem ofertou, então ninguém fala com ninguém direto

**6. No contexto desse sistema, o que significa dizer que o Mediator centraliza a comunicação?**

Quer dizer que toda oferta passa pelo `proporOferta`, o comprador não sabe quem converte nem quem decide e o vendedor não sabe de onde veio a oferta. Se precisar mudar o fluxo da negociação é só mexer no Mediator

**7. Quais seriam as consequências de colocar toda a lógica de negociação diretamente dentro da classe Aplicativo?**

O `Aplicativo` ia cuidar da tela, de criar os objetos e da negociação tudo junto, o que vai contra a Responsabilidade Única, e a lógica ia ficar presa no menu sem dar pra reaproveitar como o `AplicativoEtapa3` faz hoje usando o mesmo Mediator

**8. Qual é a diferença entre centralizar a comunicação no Mediator e simplesmente criar uma classe que chama os métodos dos demais objetos?**

Uma classe que só chama os métodos controla tudo de fora e os objetos nem sabem que ela existe. No Mediator os participantes têm referência pra ele e mandam as mensagens por ele, tipo o comprador chamando o `proporOferta`, e como eles dependem da interface `Mediator` dá pra trocar o ConcreteMediator sem mexer neles

**9. O uso do Mediator elimina completamente as dependências entre os objetos? Explique.**

Não, os participantes ainda dependem do `Mediator` e o `MediatorNegociacao` depende de todos eles. O que muda é que deixa de ser todo mundo com todo mundo e passa a ser cada um só com o Mediator

**10. Em que situações o uso do padrão Mediator pode tornar o sistema mais organizado e em quais situações pode tornar o Mediator excessivamente complexo?**

Ajuda quando tem vários objetos que precisam conversar e as regras de quem fala com quem mudam, igual aqui com compradores de várias moedas. Fica complexo quando todas as regras do sistema vão parar no Mediator e ele vira uma classe que faz tudo, e também não compensa quando são só dois objetos conversando de um jeito simples
