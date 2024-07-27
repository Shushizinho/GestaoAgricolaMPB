# USEI06 – Encontrar para um produtor os diferentes percursos que consegue fazer entre um local de origem e um hub limitados pelos Kms de autonomia do seu veículo elétrico, ou seja, não considerando carregamentos no percurso.
## 1. Engenharia de Requisitos

### 1.1. Descrição da User Story

Encontrar para um produtor os diferentes percursos que consegue fazer entre um local de origem e um hub limitados pelos Kms de autonomia do seu veículo elétrico, ou seja, não considerando carregamentos no percurso.

### 1.2. Especificações e Esclarecimentos do Cliente

**Do documento de especificações:**

>Critério de Aceitação: Devolver para cada percurso o local de origem, os locais de passagem (sendo um hub, identificá-lo), distancia entre todos os locais do percurso, distancia total e tempo total de percurso.

**Dos esclarecimentos do cliente:**

> **Pergunta:**
>Na USEI06, é pedido para encontrar os diferentes percursos que consegue fazer entre um local de origem e um hub limitados pelos Kms de autonomia do seu veículo elétrico.
Gostaria se com os diferentes percursos a professora se referre a todos os percursos possíveis entre o local de origem e um hub.
> **Resposta:**
>Sim, são todos os percursos diferentes, limitados pela autonomia do veículo

> **Pergunta:**
>Para as localizações dos hubs na rede de distribuição, utilizamos os vértices que foram seleccionados na USEI02?
> **Resposta:**
>Na USEI06 só precisa de um local de origem e um hub que recebe por parâmetro.

> **Pergunta:**
>NA USEI06, para o tempo total de cada percurso, devemos ter em conta o tempo de descarga nos hubs por onde o veículo passa?
> **Resposta:**
>Nesta US não é necessário considerar os tempos de descarga.

> **Pergunta:**
>Gostava de esclarecer alguns aspetos relacionados com a USEI06. Segundo esta, devemos "Encontrar para um produtor os diferentes percursos que consegue fazer entre um local de origem e um hub limitados pelos Kms de autonomia do seu veículo elétrico, ou seja, não considerando carregamentos no percurso...." . No entanto, não temos nenhuma informação relativamente aos produtores, assim como dados referidos (local de origem, hub, autonomia do veículos).
>Estes dados serão introduzidos pelo user durante a execução da funcionalidade?
>Posteriormente, é pedido que retornemos o tempo total de percurso, contudo não há nenhuma informação relativamente a este aspeto, deverá ser introduzida algum valor pelo user sobre isto, por exemplo velocidade?

> **Resposta:**
>Nesta US não precisa de informação acerca do produtor, só precisa de receber por parâmetro: local origem, hub destino, kms de autonomia e velocidade do veículo. O tempo total do percurso terá de ser calculado.
>No enunciado está:
" Para maior simplicidade assuma que as viaturas têm uma autonomia máxima de A km, deslocando-se a uma velocidade média de V km/h, os carregamentos dos veículos só podem ser feitos nas localidades, ... "


### 1.3. Acceptance Criteria


### 1.4. Found out Dependencies


### 1.7 Other Relevant Remarks

