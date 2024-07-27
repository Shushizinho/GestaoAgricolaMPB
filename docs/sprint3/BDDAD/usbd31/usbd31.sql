--GRANT CREATE TYPE, CREATE ANY TABLE TO system;

CREATE OR REPLACE TYPE FatorProducaoType AS OBJECT (
  NomeComercial VARCHAR2(255),
  Fabricante VARCHAR2(255),
  QuantidadeMistura NUMBER,
  UnidadeMistura VARCHAR2(255)
);

-- Criar um tipo de tabela para armazenar uma lista de fatores de produção
CREATE OR REPLACE TYPE FatoresProducaoArrayType AS TABLE OF FatorProducaoType;





CREATE OR REPLACE NONEDITIONABLE PROCEDURE CriarReceitaFertirrega(
 idMistura NUMBER,
  pFatoresProducao FatoresProducaoArrayType
)
IS
  vFatorProducaoID NUMBER;
BEGIN

INSERT INTO Mistura(ID) VALUES (idMistura);


-- Iterar sobre os fatores de produção e procurar o FatorProducaoID
FOR i IN 1..pFatoresProducao.COUNT
  LOOP
BEGIN
SELECT ID INTO vFatorProducaoID
FROM FatorProducao
WHERE NomeComercial = pFatoresProducao(i).NomeComercial
  AND Fabricante = pFatoresProducao(i).Fabricante;

EXCEPTION
      WHEN NO_DATA_FOUND THEN
        RAISE_APPLICATION_ERROR(-20001, 'Fator de produção não encontrado: ' || pFatoresProducao(i).NomeComercial);
END;

    -- Inserir na tabela MisturaFatorProducao
INSERT INTO MisturaFatorProducao VALUES (idMistura, vFatorProducaoID, pFatoresProducao(i).QuantidadeMistura, pFatoresProducao(i).UnidadeMistura);
END LOOP;
 DBMS_OUTPUT.PUT_LINE('Inserção concluída com sucesso para a Mistura com ID: ' || idMistura);
END;
/