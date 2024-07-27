SELECT 
    Parcela,
    COUNT(*) AS TotalOperacoesRega
FROM 
    OperacaoAgricola
WHERE 
    TipoOperacaoTipo = 'Rega'
    AND DataRealizacao BETWEEN TO_DATE('02-Jun-2017', 'DD-MON-YYYY') AND TO_DATE('10-Jun-2018', 'DD-MON-YYYY')
GROUP BY 
    Parcela