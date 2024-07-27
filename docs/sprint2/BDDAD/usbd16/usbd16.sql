CREATE OR REPLACE FUNCTION ObterProdutosColhidos(
    pNomeParcela IN ParcelaAgricola.Designacao%TYPE,
    pDataInicio IN Operacaoagricola.DATAREALIZACAO%TYPE,
    pDataFim IN Operacaoagricola.DATAREALIZACAO%TYPE
)   RETURN SYS_REFCURSOR IS
  v_cursor SYS_REFCURSOR;

BEGIN

    IF pNomeParcela IS NULL OR pNomeParcela = '' THEN
        RAISE_APPLICATION_ERROR(-20001, 'Nome da Parcela não pode ser nulo ou vazio');
END IF;

    IF pDataInicio IS NULL OR pDataFim IS NULL OR pDataInicio > pDataFim THEN
        RAISE_APPLICATION_ERROR(-20002, 'Datas de início e fim devem ser fornecidas e a data de início não pode ser posterior à data de fim');
END IF;

OPEN v_cursor FOR
SELECT
    ParcelaAgricola.Designacao AS Parcela,
    Planta.Especie,
    ParcelaAgricola.Area,
    OperacaoAgricola.DataRealizacao AS DataColheita,
    ProdutoAgricola.Nome AS Produto,
    RecolhaProduto.QuantidadeProduto AS Quantidade,
    RecolhaProduto.UnidadeProduto AS Unidade
FROM OperacaoAgricola
         JOIN RecolhaProduto ON OperacaoAgricola.ID = RecolhaProduto.OperacaoAgricolaID
         JOIN ProdutoAgricola ON RecolhaProduto.ProdutoAgricolaID = ProdutoAgricola.ID
         JOIN Cultura ON OperacaoAgricola.CulturaID = Cultura.ID
         JOIN ParcelaAgricola ON OperacaoAgricola.ParcelaAgricolaID = ParcelaAgricola.ID
         JOIN Planta ON Cultura.PlantaID = Planta.ID
WHERE ParcelaAgricola.Designacao = pNomeParcela
  AND OperacaoAgricola.DataRealizacao BETWEEN pDataInicio AND pDataFim;


IF NOT v_cursor%FOUND THEN

      RETURN NULL;
END IF;

RETURN v_cursor;
CLOSE v_cursor;
END;