CREATE OR REPLACE FUNCTION ObterFatorProducao(
    p_data_inicio IN OperacaoAgricola.DataRealizacao%TYPE,
    p_data_fim IN OperacaoAgricola.DataRealizacao%TYPE,
    p_parcela_nome IN  ParcelaAgricola.Designacao%TYPE
)RETURN SYS_REFCURSOR IS
  v_cursor SYS_REFCURSOR;

BEGIN

    IF p_data_inicio IS NULL OR p_data_fim IS NULL OR p_data_inicio > p_data_fim THEN
        RAISE_APPLICATION_ERROR(-20001, 'Datas de início e fim devem ser fornecidas e a data de início não pode ser posterior à data de fim');
END IF;

    IF p_parcela_nome IS NULL OR p_parcela_nome = '' THEN
        RAISE_APPLICATION_ERROR(-20002, 'Nome da Parcela não pode ser nulo ou vazio');
END IF;

OPEN v_cursor FOR

SELECT OperacaoAgricola.DataRealizacao AS dataFatorProducao,
       FatorProducao.NomeComercial AS TipoFatorProducao,
       Planta.Nome                 AS PlantaNome
FROM AplicacaoFator
         LEFT JOIN OperacaoAgricola ON AplicacaoFator.OperacaoAgricolaID = OperacaoAgricola.ID
         LEFT JOIN  Cultura ON OperacaoAgricola.CulturaID = Cultura.ID
         LEFT JOIN ParcelaAgricola ON Operacaoagricola.ParcelaAgricolaID = ParcelaAgricola.ID
         LEFT JOIN Planta ON Cultura.PlantaID = Planta.ID
         LEFT JOIN FatorProducao ON AplicacaoFator.FatorProducaoID = FatorProducao.ID
WHERE OperacaoAgricola.DataRealizacao BETWEEN p_data_inicio AND p_data_fim and ParcelaAgricola.Designacao = p_parcela_nome
ORDER BY dataFatorProducao;

IF NOT v_cursor%FOUND THEN

      RETURN NULL;
END IF;

RETURN v_cursor;
CLOSE v_cursor;
END;
