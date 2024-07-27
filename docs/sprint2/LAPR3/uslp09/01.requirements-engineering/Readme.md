# USLP09 Como Product Owner, pretendo que seja atualizado o modelo de domínio (nível conceptual).
## 1. Engenharia de Requisitos

### 1.1. Descrição da User Story

Como Product Owner, pretendo que seja atualizado o modelo de domínio (nível conceptual).

### 1.2. Especificações e Esclarecimentos do Cliente

**Do documento de especificações:**


**Dos esclarecimentos do cliente:**

> **Pergunta:** Todos os respetivos sensores(temperatura, humidade, etc) devem estar ligados a uma entidade que guarda os dados recolhidos ou os sensores devem estar ligados individualmente á estação metereológica?
>
> **Resposta:** No essencial uma estação meteorológica agrícola (EMA) é constituída por um conjunto de sensores que medem diferentes grandezas meteológicas com interesse para a acitividade agrícola, como por exemplo, humidade atmosférica, direcção e velocidade do vento, pressão atmosférica; normalmente existe um controlador que concentra as leituras dos diferentes sensores mas pode depender do fabricante.
Os sensores do solo podem ler desde humidade e muitas outras (por exemplo pH) depende da sofisticação, e podem não estar integrados na EMA.

> **Pergunta:** Pode a mesma ficha técnica estar presente em múltiplos factores de produção?
>
> **Resposta:** Não; um factor de produção tem um nome comercial e uma ficha técnica. Se ajudar, considere o paralelo com um medicamento, diferente medicamentos (produtos comerciais) podem ter a mesma composição (por exemplo paracetamol) mas cada produto tem a sua bula.

> **Pergunta:** O que se entende por operações realizadas sobre uma parcela? Essas operações incluem sempre o uso de fatores de produção?
>
> **Resposta:** Uma operação realizada numa parcela é uma acção cultural (sobre uma cultura), pode ser semeadura ou plantação, poda, monda, desfolha, aplicação de um factor de produção, corte de infestantes, rega, colheita, pastoreio (entre outros). No fundo todas as actividades que visam fornecer as melhores condições às plantas e solo para uma produção plena. Nem todas as acções implicam factores de produção, como por exemplo poda ou colheita.

> **Pergunta:** Os armazéns são sempre especializados ou podem existir armazéns que guardam mais do que um tipo de inventário (ex.: armazém de ração e fator de produção)?
>
> **Resposta:** Isso depende do histórico de cada instalação agrícola, quando se tratam de quintas instaladas há muito tempo, é comum os edifícios existentes assumirem múltiplas valências que podem mudar ao longo do tempo em função da própria evolução da instalação. No caso de instalações novas, os armazéns podem ser criados de outra forma. Em resumo, os edíficios podem assumir múltiplas funções.

> **Pergunta:** Quais operações devem estar registadas no caderno de campo? fertilização, colheita e regas é preciso mais alguma ?
>
> **Resposta:** O caderno de campo é o registo de todas as actividades relevantes realizadas nas parcelas, isso inclui todas as actividades culturais (listadas noutra questão do forum, desde as semeadura, plantação até colheita, passando por aplicação de factores de produção, regas, podas, etc), incluindo informação sobre os produtos e quantidades utilizados bem como (qtd de) operadores e tempos.

> **Pergunta:** Em relação a determinadas operações agricolas como por exemplo: a sementeira e a plantação, no enunciado não se encontra informações para que se considere essas operações.
>
> **Resposta:** O enunciado é uma das peças relevantes para a análise e design da solução a desenvolver, não é um contrato formal entre cliente e fornecedor. A equipa de desenvolvimento deve utilizar todos os mecanismos ao seu dispor para desenvolver uma solução que satisfaz os requisitos dos cliente. No processo de recolha e especificação de requisitos são igualmente relevantes, os foruns e as sessões semanais de contacto com o cliente.
Para além disso, no enunciado é dito explicitamente: "O Caderno de Campo é um documento formal (obrigatório) que permite registar todas as operações agrícolas relevantes ocorridas na exploração". Se não houver semeadura ou plantação não haverá colheita.

