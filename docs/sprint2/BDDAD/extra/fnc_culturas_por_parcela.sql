create or replace NONEDITIONABLE FUNCTION fnc_culturas_por_parcela(p_nome_parcela ParcelaAgricola.designacao%TYPE, p_nome_produto ProdutoAgricola.nome%TYPE, p_DataRealizacao OperacaoAgricola.DataRealizacao%TYPE)
RETURN SYS_REFCURSOR
AS
  v_cursor SYS_REFCURSOR;
  v_parcela_id NUMBER;
  v_plant_id NUMBER;
BEGIN

IF p_DataRealizacao > TRUNC(CURRENT_DATE) THEN
   RAISE_APPLICATION_ERROR(-20001, 'Dados não inseridos, data no futuro');
END IF;
  -- Obtém o ID da parcela com base no nome fornecido
SELECT ID INTO v_parcela_id
FROM ParcelaAgricola
WHERE Designacao = p_nome_parcela;

-- Obtém o PlantID associado ao nome da parcela na tabela ProdutoAgricola
SELECT ID INTO v_plant_id
FROM ProdutoAgricola
WHERE Nome = p_nome_produto;

-- Abre o cursor para retornar as culturas associadas à parcela e ao PlantID
OPEN v_cursor FOR
SELECT *
FROM Cultura
WHERE ParcelaAgricolaID = v_parcela_id
  AND PlantaID = v_plant_id
  AND p_DataRealizacao >= Data_Inicio
  AND (p_DataRealizacao <= Data_Fim OR Data_Fim IS NULL);

RETURN v_cursor;

EXCEPTION
    WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR(-20000, 'Erro na parcela, no produto ou na data descrita' || SQLERRM);
ROLLBACK;
END;