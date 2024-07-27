# USLP10 – Como Product Owner, pretendo que seja melhorada a funcionalidade que consiste em simular um controlador do sistema de rega previamente desenvolvida na USLP02. A melhoria consiste modelar aspectos relacionados com a fertirrega.
## 1. Engenharia de Requisitos

### 1.1. Descrição da User Story

Como Product Owner, pretendo que seja melhorada a funcionalidade que consiste em simular um controlador do sistema de rega previamente desenvolvida na USLP02. A melhoria consiste modelar aspectos relacionados com a fertirrega.

### 1.2. Especificações e Esclarecimentos do Cliente

**Do documento de especificações:**

>Para tal deve ser consumido um ficheiro de texto com um conjunto de instruções e gerado um plano de rega para 30 dias.

>O ficheiro de texto deverá ter a seguinte informação e formato:
><Horas de rega>
Nesta linha são definidos as horas que se inicia um ciclo de rega, por exemplo: 8:30 e 17:00, significa que existem dois ciclos de rega diários que se iniciam respectivamente `as 8:30 e 17:00.
<Setor, Duração, Regularidade, [Min, Recorrência]>

>Existe uma linha para cada sector a regar. Sector (uma ou mais parcelas) identifica a zona a ser regada (controlado por uma eletroválvula);
Duração, o tempo 29 em minutos que o sector deve receber rega; e a Regularidade, a fórmula de recorrência que define os dias que o sector deve ser regado T, todos; I, ´ımpares, P, pares, 3, a cada 3 dias. Opcionalmente a linha pode contar informação sobre a fertirrega a realizar, definida por um mix (composição de factores de produção, e a fórmula de recorrência da sua aplicação, por exemplo 7, significa que será aplicada nos ordinais 1, 8, 15, . . . (primeiro, oitavo e dÉcimo quinto) do plano de fertirrega.

>Exemplo:
8:30, 17:00
A,14,T,mix1,5
B,8,T, C,25,P,mix2,7
D,25,I E,7,T,mix1,3
F,10,3
Note-se que por questões capacidade, os sectores são regados de forma sequencial. A necessidade de regar em dias pares ou ´ımpares resulta da necessidade de balancear as necessidades de rega de todos sectores em função da capacidade máxima do sistema.

>O controlador de rega, contem um plano de rega para 30 dias a partir da data de criação e em qualquer momento (data/hora) sabe responder se está a regar ou não, e em caso afirmativo qual o sector que está a regar e quantos minutos faltam para terminar.

**Dos esclarecimentos do cliente:**

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

