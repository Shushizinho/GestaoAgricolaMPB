SELECT FATORPRODUCAO_TIPO.TIPOFATORPRODUCAOTIPO AS Tipo, COUNT(OperacaoAgricola.ID) AS NumeroAplicacoes
FROM OperacaoAgricola
INNER JOIN FatorProducao ON OperacaoAgricola.FatorProducaoNomeComercial = FatorProducao.NomeComercial
INNER JOIN FATORPRODUCAO_TIPO ON FATORPRODUCAO_TIPO.FATORPRODUCAONOMECOMERCIAL = OperacaoAgricola.FatorProducaoNomeComercial
WHERE OperacaoAgricola.DataRealizacao >= TO_DATE('10-Jul-2016')
  AND OperacaoAgricola.DataRealizacao <= TO_DATE('10-Sep-2024')
GROUP BY FATORPRODUCAO_TIPO.TIPOFATORPRODUCAOTIPO