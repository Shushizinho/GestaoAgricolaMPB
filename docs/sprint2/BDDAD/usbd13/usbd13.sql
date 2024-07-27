create or replace NONEDITIONABLE PROCEDURE pro_create_operacao_agricola_colheita (
    p_TipoOperacao           IN OperacaoAgricola.TipoOperacao%TYPE,
    p_CadernoCampoID         IN OperacaoAgricola.CadernoCampoID%TYPE,
    p_DataRealizacao         IN OperacaoAgricola.DataRealizacao%TYPE,
    p_ParcelaAgricolaNome    IN ParcelaAgricola.Designacao%TYPE,
    p_ProdutoAgricolaNome    IN ProdutoAgricola.Nome%TYPE,
    p_CulturaID              IN Cultura.ID%TYPE DEFAULT NULL,
    p_QuantidadeProduto      IN RecolhaProduto.QuantidadeProduto%TYPE,
    p_UnidadeProduto         IN RecolhaProduto.UnidadeProduto%TYPE

)
AS
    v_ParcelaID NUMBER;
    v_PlantaID NUMBER;
    v_CulturaID NUMBER;
    v_OperacaoID NUMBER;
    v_ProdutoAgricolaID NUMBER;

    -- Cursor para armazenar resultados do SELECT
CURSOR culturas_cursor IS
SELECT ID
FROM Cultura
WHERE ParcelaAgricolaID = v_ParcelaID
  AND PlantaID = v_PlantaID
  AND p_DataRealizacao >= Data_Inicio
  AND (p_DataRealizacao <= Data_Fim OR Data_Fim IS NULL);
BEGIN

    IF p_UnidadeProduto IS NULL OR LENGTH(p_UnidadeProduto) > 10 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Unidade Produto deve ser uma string com um máximo de 10 caracteres.');
END IF;

    IF p_QuantidadeProduto IS NULL OR p_QuantidadeProduto <> TRUNC(p_QuantidadeProduto,2) THEN
        RAISE_APPLICATION_ERROR(-20002, 'Quantidade deve ser um número válido.');
END IF;

    IF p_DataRealizacao > CURRENT_DATE THEN
        RAISE_APPLICATION_ERROR(-20003, 'Data de realizacao não pode ser uma data futura.');
END IF;

        IF p_CadernoCampoID IS NULL OR p_CadernoCampoID <> TRUNC(p_CadernoCampoID) THEN
        RAISE_APPLICATION_ERROR(-20004, 'CadernoCampoID deve ser um número válido.');
END IF;


    -- Obter o ID da parcela agrícola com base no nome fornecido
SELECT ID INTO v_ParcelaID
FROM ParcelaAgricola
WHERE Designacao = p_ParcelaAgricolaNome;

-- Verificar se a parcela agrícola foi encontrada
IF v_ParcelaID IS NULL THEN
        RAISE_APPLICATION_ERROR(-20005, 'Parcela agrícola não encontrada para o nome fornecido.');

END IF;

    -- Obter o ID da planta associada ao produto agrícola
SELECT PlantaID INTO v_PlantaID
FROM ProdutoAgricola
WHERE Nome = p_ProdutoAgricolaNome;

-- Verificar se o produto agrícola foi encontrado
IF v_PlantaID IS NULL THEN
        RAISE_APPLICATION_ERROR(-20006, 'Produto agrícola não encontrado para o nome fornecido.');
END IF;

    -- Obter o ID do produto agrícola com base no nome fornecido
SELECT ID INTO v_ProdutoAgricolaID
FROM ProdutoAgricola
WHERE Nome = p_ProdutoAgricolaNome;

IF p_CulturaID IS NULL THEN
        -- Se for nulo, usar o cursor e loop para obter múltiplos resultados
        FOR cultura_rec IN culturas_cursor LOOP
            v_CulturaID := cultura_rec.ID;

            -- Inserir na tabela OperacaoAgricola
INSERT INTO OperacaoAgricola (
    TipoOperacao,
    CadernoCampoID,
    DataRealizacao,
    Quantidade,
    Unidadedesignacao,
    CulturaID,
    ParcelaAgricolaID
) VALUES (
             p_TipoOperacao,
             p_CadernoCampoID,
             p_DataRealizacao,
             (SELECT Quantidade FROM Cultura WHERE ID = v_CulturaID),
             (SELECT Unidade FROM Cultura WHERE ID = v_CulturaID),
             v_CulturaID,
             v_ParcelaID
         ) RETURNING ID INTO v_OperacaoID;

        -- Inserir na tabela RecolhaProduto
            INSERT INTO RecolhaProduto (OperacaoAgricolaID,ProdutoAgricolaID,QuantidadeProduto,UnidadeProduto)
            VALUES (v_OperacaoID,v_ProdutoAgricolaID,p_QuantidadeProduto,p_UnidadeProduto);
        END LOOP;
ELSE
        -- Se o parâmetro p_CulturaID não for nulo, utilizar o valor recebido
        v_CulturaID := p_CulturaID;

        -- Inserir na tabela OperacaoAgricola
INSERT INTO OperacaoAgricola (TipoOperacao,CadernoCampoID,DataRealizacao,Quantidade,Unidadedesignacao,CulturaID,ParcelaAgricolaID)
VALUES (
        p_TipoOperacao,
        p_CadernoCampoID,
        p_DataRealizacao,
        (SELECT Quantidade FROM Cultura WHERE ID = v_CulturaID),
        (SELECT Unidade FROM Cultura WHERE ID = v_CulturaID),
        v_CulturaID,
        v_ParcelaID)
             RETURNING ID INTO v_OperacaoID;

-- Inserir na tabela RecolhaProduto
INSERT INTO RecolhaProduto (OperacaoAgricolaID,ProdutoAgricolaID,QuantidadeProduto,UnidadeProduto)
VALUES (v_OperacaoID,v_ProdutoAgricolaID,p_QuantidadeProduto,p_UnidadeProduto);
END IF;

DBMS_OUTPUT.PUT_LINE('Operação de colheita registrada com sucesso. ID da Operação: ' || v_OperacaoID);
EXCEPTION
    WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR(-20000, 'Erro ao registrar operação de colheita: ' || SQLERRM);
ROLLBACK;
END pro_create_operacao_agricola_colheita;




