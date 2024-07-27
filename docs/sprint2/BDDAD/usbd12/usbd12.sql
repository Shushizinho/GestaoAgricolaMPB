CREATE OR REPLACE PROCEDURE pro_create_operacao_agricola_monda (
    p_TipoOperacao           IN OperacaoAgricola.TipoOperacao%TYPE,
    p_CadernoCampoID         IN OperacaoAgricola.CadernoCampoID%TYPE,
    p_DataRealizacao         IN OperacaoAgricola.DataRealizacao%TYPE,
    p_QuantidadeOperacao     IN OperacaoAgricola.Quantidade%TYPE,
    p_UnidadeOperacao        IN OperacaoAgricola.Unidadedesignacao%TYPE,
    p_ParcelaAgricolaNome    IN ParcelaAgricola.designacao%TYPE,
    p_NomeProduto            IN ProdutoAgricola.nome%TYPE,
    p_MondaTipo              IN Monda.TipoMonda%TYPE
)
AS
    v_OperacaoID OperacaoAgricola.ID%TYPE;
	v_CulturaID Cultura.ID%TYPE;
	v_ParcelaID ParcelaAgricola.ID%TYPE;
    v_plantaID Planta.ID%TYPE;
BEGIN


    IF p_UnidadeOperacao IS NULL OR LENGTH(p_UnidadeOperacao) > 10 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Unidade Operação deve ser uma string com um máximo de 10 caracteres.');
END IF;

    IF p_QuantidadeOperacao IS NULL OR p_QuantidadeOperacao <> TRUNC(p_QuantidadeOperacao,2) THEN
        RAISE_APPLICATION_ERROR(-20002, 'Quantidade deve ser um número válido.');
END IF;

    IF p_DataRealizacao > CURRENT_DATE THEN
        RAISE_APPLICATION_ERROR(-20003, 'Data de realizacao não pode ser uma data futura.');
END IF;

        IF p_CadernoCampoID IS NULL OR p_CadernoCampoID <> TRUNC(p_CadernoCampoID) THEN
        RAISE_APPLICATION_ERROR(-20004, 'CadernoCampoID deve ser um número válido.');
END IF;

 IF p_MondaTipo IS NULL OR LENGTH(p_MondaTipo) > 10 THEN
        RAISE_APPLICATION_ERROR(-20005, 'Tipo de Monda deve ser uma string com um máximo de 10 caracteres.');
END IF;

    -- Obtém o PlantID associado ao nome da parcela na tabela ProdutoAgricola
SELECT ID INTO v_plantaID
FROM ProdutoAgricola
WHERE Nome = p_NomeProduto;

-- Verificar se o produto agrícola foi encontrado
IF v_plantaID IS NULL THEN
        RAISE_APPLICATION_ERROR(-20006, 'Produto agrícola não encontrado para o nome fornecido.');
END IF;

-- Obtém o ID da parcela com base no nome fornecido
SELECT ID INTO v_ParcelaID
FROM ParcelaAgricola
WHERE Designacao = p_ParcelaAgricolaNome;

-- Verificar se a parcela agrícola foi encontrada
IF v_ParcelaID IS NULL THEN
        RAISE_APPLICATION_ERROR(-20007, 'Parcela agrícola não encontrada para o nome fornecido.');
END IF;

-- Obter o ID da cultura com base na planta, parcela e datas
SELECT ID INTO v_CulturaID
FROM Cultura
WHERE ParcelaAgricolaID = v_ParcelaID
  AND PlantaID = v_PlantaID
  AND p_DataRealizacao >= Data_Inicio
  AND (p_DataRealizacao <= Data_Fim OR Data_Fim IS NULL);

-- Verificar se a cultura foi encontrada
IF v_CulturaID IS NULL THEN
        RAISE_APPLICATION_ERROR(-20008, 'Cultura não encontrada para o nome fornecido.');
END IF;



    -- Inserir a operação agricula com os dados fornecidos
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
             p_QuantidadeOperacao,
             p_UnidadeOperacao,
             v_CulturaID,
             v_ParcelaID
         )  RETURNING ID INTO v_OperacaoID;

-- Inserir na tabela monda a operaçao
INSERT INTO Monda (
    OperacaoAgricolaID,
    TipoMonda
) VALUES (
             v_OperacaoID,
             p_MondaTipo
         );


DBMS_OUTPUT.PUT_LINE('Operação de monda registrada com sucesso. ID da Operação: ' || v_OperacaoID);
EXCEPTION
    WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR(-20000, 'Erro ao registrar operação de monda: ' || SQLERRM);
ROLLBACK;
END pro_create_operacao_agricola_monda;

