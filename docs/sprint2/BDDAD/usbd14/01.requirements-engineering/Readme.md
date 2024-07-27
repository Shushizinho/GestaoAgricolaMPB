# USBD14 Como Gestor Agrícola, quero registar uma operação de aplicação de fator de produção
## 1. Engenharia de Requisitos

### 1.1. Descrição da User Story

Como Gestor Agrícola, quero registar uma operação de aplicação de fator de produção

### 1.2. Especificações e Esclarecimentos do Cliente

**Do documento de especificações:**

**Dos esclarecimentos do cliente:**

> **Pergunta:** O gestor agrícola pretende registar uma operação de aplicação de fator de produção.
A minha questão é precisamente quanto a esta "operação", já que uma aplicação de fator de produção é, naturalmente, uma fertilização.
No entanto, a própria rega, a aplicação de um fitofármaco e a monda podem ter um fator de produção associadas, o que suscita algumas dúvidas.
Dito isto, pergunto-lhe se o objetivo final da US é registar todas as operações de aplicação de fator de produção "literais", ou seja, apenas as fertilizações. Ou também todas as outras operações que tenham um fator de produção associadas.
>
> **Resposta:** Anda um bocado enganado. Um fator de produção pode ser um fertilizante, um fito-fármaco, um corretor de solo, etc. No meu entender, a monda é uma operação manual ou mecânica de limpeza, que não gasta fatores de produção. Mas confirmem junto do cliente.
Para não complicar, nenhuma das operações de rega dadas é de fertirrega. Se isso acontecesse, eu recomendava que na BD fosse decomposta numa operação de rega e uma outra de aplicação de fator de produção.
Mais complicado ainda, a fertirrega podia incluir vários fatores de produção. Nesse caso, a uma aplicação de fator de produção teria de ter associada uma lista de fatores de produção aplicados.
Será que vale a pena complicar neste momento e satisfazer o cenário acima? Numa abordagem ágil tenta-se fazer o menos possível que cumpra os requisitos. A menos que o cliente dê indicações nesse sentido, neste sprint não aparecem requisitos que obriguem a complicar.
Mas ainda vai haver um sprint 3 cheio de coisas boas.

> **Pergunta:**
Com base nos dados suplementares recebidos ontem, que operação devemos assumir quando é aplicado um fator de produção.
Por exemplo, temos a seguinte linha:
06/01/2020 operação de aplicação de fator de produção Fertimax Extrume de Cavalo, no solo, Macieira Porta da Loja, 100 kg
Assumimos que seja que operação? Uma fertilização?
>
> **Resposta:** A aplicação de um fator de produção é uma aplicação de fator de produção. Parece-me ser esse o entendimento do cliente e a USBD14 pede isso mesmo.
A mim parece-me que o sistema em desenvolvimento inclui num mesmo tipo de operação, a "aplicação de fator de produção", a aplicação de fatores de produção de diferentes tipos.

> **Pergunta:**
>
> **Resposta:**

### 1.3. Acceptance Criteria


### 1.4. Found out Dependencies


### 1.7 Other Relevant Remarks