> **Pergunta:** Uma estação meteorológica pode estar responsável por várias parcelas? E uma parcela pode ter várias estações meteorológicas?
>
> **Resposta:** Uma estção meteorológica pode ser um equipamento bastante caro e tipicamente servirá toda a exploração, até porque as grandezas meteorológicas não variam significativamente em áreas pequenas. Os sensores de solo podem existir vários por parcela, depende da dimensão da parcela e da precisão desejada dos valores medidos.


> **Pergunta:** Uma determinada parcela pode apresentar vários planos de rega, ou apenas um?
>
> **Resposta:** Um plano de rega diz respeito a múltiplas parcelas mas um parcela tem apenas um plano. Não confundir plano de rega com ciclos de rega.


> **Pergunta:** No ficheiro legacy entende-se que uma cultura é sempre uma variedade, no entanto nas operaçoes existem 3 em que a cultura apenas é macieira, isto está correto ou podemos assumir que uma cultura é de uma variedade ?
>
> **Resposta:** Uma variedade é uma especialização de uma cultura. Assim, e de acordo com a herança de classe (conceptuais) todas as variedades de macieiras são macieiras.


> **Pergunta:** Qual o limite de culturas que podem ser geridas por um gestor agricola e se é possivel vários gestores gerirem a mesma cultura.
>
> **Resposta:** salvo melhor opinião, tendo em conta as USs atuais, um Gestor Agrícola não será exactamente um elemento do domínio mas um papel ou uma competência que um ou mais utilizadores possuirão. Numa perspectiva aplicacional esse papel permititá realizar todas as tarefas associadas à gestão das actividades agrícolas (como o nome sugere ;-)).


> **Pergunta:** A nova atualização do documento do projeto dá a entender que cultura e planta são a mesma coisa (no ponto de estado fenológico, secção 2.2). Gostaria de saber se isto é verdade e se caso contrário qual a relação entre as duas, obrigado.
>
> **Resposta:** A cultura da vinha tem plantas que são as videiras, por isso, o ciclo fenológico da videira determina o ciclo da vinha.


> **Pergunta:** Numa operação realizada sobre uma cultura o produto resultante (quando aplicável) depende do tipo de operação?
Exemplo: Numa operação de colheita sobre uma macieira o produto é sempre a maça? E numa operação de Poda o produto são os ramos?
>
> **Resposta:** supondo que produto signifique "Produto Agrícola", o objetivo da produção agrícola (e.g., fruta, flores, fibras, cereais, ...) a colheita terá produtos associados mas a poda não.
Uma determinada atividade agrícola não se molda ao modelo de dados, mas o reverso, de facto, este deve ser o espírito em qualquer domínio de conhecimento que pretendam modelar/capturar.

> **Pergunta:** Quando é registada uma operação de semeadura devem também ser registadas informações relativamente à colheita prevista?
>
> **Resposta:** Creio que não. Porque tipicamente os valores previstos (teóricos) estão associados a uma cultura e valores padrão (ha, árvore, etc). A semeadura será realizada numa parcela/cultura.
De qualquer forma após alguns ciclos produtivos é mais provável obter previsões mais precisas com base nas produções anteriores da quinta do que nos valores indicados na literatura (que estão sempre dependentes da região, solos, clima, práticas culturais).


> **Pergunta:** Uma única operação de rega pode cobrir vários sectores?
>
> **Resposta:** Não


> **Pergunta:** Um único sensor de qualquer tipo pode ler vários valores ao mesmo tempo?
>
> **Resposta:** Não


> **Pergunta:** Precisamos de saber mais sobre o operador. Qual a sua relevância para o sistema, e que informações precisamos saber desse conceito? Como se relaciona com operação? É necessário gravar horas da atividade deste?
E para os casos onde o operador usa uma máquina, essas horas serão contabilizadas como horas mão de obra ou horas mecânicas?
>
> **Resposta:** Para já não existem US que envolvam o operador


