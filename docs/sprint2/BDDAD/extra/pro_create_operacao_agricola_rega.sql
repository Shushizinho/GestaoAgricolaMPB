create or replace NONEDITIONABLE PROCEDURE pro_create_operacao_agricola_rega (

    p_TipoOperacao           IN OperacaoAgricola.TipoOperacao%TYPE,
    p_CadernoCampoID         IN OperacaoAgricola.CadernoCampoID%TYPE,
    p_DataRealizacao         IN OperacaoAgricola.DataRealizacao%TYPE,
    p_ParcelaAgricolaNome    IN ParcelaAgricola.Designacao%TYPE,
    p_QuantidadeProduto      IN RecolhaProduto.QuantidadeProduto%TYPE,
    p_UnidadeProduto         IN RecolhaProduto.UnidadeProduto%TYPE,
    p_HoraInicio             IN Rega.HoraInicio%TYPE,
    p_HoraFim                IN Rega.HoraFim%TYPE
)

AS

    v_ParcelaID NUMBER;
    v_CulturaID NUMBER;
    v_OperacaoID NUMBER;

BEGIN

    IF p_CadernoCampoID IS NULL OR p_CadernoCampoID <> TRUNC(p_CadernoCampoID) THEN
        RAISE_APPLICATION_ERROR(-20001, 'CadernoCampoID deve ser um número válido.');
END IF;


    -- Obter o ID da parcela agrícola com base no nome fornecido
SELECT ID INTO v_ParcelaID
FROM ParcelaAgricola
WHERE Designacao = p_ParcelaAgricolaNome;

-- Verificar se a parcela agrícola foi encontrada
IF v_ParcelaID IS NULL THEN
        RAISE_APPLICATION_ERROR(-20002, 'Parcela agrícola não encontrada para o nome fornecido.');

END IF;


    -- Inserir na tabela OperacaoAgricola
INSERT INTO OperacaoAgricola (TipoOperacao,CadernoCampoID,DataRealizacao,Quantidade,Unidadedesignacao,CulturaID,ParcelaAgricolaID)
VALUES (
           p_TipoOperacao,
           p_CadernoCampoID,
           p_DataRealizacao,
           p_QuantidadeProduto,
           p_UnidadeProduto,
           NULL,
           v_ParcelaID)
    RETURNING ID INTO v_OperacaoID;

-- Inserir na tabela RecolhaProduto
INSERT INTO Rega (OperacaoAgricolaID,Horainicio,Horafim)
VALUES (v_OperacaoID,p_HoraInicio,p_HoraFim);

-- Commit para confirmar as alterações
COMMIT;

DBMS_OUTPUT.PUT_LINE('Operação de rega registrada com sucesso. ID da Operação: ' || v_OperacaoID);
EXCEPTION
    WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR(-20003, 'Erro ao registrar operação de rega: ' || SQLERRM);
ROLLBACK;
END pro_create_operacao_agricola_rega;
