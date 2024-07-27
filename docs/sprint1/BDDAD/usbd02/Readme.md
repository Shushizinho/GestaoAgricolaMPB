# USBD 02 - Modelo relacional (nível lógico) 

## 1. Engenharia de Requisitos

### 1.1. Descrição da User Story

Como Product Owner, pretendo que seja elaborado o modelo relacional (nível lógico).

### 1.2. Especificações e Esclarecimentos do Cliente 

**Do documento de especificações:**

> - Esperado: modelo "básico" partilhado no Visual Paradigm ou docs no git (e.g.,
PlantUML).                               
> - Acima do esperado: modelo completo no Visual Paradigm, que inclua todas as restrições e que
permita a geração automática de script de modelo físico.

**Dos esclarecimentos do cliente:**

> **Pergunta:** Sabemos que uma parcela pode ter várias culturas, mas uma cultura pode estar em várias parcelas?
>
> **Resposta:** Sim, de facto, uma parcela pode ter várias culturas, por exemplo, é possível ter milho, feijão e abóboras porque criam "sinergias", chamadas consorciações (os feijões fixam o azoto no solo, o azoto é fundamental para o milho, as canas do milho protegem as abóboras do sol, e também servem como estacas para o feijão, além disso, as raizes das aboboreiras são muito fortes e profundas, e como tal arejam o solo). Este é um clássico, mas existem muitos exemplos destes, seja para repelir pragas ou para evitar o aparecimento de infestantes. Sim, uma cultura pode estar em múltiplas parcelas, depende das necessidades de produção. Ou por exemplo, caso se pretenda fazer adubação verde (para aumentar a fertilidade do solo) ou forrageiras para pasto para animais, nesses casos é muito comum existirem diferentes parcelas com as mesmas culturas.


> **Pergunta:** Qual o limite de culturas que podem ser geridas por um gestor agricola e se é possivel vários gestores gerirem a mesma cultura.
>
> **Resposta:** salvo melhor opinião, tendo em conta as USs atuais, um Gestor Agrícola não será exatamente um elemento do domínio, mas um papel ou uma competência que um ou mais utilizadores possuirão. Numa perspetiva aplicacional esse papel permititá realizar todas as tarefas associadas à gestão das atividades agrícolas (como o nome sugere).



### 1.3. Acceptance Criteria


* **AC1:** O modelo de dados deve cobrir a atividade da instalação agrícola, ficando excluída a
  comercialização e distribuição de produtos e a gestão da rega. Apesar do sistema de rega fazer parte
  da instalação agrícola, não é necessária manter na base de dados a topologia detalhada. Pode-se
  considerar cada sistema de rega como uma "caixa preta", associando cada sistema às parcelas que
  rega.

### 1.4. Found out Dependencies




### 1.5 Input and Output Data


**Input Data:**

* Typed data:
	* a reference, 
	* a designation, 
	* an informal description
	* a technical description
	* an estimated duration
	* an estimated cost
	
* Selected data:
	* Classifying task category 


**Output Data:**

* List of existing task categories
* (In)Success of the operation

### 1.7 Other Relevant Remarks

