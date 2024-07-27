--USBD25
-- (succeeded)
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('07-08-2023','DD-MM-YYYY'));

-- (failed)
INSERT INTO operacao(cadernocampoid) VALUES(1);

-- (succeeded)
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('07-08-2023','DD-MM-YYYY'));


--USBD27
-- Tentar apagar o último registo da tabela de logs
-- Deve dar erro por operação ilegal/não permitida.

BEGIN
  DELETE FROM Log WHERE ID = (SELECT MAX(ID) FROM Log);
END;
/


-- Tentar alterar texto do último registo da tabela de logs
-- Deve dar erro por operação ilegal/não permitida.

BEGIN
  UPDATE Log SET Dados = '325' WHERE ID = (SELECT MAX(ID) FROM Log);
END;
/


--US28

BEGIN
DELETE FROM Rega WHERE Operacaoid = (SELECT MAX(Operacaoid) FROM Rega);
END;

--USBD30
-- caso sucesso
-- Inserting an operation (e.g., rega) on the day of the defense
BEGIN
    prc_create_operacao_regafertirrega(TO_DATE('05-01-2024','DD-MM-YYYY'),1,TO_DATE('05-01-2024','DD-MM-YYYY'),60,'15:00',11,null);
END;
/
-- Anular operação de rega
BEGIN
    ConsultaOperacao(548, TO_DATE('05/01/2024', 'DD/MM/YYYY'));
END;
/



-- caso insucesso
-- Anular operação de rega
BEGIN
    ConsultaOperacao(12, TO_DATE('05/10/2024 ', 'DD/MM/YYYY'));
END;
/



--USBD31
Sucesso:

SET SERVEROUTPUT ON;
DECLARE
vMisturaID NUMBER := 22;
vFatoresProducao FatoresProducaoArrayType;
BEGIN
  vFatoresProducao := FatoresProducaoArrayType(
    FatorProducaoType('Tecniferti mol', 'Tecniferti', 60, 'l/ha'),
    FatorProducaoType('Kiplant allgrip', 'Asfertglobal', 2, 'l/ha'),
    FatorProducaoType('SoluSOP 52', 'K+s', 2.5, 'kg/ha')
  );

  CriarReceitaFertirrega(vMisturaID,vFatoresProducao);
END;
/


Insucesso:

DECLARE
vMisturaID NUMBER := 23;
vFatoresProducao FatoresProducaoArrayType;
BEGIN
  vFatoresProducao := FatoresProducaoArrayType(
    FatorProducaoType('Tecniferti mol', 'Tecniferti', 60, 'l/ha'),
    FatorProducaoType('Kiplant allgrip plus', 'Asfertglobal', 2.5, 'l/ha')
  );

  CriarReceitaFertirrega(vMisturaID,vFatoresProducao);
END;
/

--USBD32

--Sucesso
--Segundo os dados suplementares, a mistura no teste do moodle é a 11 e n a 10
DECLARE
BEGIN
    prc_create_operacao_regafertirrega(TO_DATE('05-01-2024','DD-MM-YYYY'),1,TO_DATE('02-09-2023','DD-MM-YYYY'),90,'05:00',10,11);
END;
/
--Insucesso
DECLARE
BEGIN
    prc_create_operacao_regafertirrega(TO_DATE('05-01-2024','DD-MM-YYYY'),1,TO_DATE('02-09-2023','DD-MM-YYYY'),90,'05:00',10,50);
END;
/

--USBD33
    
SET SERVEROUTPUT ON
DECLARE
v_cursor SYS_REFCURSOR;
    v_cultura_id NUMBER;
    v_data_inicio DATE;
    v_data_fim DATE;
    v_quantidade NUMBER;
    v_unidade_designacao VARCHAR2(10);
    v_nome_planta VARCHAR2(255);
    v_duracao_total NUMBER;
    v_duracao_max NUMBER := 0;
BEGIN
    -- Chama a função para obter o cursor
    v_cursor := obter_duracao_total(2023);

    -- Encontra a duração máxima
    LOOP
FETCH v_cursor INTO v_cultura_id, v_data_inicio, v_data_fim, v_quantidade, v_unidade_designacao, v_nome_planta, v_duracao_total;
        EXIT WHEN v_cursor%NOTFOUND;

        IF v_duracao_total > v_duracao_max THEN
            v_duracao_max := v_duracao_total;
END IF;
END LOOP;

    -- Retorna o cursor para o início
CLOSE v_cursor;
v_cursor := obter_duracao_total(2023);

    -- Exibe apenas as culturas com a duração máxima
    DBMS_OUTPUT.PUT_LINE('Ano civil 2023, culturas com maior duração de rega: ' || v_duracao_max);
    LOOP
FETCH v_cursor INTO v_cultura_id, v_data_inicio, v_data_fim, v_quantidade, v_unidade_designacao, v_nome_planta, v_duracao_total;
        EXIT WHEN v_cursor%NOTFOUND;

        IF v_duracao_total = v_duracao_max THEN
            DBMS_OUTPUT.PUT_LINE(v_nome_planta );
END IF;
END LOOP;

    -- Fecha o cursor
CLOSE v_cursor;
END;
/


