create or replace NONEDITIONABLE PROCEDURE prc_create_operacao_fator_producao (
    id_caderno_campo IN OperacaoAgricola.CadernoCampoID%TYPE,
    data_operacao IN OperacaoAgricola.DataRealizacao%TYPE,
    quantidade_operacao IN OperacaoAgricola.Quantidade%TYPE,
    unidade_operacao IN OperacaoAgricola.Unidadedesignacao%TYPE,
    quantidade_fator IN aplicacaofator.QUANTIDADEFATOR%TYPE,
    unidade_fator IN aplicacaofator.UNIDADEFATOR%TYPE,
    culturaid_e Cultura.ID%TYPE DEFAULT NULL,
    fatorproducao_nome IN FatorProducao.NomeComercial%TYPE,
    parcela_nome IN ParcelaAgricola.Designacao%TYPE
) AS
    v_OperacaoID OperacaoAgricola.ID%TYPE;
    v_Modo VARCHAR2(255);
    id_parcela ParcelaAgricola.ID%TYPE;
    fatorproducaoid_e FatorProducao.ID%TYPE;
    quantidade ParcelaAgricola.Area%TYPE;
     v_count NUMBER;
BEGIN

SELECT ID, Area INTO id_parcela, quantidade FROM ParcelaAgricola WHERE Designacao = parcela_nome;

    IF id_caderno_campo IS NULL OR id_caderno_campo <> TRUNC(id_caderno_campo) THEN
        RAISE_APPLICATION_ERROR(-20001, 'CadernoCampoID deve ser um número válido.');
END IF;

    IF data_operacao > TRUNC(CURRENT_DATE) THEN
       RAISE_APPLICATION_ERROR(-20002, 'Data de realizacao não pode ser uma data futura.');
END IF;

    IF quantidade_operacao > quantidade THEN
        raise_application_error(-20003, 'Quantidade da operação maior que a quantidade da parcela');
END IF;

    IF unidade_operacao IS NULL OR LENGTH(unidade_operacao) > 10 THEN
        RAISE_APPLICATION_ERROR(-20004, 'Unidade Produto deve ser uma string com um máximo de 10 caracteres.');
END IF;

    IF quantidade_fator IS NULL OR quantidade_fator <> TRUNC(quantidade_fator,2) THEN
        RAISE_APPLICATION_ERROR(-20005, 'Quantidade do fator de produção deve ser um número válido.');
END IF;

     IF unidade_fator IS NULL OR LENGTH(unidade_fator) > 10 THEN
        RAISE_APPLICATION_ERROR(-20006, 'Unidade Fator de produção deve ser uma string com um máximo de 10 caracteres.');
END IF;

    -- Verificar se a parcela agrícola foi encontrada
    IF id_parcela IS NULL THEN
        RAISE_APPLICATION_ERROR(-20007, 'Parcela agrícola não encontrada para o nome fornecido.');
END IF;

    IF culturaid_e IS NOT NULL THEN
SELECT COUNT(*)
INTO v_count
FROM Cultura
WHERE ParcelaAgricolaID = id_parcela AND id = culturaid_e;

IF v_count = 0 THEN
            RAISE_APPLICATION_ERROR(-20008, 'A parcela não está associada à cultura especificada');
END IF;

SELECT Cultura.quantidade INTO quantidade FROM Cultura WHERE id = culturaid_e;

IF quantidade_operacao > quantidade THEN
            raise_application_error(-20009, 'Quantidade da operação maior que a quantidade da cultura');
END IF;

END IF;


INSERT INTO OperacaoAgricola (
    TipoOperacao, CadernoCampoID, DataRealizacao,
    Quantidade, Unidadedesignacao, CulturaID, ParcelaAgricolaID
) VALUES (
             'Aplicação de Fator Produção', id_caderno_campo, data_operacao,
             quantidade_operacao, unidade_operacao, culturaid_e, id_parcela
         ) RETURNING ID INTO v_OperacaoID;


SELECT ID INTO fatorproducaoid_e FROM FatorProducao WHERE NomeComercial = fatorproducao_nome;

IF fatorproducaoid_e IS NULL THEN
        RAISE_APPLICATION_ERROR(-20010, 'Fator de produção não encontrado para o nome fornecido.');
END IF;

SELECT LOWER(Aplicacao) INTO v_Modo FROM FatorProducao WHERE ID = fatorproducaoid_e;

IF v_Modo LIKE '% solo%' THEN
        v_Modo := 'Solo';
    ELSIF v_Modo LIKE '%foliar%' THEN
        v_Modo := 'Foliar';
ELSE
        v_Modo := NULL;
END IF;

INSERT INTO AplicacaoFator (
    OperacaoAgricolaID, FatorProducaoID, Modo,
    QuantidadeFator, UnidadeFator
) VALUES (
             v_OperacaoID, fatorproducaoid_e, v_Modo,
             quantidade_fator, unidade_fator
         );

DBMS_OUTPUT.PUT_LINE('Operação de aplicação de fator produção registrada com sucesso. ID da Operação: ' || v_OperacaoID);
EXCEPTION
    WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR(-20000, 'Erro ao registrar operação de aplicação de fator produção: ' || SQLERRM);
ROLLBACK;

END prc_create_operacao_fator_producao;