CREATE OR REPLACE PROCEDURE prc_create_operacao_agricola_semeadura(
    tipo_operacao IN OperacaoAgricola.TipoOperacao%TYPE,
    id_caderno_campo IN OperacaoAgricola.CadernoCampoID%TYPE,
    data_operacao IN OperacaoAgricola.DataRealizacao%TYPE,
    quantidade_operacao IN OperacaoAgricola.Quantidade%TYPE,
    unidade_operacao IN OperacaoAgricola.Unidadedesignacao%TYPE,
    quantidade_cultura IN Cultura.Quantidade%TYPE,
    unidade_cultura IN Cultura.Unidade%TYPE,
    planta_nome IN Planta.Nome%TYPE,
    parcela_nome IN ParcelaAgricola.Designacao%TYPE
)
IS
    id_operacao OperacaoAgricola.ID%TYPE;
    id_cultura Cultura.ID%TYPE;
    id_planta Planta.ID%TYPE;
    tipo_planta Planta.Tipo%TYPE;
    id_parcela ParcelaAgricola.ID%TYPE;
    v_count NUMBER;
    quantidade NUMBER;
BEGIN


    IF tipo_operacao <> 'Sementeira' then
        RAISE_APPLICATION_ERROR(-20001, 'TipoOperacao deve ser "Sementeira".');
END IF;

    IF id_caderno_campo IS NULL OR id_caderno_campo <> TRUNC(id_caderno_campo) THEN
        RAISE_APPLICATION_ERROR(-20002, 'CadernoCampoID deve ser um número válido.');
END IF;

    IF data_operacao > CURRENT_DATE THEN
        RAISE_APPLICATION_ERROR(-20003, 'Data de realizacao não pode ser uma data futura.');
END IF;

    IF quantidade_operacao IS NULL OR quantidade_operacao <> TRUNC(quantidade_operacao,2) THEN
        RAISE_APPLICATION_ERROR(-20004, 'Quantidade deve ser um número válido.');
END IF;

    IF unidade_operacao IS NULL OR LENGTH(unidade_operacao) > 10 THEN
        RAISE_APPLICATION_ERROR(-20005, 'Unidade Operação deve ser uma string com um máximo de 10 caracteres.');
END IF;

SELECT ID, Area INTO id_parcela,quantidade FROM ParcelaAgricola WHERE Designacao = parcela_nome;

SELECT ID INTO id_planta FROM Planta WHERE Nome = planta_nome;

IF id_planta IS NULL THEN
        RAISE_APPLICATION_ERROR(-20006, 'Planta não encontrado para o nome fornecido.');
END IF;


SELECT SUM(Quantidade) into v_count from cultura where parcelaagricolaid = id_parcela AND data_operacao >= Data_Inicio
                                                   AND (data_operacao <= Data_Fim OR Data_Fim IS NULL) and unidade = 'ha';

IF quantidade_cultura > quantidade - v_count THEN
        raise_application_error(-20007, 'Quantidade da operação maior que a quantidade da parcela');
END IF;


IF id_parcela IS NULL OR id_parcela <> TRUNC(id_parcela) THEN
        RAISE_APPLICATION_ERROR(-20008, 'ParcelaAgricolaID deve ser um número válido.');
END IF;


INSERT INTO Cultura (ParcelaAgricolaID,PLANTAID, unidade, quantidade, Data_Inicio, Data_Fim)
VALUES (id_parcela, id_planta, unidade_cultura, quantidade_cultura, data_operacao, NULL)
    RETURNING ID INTO id_cultura;


INSERT INTO OperacaoAgricola (TipoOperacao, CadernoCampoID, DataRealizacao, Quantidade, Unidadedesignacao, CulturaID, ParcelaAgricolaID)
VALUES (tipo_operacao, id_caderno_campo, data_operacao, quantidade_operacao, unidade_operacao, id_cultura, id_parcela)
    RETURNING ID INTO id_operacao;


DBMS_OUTPUT.PUT_LINE('Operação de sementeira registrada com sucesso. ID da Operação: ' || id_operacao);
EXCEPTION
    WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR(-20000, 'Erro ao registrar operação de sementeira: ' || SQLERRM);
ROLLBACK;

END prc_create_operacao_agricola_semeadura;

/



