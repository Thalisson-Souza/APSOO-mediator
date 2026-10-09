# Etapa 3 — Extensão com o comprador do Japão

Commit da extensão: [ver commit](https://github.com/Thalisson-Souza/APSOO-mediator/commit/33f9679)

Criei o `CompradorJapao`, que oferta em iene (JPY), e o `AplicativoEtapa3`, que
monta a mesma negociação do `Aplicativo` com a taxa do iene no conversor e mais um
comprador registrado. Não mexi em nenhuma classe que já existia.

**1. Qual classe foi criada para representar o novo comprador?**

O `CompradorJapao`, ele estende o `Comprador` e só diz o nome e que a moeda é `JPY`

**2. Como o novo comprador foi registrado no Mediator?**

Com o `mediator.registrarComprador(new CompradorJapao(mediator))` no `AplicativoEtapa3`, que é o mesmo método dos outros compradores, e a taxa do iene entrou com `conversor.adicionarTaxa("JPY", 0.0067)`

**3. Quais alterações foram necessárias no Mediator para permitir a participação do novo comprador?**

Nenhuma, desde a v2-p2 o Mediator guarda os compradores pela moeda e aceita qualquer `Comprador`. Se fosse a v2-p1 ia ter que criar um `registrarCompradorJapao` na interface e no ConcreteMediator

**4. Foi necessário modificar as classes dos compradores existentes? Por quê?**

Não, cada comprador só conhece o `Mediator` e nem sabe que os outros existem então um comprador a mais não muda nada pra eles

**5. O que aconteceria se fosse necessário adicionar mais cinco compradores?**

Ia ser cinco classes iguais ao `CompradorJapao`, as taxas das moedas novas no conversor e os registros no aplicativo e o resto fica do jeito que ta

**6. Como o padrão Mediator ajuda a reduzir o acoplamento entre os participantes?**

Cada um só depende do `Mediator`, o comprador não conhece o vendedor nem o conversor e o vendedor não sabe quem fez a oferta, então mexer em um não afeta os outros

**7. Quais seriam as consequências de permitir que cada comprador se comunicasse diretamente com o vendedor e com o conversor?**

Todo comprador ia guardar o vendedor e o conversor e repetir a mesma lógica de converter e perguntar se aceita. Se mudasse o jeito de converter ou de avaliar a oferta ia ter que mexer em todos os compradores e quanto mais comprador pior fica

**8. O Mediator está apenas encaminhando mensagens ou também possui responsabilidades relacionadas à negociação? Justifique.**

Ele também tem responsabilidade na negociação porque é ele que decide a ordem, primeiro converte e depois manda pro vendedor, e ele que confere se a moeda é de um comprador registrado, se o vendedor e o conversor existem e se a oferta é maior que zero. Mas a regra de aceitar continua no `VendedorEUA` e a conversão no `ConversorDolar`

## Próxima etapa

[v4 — análise de uma solução alternativa](https://github.com/Thalisson-Souza/APSOO-mediator/tree/v4)
