# USEI09 – Organizar as localidades do grafo em N clusters que garantam apenas 1 hub por cluster de localidades.
## 1. Engenharia de Requisitos

### 1.1. Descrição da User Story

Organizar as localidades do grafo em N clusters que garantam apenas 1 hub por cluster de localidades.

### 1.2. Especificações e Esclarecimentos do Cliente

**Do documento de especificações:**

>Os clusters devem ser obtidos iterativamente através da remoção das ligações com o maior número de caminhos mais curtos entre localidades até ficarem clusters isolados. Não deverá fornecer soluções de clusters de localidades sem o respetivo hub.

>Critério de Aceitação: Devolver lista de Hubs e o respetivo conjunto de localidades que pertencem ao cluster desse Hub.

**Dos esclarecimentos do cliente:**

> **Pergunta:**
>Sabemos que é necessário remover as ligações com o maior número de caminhos mais curtos entre localidades, no entanto gostava de saber se existe algum número máximo de ligações ou de caminhos curtos de uma ligação?
> **Resposta:**
>Sim, deve haver uma ou mais ligações, com o maior número de caminhos mais curtos a passar por elas, mas terá de o determinar.

> **Pergunta:**
>
> **Resposta:**

### 1.3. Acceptance Criteria


### 1.4. Found out Dependencies


### 1.7 Other Relevant Remarks

