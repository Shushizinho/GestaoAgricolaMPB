CREATE OR REPLACE PROCEDURE ConsultaOperacao (
    pOperacaoID IN NUMBER,
    p_DataAnulacao IN DATE
) IS
    pTabela VARCHAR2(250);
    pSemeadura_CulturaID NUMBER;
    pPlantacao_CulturaID NUMBER;
    pMonda_CulturaID NUMBER;
    pPoda_CulturaID NUMBER;
    pRega_CulturaID NUMBER;
    pAF_CulturaID NUMBER;
    pAF_ParcelaID NUMBER;
    pIncorp_CulturaID NUMBER;
    pColheita_CulturaID NUMBER;
    pMovimentacao_ParcelaID NUMBER;
    v_DataRealizacao DATE;
    num number;

BEGIN

SELECT t.Tabela,
       s.CulturaID AS Semeadura_CulturaID,
       p.CulturaID AS Plantacao_CulturaID,
       mon.CulturaID AS Monda_CulturaID,
       pod.CulturaID AS Poda_CulturaID,
       r.CulturaID AS Rega_CulturaID,
       af.CulturaID as AF_CulturaID,
       afp.ParcelaID as AF_ParcelaID,
       incs.CulturaID as Incorp_CulturaID,
       colhe.CulturaID as Colheita_CulturaID,
       movs.parcelaID as Movimentacao_ParcelaID,
       o.DataRealizacao
INTO
    pTabela,
    pSemeadura_CulturaID,
    pPlantacao_CulturaID,
    pMonda_CulturaID,
    pPoda_CulturaID,
    pRega_CulturaID,
    pAF_CulturaID,
    pAF_ParcelaID,
    pIncorp_CulturaID,
    pColheita_CulturaID,
    pMovimentacao_ParcelaID,
    v_DataRealizacao
FROM Operacao o
         FULL JOIN (
    SELECT 'Semeadura' AS Tabela, OperacaoID FROM Semeadura
    UNION ALL
    SELECT 'Plantacao' AS Tabela, OperacaoID FROM Plantacao
    UNION ALL
    SELECT 'MovimentacaoSolo' AS Tabela, OperacaoID FROM MovimentacaoSolo
    UNION ALL
    SELECT 'AplicacaoFator' AS Tabela, OperacaoID FROM AplicacaoFator
    UNION ALL
    SELECT 'Monda' AS Tabela, OperacaoID FROM Monda
    UNION ALL
    SELECT 'Colheita' AS Tabela, OperacaoID FROM Colheita
    UNION ALL
    SELECT 'Poda' AS Tabela, OperacaoID FROM Poda
    UNION ALL
    SELECT 'Rega' AS Tabela, OperacaoID FROM Rega
    UNION ALL
    SELECT 'IncorporacaoSolo' AS Tabela, OperacaoID FROM IncorporacaoSolo
) t ON o.OperacaoID = t.OperacaoID
         LEFT JOIN Semeadura s ON o.OperacaoID = s.OperacaoID
         LEFT JOIN Plantacao p ON o.OperacaoID = p.OperacaoID
         LEFT JOIN Monda mon ON o.OperacaoID = mon.OperacaoID
         LEFT JOIN Poda pod ON o.OperacaoID = pod.OperacaoID
         LEFT JOIN Rega r ON o.OperacaoID = r.OperacaoID
         LEFT JOIN AFCultura af ON o.operacaoID = af.aplicacaofatoroperacaoid
         LEFT JOIN AFParcela afp ON o.operacaoID = afp.aplicacaofatoroperacaoid
         LEFT JOIN Incorporacaosolo incs ON o.operacaoID = incs.operacaoid
         LEFT JOIN Colheita colhe ON o.operacaoID = colhe.operacaoid
         LEFT JOIN movimentacaosolo movs ON o.operacaoID = movs.operacaoid
WHERE o.operacaoid = pOperacaoID;

IF TO_DATE(p_DataAnulacao, 'DD/MM/YYYY') BETWEEN TO_DATE(v_DataRealizacao, 'DD/MM/YYYY') AND TO_DATE(v_DataRealizacao + 3, 'DD/MM/YYYY') THEN

IF pTabela IN ('Semeadura', 'Plantacao') THEN

SELECT COUNT(*) INTO num

FROM Operacao o
         FULL JOIN (
    SELECT 'AplicacaoFator' AS Tabela, OperacaoID FROM AplicacaoFator
    UNION ALL
    SELECT 'Monda' AS Tabela, OperacaoID FROM Monda
    UNION ALL
    SELECT 'Poda' AS Tabela, OperacaoID FROM Poda
    UNION ALL
    SELECT 'Rega' AS Tabela, OperacaoID FROM Rega
    UNION ALL
    SELECT 'IncorporacaoSolo' AS Tabela, OperacaoID FROM IncorporacaoSolo
) t ON o.OperacaoID = t.OperacaoID
         FULL JOIN Monda mon ON o.OperacaoID = mon.OperacaoID
         FULL JOIN Poda pod ON o.OperacaoID = pod.OperacaoID
         FULL JOIN Rega r ON o.OperacaoID = r.OperacaoID
         FULL JOIN AFCultura af ON o.operacaoID = af.aplicacaofatoroperacaoid
         FULL JOIN AFParcela afp ON o.operacaoID = afp.aplicacaofatoroperacaoid
         FULL JOIN Incorporacaosolo incs ON o.operacaoID = incs.operacaoid
