CREATE OR REPLACE FUNCTION ObterOperacoesPorParcela(
  p_start_date IN operacaoagricola.DataRealizacao%TYPE,
  p_end_date IN operacaoagricola.DataRealizacao%TYPE,
  p_parcela_name IN ParcelaAgricola.Designacao%TYPE
) RETURN SYS_REFCURSOR IS
  v_cursor SYS_REFCURSOR;
BEGIN

    IF p_start_date IS NULL OR p_end_date IS NULL OR p_start_date > p_end_date THEN
        RAISE_APPLICATION_ERROR(-20001, 'Datas de início e fim devem ser fornecidas e a data de início não pode ser posterior à data de fim');
END IF;

    IF p_parcela_name IS NULL OR p_parcela_name = '' THEN
        RAISE_APPLICATION_ERROR(-20002, 'Nome da Parcela não pode ser nulo ou vazio');
END IF;

OPEN v_cursor FOR
SELECT
    operacaoagricola.DataRealizacao,
    operacaoagricola.TipoOperacao,
    CASE
        WHEN operacaoagricola.TipoOperacao = 'Rega' THEN
            (SELECT horainicio FROM Rega WHERE OperacaoAgricolaID = operacaoagricola.ID)
        ELSE
            NULL
        END AS HoraInicioRega,
    planta.Nome AS Cultura,
    operacaoagricola.Quantidade,
    operacaoagricola.Unidadedesignacao
FROM OperacaoAgricola operacaoagricola
         LEFT JOIN Cultura cultura ON operacaoagricola.CulturaID = cultura.ID
         LEFT JOIN ParcelaAgricola parcela ON operacaoagricola.ParcelaAgricolaID = parcela.ID
         LEFT JOIN Planta planta ON cultura.PlantaID = planta.ID
WHERE parcela.Designacao = p_parcela_name
  AND operacaoagricola.DataRealizacao BETWEEN p_start_date AND p_end_date
ORDER BY operacaoagricola.TipoOperacao, operacaoagricola.DataRealizacao;

IF NOT v_cursor%FOUND THEN

      RETURN NULL;
END IF;


RETURN v_cursor;
END;
