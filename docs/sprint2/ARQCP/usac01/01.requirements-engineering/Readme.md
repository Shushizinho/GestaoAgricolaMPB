# USAC01 - Desenvolva uma função em assembly que dada uma string (input) com a informação gerada pelo ColetorDeDados e um token extraia a informação (campo value da string) referente a esse token (output).
## 1. Engenharia de Requisitos

### 1.1. Descrição da User Story

Desenvolva uma função em assembly que dada uma string (input) com a informação gerada pelo ColetorDeDados e um token extraia a informação (campo value da string) referente a esse token (output).

## 1.2. Especificações e Esclarecimentos do Cliente

**Do documento de especificações:**
> void extract_token(char* input, char* token, int* output);

> É preciso ter em atenção que o campo value da string é um número real. Este componente tem uma limitação que é só suporta números inteiros.

**Dos esclarecimentos do cliente:**

> **Pergunta:** Para tokens como `type` ou `unit` cujo value é uma string, como devemos tratar o retorno uma vez que recebe um apontador do tipo inteiro? Devo retornar um output igual a 0?
>
> **Resposta:** Neste caso não é possível extrair. Só será possível, para sensor id, value e time.

> **Pergunta:**
>
> **Resposta:**

### 1.3. Acceptance Criteria


### 1.4. Found out Dependencies


### 1.7 Other Relevant Remarks

