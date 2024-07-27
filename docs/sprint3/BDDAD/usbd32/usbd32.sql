create or replace NONEDITIONABLE PROCEDURE prc_create_operacao_regafertirrega (
    p_DataAtual IN Operacao.DataRealizacao%TYPE,
    id_caderno_campo IN Operacao.CadernoCampoID%TYPE,
    data_operacao IN Operacao.DataRealizacao%TYPE,
    duracao IN rega.duracao%TYPE,
    horainicio_e IN rega.horainicio%TYPE,
    setor_design_e Setorderega.designacao%TYPE,
	v_mistura IN Mistura.ID%TYPE DEFAULT NULL
) AS
    v_OperacaoID Operacao.OperacaoID%TYPE;
	v_cursor SYS_REFCURSOR;
	v_setor SYS_REFCURSOR;
	v_temp SYS_REFCURSOR;
    culturaid_e Cultura.CulturaID%TYPE;
    areacultura_e Cultura.Quantidade%TYPE;
    qntfator_e Misturafatorproducao.QuantidadeFator%TYPE;
    id_parcela Parcela.ParcelaID%TYPE;
    id_fator FatorProducao.ID%TYPE;
    setor_id_e Setorderega.ID%TYPE;
    v_count NUMBER;
BEGIN



IF data_operacao > TRUNC(p_DataAtual) THEN
       RAISE_APPLICATION_ERROR(-20004, 'Dados não inseridos, data no futuro');
END IF;

SELECT ID into setor_id_e FROM SetorDeRega WHERE designacao = setor_design_e;
OPEN v_temp FOR
SELECT culturaid
FROM Setorderegacultura
WHERE Setorderegaid = setor_id_e;
OPEN v_setor FOR
SELECT culturaid
FROM Setorderegacultura
WHERE Setorderegaid = setor_id_e;
FETCH v_temp INTO culturaid_e;
IF v_temp%ROWCOUNT > 0 THEN

CLOSE v_temp;
LOOP
FETCH v_setor INTO culturaid_e;
            EXIT WHEN v_setor%NOTFOUND;
INSERT INTO Operacao (
    CadernoCampoID, DataRealizacao
) VALUES (
             id_caderno_campo, data_operacao
         ) RETURNING OperacaoID INTO v_OperacaoID;


INSERT INTO Rega (
    OperacaoID,CulturaID, horainicio, duracao, misturaid
) VALUES (
             v_OperacaoID,culturaid_e, horainicio_e,duracao,v_mistura
         );

IF v_mistura IS NOT NULL THEN
    OPEN v_cursor FOR
SELECT fatorproducaoid, quantidadefator
FROM MisturaFatorProducao
WHERE MisturaID = v_mistura AND Unidadede = 'l/ha';
OPEN v_temp FOR
SELECT fatorproducaoid, quantidadefator
FROM MisturaFatorProducao
WHERE MisturaID = v_mistura AND Unidadede = 'l/ha';

FETCH v_temp INTO id_fator, qntfator_e;
IF v_temp%ROWCOUNT > 0 THEN
       close v_temp;
INSERT INTO AplicacaoFator (
    OperacaoID
) VALUES (
             v_OperacaoID
         );
INSERT INTO AFCultura VALUES(v_OperacaoID, culturaid_e, 3);
SELECT Quantidade
INTO areacultura_e
FROM Cultura where CulturaID = culturaid_e;
LOOP
FETCH v_cursor INTO id_fator,qntfator_e;
            EXIT WHEN v_cursor%NOTFOUND;
INSERT INTO AplicacaoFator_FatorProducao
VALUES (v_OperacaoID,id_fator, (areacultura_e*qntfator_e), 'l');
END LOOP;

CLOSE v_cursor;
END IF;
END IF;
END LOOP;
CLOSE v_setor;
END IF;
COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        RAISE;
END prc_create_operacao_regafertirrega;