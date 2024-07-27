create or replace NONEDITIONABLE FUNCTION ConsultaFatores(
    p_parcela_nome IN ParcelaAgricola.Designacao%TYPE,
    p_data_inicio IN operacaoagricola.datarealizacao%TYPE,
    p_data_fim IN operacaoagricola.datarealizacao%TYPE
)
RETURN SYS_REFCURSOR
IS
    v_cursor SYS_REFCURSOR;
    v_parcela_id NUMBER;
BEGIN

    IF p_parcela_nome IS NULL OR p_parcela_nome = '' THEN
        RAISE_APPLICATION_ERROR(-20001, 'Nome da Parcela não pode ser nulo ou vazio');
END IF;

    IF p_data_inicio IS NULL OR p_data_fim IS NULL OR p_data_inicio > p_data_fim THEN
        RAISE_APPLICATION_ERROR(-20002, 'Datas de início e fim devem ser fornecidas e a data de início não pode ser posterior à data de fim');
END IF;

SELECT ID INTO v_parcela_id
FROM ParcelaAgricola
WHERE Designacao = p_parcela_nome;

OPEN v_cursor FOR
SELECT fichatecnica.nome, fatorproducao.nomecomercial, SUM(aplicacaofator.quantidadefator) as QUANTIDADETOTAL
FROM aplicacaofator
         INNER JOIN operacaoagricola ON aplicacaofator.operacaoagricolaid = operacaoagricola.id
         INNER JOIN fatorproducao ON fatorproducao.id = aplicacaofator.fatorproducaoid
         INNER JOIN fichatecnica ON fatorproducao.id = fichatecnica.fatorproducaoid
         INNER JOIN cultura ON cultura.id = operacaoagricola.culturaid
WHERE cultura.parcelaagricolaid = v_parcela_id
  AND operacaoagricola.datarealizacao BETWEEN p_data_inicio AND p_data_fim
GROUP BY fichatecnica.nome, fatorproducao.nomecomercial
ORDER BY fichatecnica.nome;

IF NOT v_cursor%FOUND THEN

        RETURN NULL;
END IF;

RETURN v_cursor;
END;