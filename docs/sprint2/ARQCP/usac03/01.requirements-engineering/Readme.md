# USAC03 Desenvolva uma função em assembly que remova n valores (int num) de um array (buffer circular) e os copie para outro array (int * vec)
## 1. Engenharia de Requisitos

### 1.1. Descrição da User Story

Desenvolva uma função em assembly que remova n valores (int num) de um array (buffer circular) e os copie para outro array (int * vec)

## 1.2. Especificações e Esclarecimentos do Cliente

**Do documento de especificações:**
>int copy_num_vec(int* array, int read, int write, int num, int* vec);

>No caso de não existirem os n elementos no array, a função não deve copiar os elementos e retornar 0, caso contrário deve retornar 1.

**Dos esclarecimentos do cliente:**

> **Pergunta:** É pedido para copiar N valores de um array para o outro, no entanto como se trata de um Buffer circular e pode haver situações em que o write encontra-se numa posição anterior à do read, como é que podemos garantir um acesso ao início do array, sendo que não passamos a lenght por parâmetro.
>
> **Resposta:** Obrigado pela observação. Isso vai ser corrigido. O texto passará a ser o seguinte: USAC03 Desenvolva uma função em assembly que remova n valores (int num) de
um array (buffer circular) e os copie para outro array (int * vec). int copy_num_vec(int* array, int length, int *read, int *write, int num, int* vec);

> **Pergunta:**
>
> **Resposta:**

### 1.3. Acceptance Criteria


### 1.4. Found out Dependencies


### 1.7 Other Relevant Remarks

