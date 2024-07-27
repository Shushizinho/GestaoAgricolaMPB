# USLP 01 -  Modelo de domínio (nível conceptual) 

## 1. Engenharia de Requisitos

### 1.1. Descrição da User Story

Como Product Owner, pretendo que seja elaborado o modelo de domínio (nível
conceptual). Este modelo será um elemento fundamental de comunicação entre todos os
interessados na solução a desenvolver. O diagrama do modelo de domínio é um documento “vivo” e
deverá refletir em cada momento o entendimento partilhado sobre o domínio pelos interessados.

### 1.2. Especificações e Esclarecimentos do Cliente

**Do documento de especificações:**

>	Este modelo será um elemento fundamental de comunicação entre todos os
interessados na solução a desenvolver. O diagrama do modelo de domínio é um documento “vivo” e
deverá refletir em cada momento o entendimento partilhado sobre o domínio pelos interessados.

> - Esperado: modelo "básico" partilhado no Visual Paradigm ou docs no git (e.g., PlantUML).

**Dos esclarecimentos do cliente:**

> **Pergunta:** Todos os respetivos sensores(temperatura, humidade, etc) devem estar ligados a uma entidade que guarda os dados recolhidos ou os sensores devem estar ligados individualmente á estação metereológica?
>  
> **Resposta:** no essencial uma estação meteorológica agrícola (EMA) é constituída por um conjunto de sensores que medem diferentes grandezas meteológicas com interesse para a acitividade agrícola, como por exemplo, humidade atmosférica, direcção e velocidade do vento, pressão atmosférica; normalmente existe um controlador que concentra as leituras dos diferentes sensores mas pode depender do fabricante.
Os sensores do solo podem ler desde humidade e muitas outras (por exemplo pH) depende da sofisticação, e podem não estar integrados na EMA.

> **Pergunta:** Pode a mesma ficha técnica estar presente em múltiplos factores de produção?
>  
> **Resposta:** não; um factor de produção tem um nome comercial e uma ficha técnica. Se ajudar, considere o paralelo com um medicamento, diferente medicamentos (produtos comerciais) podem ter a mesma composição (por exemplo paracetamol) mas cada produto tem a sua bula.

> **Pergunta:** O que se entende por operações realizadas sobre uma parcela? Essas operações incluem sempre o uso de fatores de produção?
>
> **Resposta:** uma operação realizada numa parcela é uma acção cultural (sobre uma cultura), pode ser semeadura ou plantação, poda, monda, desfolha, aplicação de um factor de produção, corte de infestantes, rega, colheita, pastoreio (entre outros). No fundo todas as actividades que visam fornecer as melhores condições às plantas e solo para uma produção plena. Nem todas as acções implicam factores de produção, como por exemplo poda ou colheita.

> **Pergunta:** Os armazéns são sempre especializados ou podem existir armazéns que guardam mais do que um tipo de inventário (ex.: armazém de ração e fator de produção)?
>
> **Resposta:** isso depende do histórico de cada instalação agrícola, quando se tratam de quintas instaladas há muito tempo, é comum os edifícios existentes assumirem múltiplas valências que podem mudar ao longo do tempo em função da própria evolução da instalação. No caso de instalações novas, os armazéns podem ser criados de outra forma. Em resumo, os edíficios podem assumir múltiplas funções.

> **Pergunta:** Quais operações devem estar registadas no caderno de campo? fertilização, colheita e regas é preciso mais alguma ?
>
> **Resposta:** o caderno de campo é o registo de todas as actividades relevantes realizadas nas parcelas, isso inclui todas as actividades culturais (listadas noutra questão do forum, desde as semeadura, plantação até colheita, passando por aplicação de factores de produção, regas, podas, etc), incluindo informação sobre os produtos e quantidades utilizados bem como (qtd de) operadores e tempos.

> **Pergunta:** Em relação a determinadas operações agricolas como por exemplo: a sementeira e a plantação, no enunciado não se encontra informações para que se considere essas operações.
>
> **Resposta:** o enunciado é uma das peças relevantes para a análise e design da solução a desenvolver, não é um contrato formal entre cliente e fornecedor. A equipa de desenvolvimento deve utilizar todos os mecanismos ao seu dispor para desenvolver uma solução que satisfaz os requisitos dos cliente. No processo de recolha e especificação de requisitos são igualmente relevantes, os foruns e as sessões semanais de contacto com o cliente.
Para além disso, no enunciado é dito explicitamente: "O Caderno de Campo é um documento formal (obrigatório) que permite registar todas as operações agrícolas relevantes ocorridas na exploração". Se não houver semeadura ou plantação não haverá colheita.

> **Pergunta:** Uma estação meteorológica pode estar responsável por várias parcelas? E uma parcela pode ter várias estações meteorológicas?
>
> **Resposta:** uma estção meteorológica pode ser um equipamento bastante caro e tipicamente servirá toda a exploração, até porque as grandezas meteorológicas não variam significativamente em áreas pequenas. Os sensores de solo podem existir vários por parcela, depende da dimensão da parcela e da precisão desejada dos valores medidos.

> **Pergunta:** Uma determinada parcela pode apresentar vários planos de rega, ou apenas um?
>
> **Resposta:** um plano de rega diz respeito a múltiplas parcelas mas um parcela tem apenas um plano. Não confundir plano de rega com ciclos de rega.

> **Pergunta:** no ficheiro legacy entende-se que uma cultura é sempre uma variedade, no entanto nas operaçoes existem 3 em que a cultura apenas é macieira, isto está correto ou podemos assumir que uma cultura é de uma variedade ?
>
> **Resposta:** uma variedade é uma especialização de uma cultura. Assim, e de acordo com a herança de classe (conceptuais) todas as variedades de macieiras são macieiras.

> **Pergunta:** Qual o limite de culturas que podem ser geridas por um gestor agricola e se é possivel vários gestores gerirem a mesma cultura.
>
> **Resposta:** salvo melhor opinião, tendo em conta as USs actuais, um Gestor Agrícola não será exactamente um elemento do domínio mas um papel ou uma competência que um ou mais utilizadores possuirão. Numa perspectiva aplicacional esse papel permititá realizar todas as tarefas associadas à gestão das actividades agrícolas (como o nome sugere ;-)).

### 1.3. Acceptance Criteria

* **AC1:** O modelo de dados deve cobrir a atividade da instalação agrícola, ficando excluída a
  comercialização e distribuição de produtos e a gestão da rega. Apesar do sistema de rega fazer parte
  da instalação agrícola, não é necessária manter na base de dados a topologia detalhada.

* **AC2:** modelo "básico" partilhado no Visual Paradigm ou docs no git (e.g., PlantUML)


### 1.4. Found out Dependencies


### 1.7 Other Relevant Remarks