WHERE incs.culturaid = pPlantacao_CulturaID OR pod.culturaid = pPlantacao_CulturaID
   OR r.culturaid = pPlantacao_CulturaID OR af.culturaid = pPlantacao_CulturaID
   OR incs.culturaid = pSemeadura_CulturaID OR pod.culturaid = pSemeadura_CulturaID OR r.culturaid = pSemeadura_CulturaID
   OR af.culturaid = pSemeadura_CulturaID;

IF num > 0 THEN
            RAISE_APPLICATION_ERROR(-20001, 'Erro: Existe uma cultura associada a esta operação.');
END IF;
END IF;

IF pTabela IN ('AplicacaoFator', 'Monda','Poda','Rega','IncorporacaoSolo','Semeadura','Plantacao','MovimentacaoSolo') THEN

SELECT COUNT(*) INTO num

FROM Operacao o
         FULL JOIN (
    SELECT 'Colheita' AS Tabela, OperacaoID FROM Colheita) t ON o.OperacaoID = t.OperacaoID
         FULL JOIN Colheita colhe ON o.operacaoID = colhe.operacaoid
WHERE colhe.culturaid = pPoda_CulturaID or colhe.culturaid = pRega_CulturaID or colhe.culturaid = pAF_CulturaID or colhe.culturaid = pIncorp_CulturaID OR colhe.culturaid = pMovimentacao_ParcelaID OR colhe.culturaid = pMonda_CulturaID OR colhe.culturaid = pPlantacao_CulturaID
   OR colhe.culturaid = pSemeadura_CulturaID;

IF num > 0 THEN
            RAISE_APPLICATION_ERROR(-20002, 'Erro: Existe uma cultura associada a esta operação. 2');
END IF;
END IF;

IF pTabela IN ('AplicacaoFator','MovimentacaoSolo') THEN

SELECT COUNT(*) INTO num

FROM Operacao o
         FULL JOIN (
    SELECT 'Semeadura' AS Tabela, OperacaoID FROM Semeadura
    UNION ALL
    SELECT 'Plantacao' AS Tabela, OperacaoID FROM Plantacao
    UNION ALL
    SELECT 'MovimentacaoSolo' AS Tabela, OperacaoID FROM MovimentacaoSolo
    UNION ALL
    SELECT 'AplicacaoFator' AS Tabela, OperacaoID FROM AplicacaoFator
    UNION ALL
    SELECT 'Monda' AS Tabela, OperacaoID FROM Monda
    UNION ALL
    SELECT 'Poda' AS Tabela, OperacaoID FROM Poda
    UNION ALL
    SELECT 'Rega' AS Tabela, OperacaoID FROM Rega
    UNION ALL
    SELECT 'IncorporacaoSolo' AS Tabela, OperacaoID FROM IncorporacaoSolo
) t ON o.OperacaoID = t.OperacaoID
         FULL JOIN Semeadura s ON o.OperacaoID = s.OperacaoID
         FULL JOIN Plantacao p ON o.OperacaoID = p.OperacaoID
         FULL JOIN Monda mon ON o.OperacaoID = mon.OperacaoID
         FULL JOIN Poda pod ON o.OperacaoID = pod.OperacaoID
         FULL JOIN Rega r ON o.OperacaoID = r.OperacaoID
         FULL JOIN AFCultura af ON o.operacaoID = af.aplicacaofatoroperacaoid
         FULL JOIN AFParcela afp ON o.operacaoID = afp.aplicacaofatoroperacaoid
         FULL JOIN Incorporacaosolo incs ON o.operacaoID = incs.operacaoid
         FULL JOIN Cultura c ON af.CulturaID = c.CulturaID
WHERE (mon.culturaid = c.culturaid and c.parcelaid = pAF_ParcelaID ) or (pod.culturaid = c.culturaid and c.parcelaid = pAF_ParcelaID ) or
    (r.culturaid = c.culturaid and c.parcelaid = pAF_ParcelaID ) or (incs.culturaid = c.culturaid and c.parcelaid = pAF_ParcelaID ) or
    (s.culturaid = c.culturaid and c.parcelaid = pAF_ParcelaID ) or (p.culturaid = c.culturaid and c.parcelaid = pAF_ParcelaID ) or
    (mon.culturaid = c.culturaid and c.parcelaid = pMovimentacao_ParcelaID ) or (pod.culturaid = c.culturaid and c.parcelaid = pMovimentacao_ParcelaID ) or
    (r.culturaid = c.culturaid and c.parcelaid = pMovimentacao_ParcelaID ) or (incs.culturaid = c.culturaid and c.parcelaid = pMovimentacao_ParcelaID ) or
    (s.culturaid = c.culturaid and c.parcelaid = pMovimentacao_ParcelaID ) or (p.culturaid = c.culturaid and c.parcelaid = pMovimentacao_ParcelaID );

IF num > 0 THEN
            RAISE_APPLICATION_ERROR(-20003, 'Erro: Existe uma cultura associada a esta operação. 3');
END IF;
END IF;

UPDATE Operacao
SET Anulado = 1
WHERE Operacao.OperacaoID = pOperacaoID;

ELSE
    RAISE_APPLICATION_ERROR(-20000, 'Erro: Já passaram mais de 3 dias desde a data de realização ');
END IF;

END ConsultaOperacao;
/