> **Pergunta:** Suponhamos que numa dada parcela foi feita a plantação de X unidades duma variedade permanente (20 macieiras gala, por exemplo), e mais tarde é feita uma nova plantação dessa mesma variedade nessa mesma parcela (mais 30 macieiras gala); quando, no futuro, se pretender realizar uma poda sobre as macieiras gala dessa parcela, a operação será sobre todas as macieiras gala(mais antigas e mais recentes), ou devemos considerá-las como duas plantações diferentes distinguidas pela idade?
>
> **Resposta:** Em bom rigor muitas das operações poderiam ser diferentes, mas no contexto deste trabalho (académico) é perfeitamente razoável assumir que serão tratadas como apenas uma cultura.


> **Pergunta:** Dentre as seguintes operações agrícolas: poda, tutoramento e desfolha, alguma delas é específica de culturas permanentes ou temporárias?
> 
> **Resposta:** O cliente não conhece todas as culturas para responder taxativamente a essa questão.
Embora algumas das operações sejam mais comuns num tipo ou outro, creio que será mais prudente assumir que as operações são válidas para ambos os tipos.


> **Pergunta:** Acredito que se pode ter plantações diferentes da mesma cultura temporária em estados fenológicos diferentes, mas queria esclarecer se isso é possível para plantações da mesma cultura permanente.
>
> **Resposta:** Sim, culturas temporárias da mesma cultura podem ter estados fenológicos (foram semeados/plantados em datas distintas para por exemplo prologaram o periodo de disponibilidade no mercado, comemos alface durante todo o ano) mas isso já é mais incomum nas culturas permanentes (embora possa ser feito com recurso a tratamentos químicos/hormonais, não permitidos em AB).


> **Pergunta:** Existem mondas que são feitas à base de substâncias químicas o que, no fundo, é uma operação de aplicação de fatores de produção. Isso é aplicável ao domínio deste negócio, sendo que estamos a falar de agricultura em modo biológico, ou foi apenas uma observação de cultura geral?
>
> **Resposta:** Na agricultura a monda pode ser utilizada com fins diversos e ser realizada de formas distintas.
- Monda de fruto, retirar da árvore parte da fruta numa fase muito precoce para obter fruta com melhor calibre e manter a árvore mais equilibrada (evita produções aneiras, alternadas ao longo dos anos)
- Monda vegetal, por exemplo arrancar o excesso de plantas de milho ou cenoura que estão a competir entre si
- Monda de ervas daninhas, consiste em arrancar ou limitar a evolução de espécies vegetais que concorrem com a cultura principal, prefiro a designação, controlo de infestantes.
> No que diz respeito à utilização de químicos na AB, existe um mal-entendido generalizado sobre o tema, na AB não é permitida a utilização de químicos de síntese. Os quimicos, esses são utilizados constantemente, o monóxido de di-hidrogênio é o produto mais utilizado em regas.


> **Pergunta:** Podem haver espécies diferentes com a mesma variedade?
>
> **Resposta:** Tecnicamente sim, mas isso não tem nenhuma relevancia para o negócio; por exemplo, se tivessemos uma abóbora Estrela e uma maça Estrela, não referimos apenas a variedade, mas a junção de cultura/variedade.


> **Pergunta:** No caso de uma parcela ter dimensões bastante grandes e existir a necessidade de ser servida por vários setores, as suas culturas devem ser divididas pelos mesmos, isto é, uma cultura só pode pertencer a um setor ou uma cultura pode pertencer a vários setores?
>
> **Resposta:** uma cultura numa parcela será servida apenas por um sector de rega.


> **Pergunta:**
>
> **Resposta:**


> **Pergunta:**
>
> **Resposta:**


> **Pergunta:**
>
> **Resposta:**



### 1.3. Acceptance Criteria


### 1.4. Found out Dependencies


### 1.7 Other Relevant Remarks

