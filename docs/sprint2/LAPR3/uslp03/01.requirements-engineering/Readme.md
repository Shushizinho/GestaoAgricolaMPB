# USLP03 - Como Product Owner, pretendo que seja desenvolvida uma funcionalidade que permita de forma automática consuma o plano de rega gerado pelo simulador do controlador desenvolvido na USLP02 e que de forma escalonada após a conclusão da rega em cada sector registe essa operação no caderno de campo.
## 1. Engenharia de Requisitos

### 1.1. Descrição da User Story

Como Product Owner, pretendo que seja desenvolvida uma funcionalidade que permita de forma automática consuma o plano de rega gerado pelo simulador do controlador desenvolvido na USLP02 e que de forma escalonada após a conclusão da rega em cada sector registe essa operação no caderno de campo.

### 1.2. Especificações e Esclarecimentos do Cliente

**Do documento de especificações:**

Nota: No desenvolvimento desta US serão intencionalmente aspectos estudados em Sistemas Distribuídos (como por exemplo tolerância a falhas)

**Dos esclarecimentos do cliente:**

> **Pergunta:** No meu ponto de vista o que é solicitado da sua parte é o registo das operações de rega no caderno de campo conforme vão sendo realizadas. No entanto, não percebi como é que o cliente as quer visualizar. É suposto ir armazenando num ficheiro conforme vou inserindo na base de dados? É suposto solicitar à base de dados através de uma query e guardar num ficheiro?
>
> **Resposta:** Em termos de demo pode ser interessante escrever uma mensagem no ecrã, mas num contexto de utilização "real" poderiamos fazer um query à BD para obter essa informação (não é necessário).

> **Pergunta:** O meu grupo tem uma dúvida acerca da data de realização da rega. Esta apenas inclui o dia em que a rega foi realizada ou inclui também a hora de início e fim desta?
>
> **Resposta:** como podem ser várias regas num mesmo dia, deveriam indicar a hora em que regou e os minutos de rega.

> **Pergunta:** O nosso grupo tinha uma dúvida perante o registo de uma operação de rega no caderno de campo. O enunciado refere que deveríamos importar um ficheiro que tivesse sido gerado na USLP02 e enviássemos os seus dados para a base de dados externa. A nossa dúvida reside nas informações em específico. O ficheiro produzido a US anterior tem os seguintes parâmetros: "Dia, Setor, Hora Inicio, Hora Fim"; contudo o caderno de campo exige que se registe: "Data da operação, Quantidade, Parcela".
A nossa pergunta global é: temos de criar uma tabela nova para ter as informações relativas ao ficheiro gerado na USLP2 ou será que temos de adaptar essas informações para o caderno de campo? Se temos de adaptar, nós temos perguntas individuais para cada parâmetro:
A Quantidade o cliente já nos informou que seriam os minutos, o que é estranho porque esta é uma informação presente no plano de rega. Teremos de desfazer o que fizemos nessa mesma US, relativamente á conversão dos minutos em horas concretas (ex: 15min -> 8:10-8:25). E, isto quer dizer que a quantidade será sempre minutos ou haverá instâncias em que é valores de massa como kg ou até mesmo litros?
A Parcela, apesar de o cliente ter referido durante a reunião, não temos muita a certeza de como criar parcelas no momento. Entendemos que vamos ter de associar um setor a várias parcelas, contudo não entendemos se temos de fazer isso agora ou esperamos até termos essas informações.
Por último, a Data de Operação tínhamos duvida se iria conter horas ou só mesmo o dia, mas essa pergunta já foi feita, portanto, isso veremos depois.
>
> **Resposta:** de facto o enunciado não refere que deveriam importar um ficheiro:
"USLP03 - Como Product Owner, pretendo que seja desenvolvida uma funcionalidade que, de forma automática, consuma o plano de rega gerado pelo simulador do controlador desenvolvido na USLP02 e que de forma escalonada após a conclusão da rega em cada sector registe essa operação no caderno de campo."
Relativamente à necessidade de criar tabelas, como cliente não sei responder. Mas parece-me que o sistema de informação deve ser capaz de armazenar a informação relevante para gestão da instalação agrícola. Se diferentes operações agrícolas requerem informação diferente, talvez tenham de ser modeladas de forma diferente.
A solução está a ser desenvolvida em sprints exatamente para acomodar requisitos que vão evoluindo.
Por simplificação, a quantidade de rega deverá ser guardada em minutos, pois o cálculo das quantidades reais de água dispensadas exigiria um grande esforço de modelação e introdução de informação que extravaza o contexto deste trabalho.
Existe uma relação entre parcelas e sectores descrita no enunciado, a modelação deve acomodar esses aspectos. A única questão que ficou em aberto é se será fornecida informação sobre os sectores existentes na quinta mas isso não impede de forma alguma o desenvolvimento da solução.
As regas, em particular podem ser realizadas mais do que uma vez por dia, por essa razão parece-me relevante registar a hora a ques são realizadas.

