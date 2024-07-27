CREATE OR REPLACE FUNCTION obter_duracao_total(p_ano NUMBER)
RETURN SYS_REFCURSOR
IS
    v_result_cursor SYS_REFCURSOR;
BEGIN
OPEN v_result_cursor FOR
SELECT
    Cultura.CulturaID,
    Cultura.Data_Inicio,
    Cultura.Data_Fim,
    Cultura.Quantidade,
    Cultura.Unidadedesignacao,
    Planta.Nome,
    SUM(Rega.duracao) AS DuracaoTotal
FROM
    Cultura
        JOIN
    Rega ON Cultura.CulturaID = Rega.CulturaID
        JOIN
    Operacao ON Rega.OperacaoID = Operacao.OperacaoID
        JOIN PLANTA ON Cultura.plantaid = planta.plantaid
WHERE
        EXTRACT(YEAR FROM Operacao.DataRealizacao) = p_ano AND Operacao.Anulado = 0
GROUP BY
    Cultura.CulturaID,
    Cultura.Data_Inicio,
    Cultura.Data_Fim,
    Cultura.Quantidade,
    Cultura.Unidadedesignacao,
    Planta.Nome
ORDER BY
    DuracaoTotal DESC;

RETURN v_result_cursor;
END obter_duracao_total;
/