> **Pergunta:** Bom dia, gostaria de saber se o input recebido pela USPL03 é o csv de output da USPL02, como por exemplo este:
Dia,Sector,Duração,Início,Final
2/11/2023,A,14,10:00,10:14
2/11/2023,B,8,10:14,10:22
2/11/2023,C,40,10:22,11:02
2/11/2023,E,7,11:02,11:09
2/11/2023,A,14,11:40,11:54
2/11/2023,B,8,11:54,12:02
2/11/2023,C,40,12:02,12:42
2/11/2023,E,7,12:42,12:49
2/11/2023,A,14,13:50,14:04
2/11/2023,B,8,14:04,14:12
2/11/2023,C,40,14:12,14:52
2/11/2023,E,7,14:52,14:59
2/11/2023,A,14,22:00,22:14
2/11/2023,B,8,22:14,22:22
2/11/2023,C,40,22:22,23:02
2/11/2023,E,7,23:02,23:09
>
> **Resposta:** de facto, na USLP3 é será utilizada a informação gerada na USLP2. No entanto, a decisão de consumir um ficheiro .csv, ou não, depende da forma como vai interligar as duas USs.


> **Pergunta:** Tendo em conta a seguinte informação acerca do Caderno de Campo:
"O Caderno de Campo é um documento formal  que permite registar todas as operações agrícolas relevantes ocorridas na exploração, em particular:
....
Regas executadas, quantidades, data da realização, parcela;"
Como é que, a partir do ficheiro gerado na US-LP02, sabemos a quantidade de água utilizada na rega?

>
> **Resposta:** As regas podem ser registadas em minutos e em função do tipo de rega instalado no sector/parcela e respectivo débito poderiamos calcular a quantidade de água. No entanto não entendo que o precisem de fazer, os minutos de rega são suficientes.


> **Pergunta:** Quando o enunciado se refere a "e que de forma escalonada após a conclusão da rega em cada sector registe essa operação"  ,  significa que a operação apenas tem que ser registada comparando a data e hora atual do computador com a do ficheiro que o plano de rega gerou?
>
> **Resposta:** Significa que quando termina a rega de uma sector (de acordo com o Plano de Rega criado no LP2) deve ser criada uma entrada no Caderno de Campo da instalação agrícola. A hora actual pode naturalmente ser fornecida pelo computador.


> **Pergunta:** Qual deve ser o formato do caderno de campo?
>
> **Resposta:** O formato do Caderno de Campo é definido pela equipa e deve estar modelado/capturado pelo modelo conceptual e pelo lógico, os dados deste caderno são guardados na Base de Dados.


> **Pergunta:** Devem ser criadas as entradas nos Cadernos de Campo das instalações agrícolas no momento que é gerado o plano de rega ou no momento de consulta será comparada a data e hora atual do computador com as do plano gerado e apenas criar a entrada se data e hora presentes no plano já tiverem passado?
>
> **Resposta:** Deve ser criada a entrada no Caderno de Campo assim que termina a rega num sector.


> **Pergunta:** Como é que relacionamos o setor A com a parcela correspondente (101,104, etc...) ?
>
> **Resposta:** na secção 2.3 Sistema de Rega é explicítada a relação entre sectores de rega e parcelas.
Um sector de rega pode irrigar múltiplas parcelas e uma parcela pode ser servida por diferentes sectores de rega.


> **Pergunta:** A data de realização da rega apenas inclui o dia em que a rega foi realizada ou inclui também a hora de início e fim desta?
>
> **Resposta:** como podem ser várias regas num mesmo dia, deveriam indicar a hora em que regou e os minutos de rega.

> **Pergunta:**
>
> **Resposta:**


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

