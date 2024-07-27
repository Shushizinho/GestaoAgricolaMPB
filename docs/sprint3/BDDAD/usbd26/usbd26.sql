CREATE OR REPLACE TRIGGER operacao_trigger
AFTER INSERT OR UPDATE ON Operacao FOR EACH ROW
DECLARE
v_acao VARCHAR(255);
v_dados VARCHAR(255);
BEGIN

IF INSERTING THEN
      v_acao := 'Insercao';
    ELSIF UPDATING THEN
        IF :OLD.anulado = 0 AND :NEW.anulado = 1 THEN
        v_acao := 'Anulação';
    ELSE
        v_acao := 'Modificacao';
    END IF;

    INSERT INTO Log (acao, data, operacaoID, OperacaoTipo, dados)
    VALUES (
       v_acao,
       CURRENT_TIMESTAMP,
       :NEW.OperacaoID,
       'Operação',
       'Data realização: ' || :NEW.dataRealizacao || ' Caderno de campo id: ' || :NEW.cadernoCampoID || ' Anulado: ' || :NEW.anulado
    );
END IF;
END;
/



create or replace NONEDITIONABLE TRIGGER operacao_rega_fertirrega_trigger
AFTER INSERT OR UPDATE ON Rega FOR EACH ROW
DECLARE
v_acao VARCHAR(255);
BEGIN

IF INSERTING THEN
  v_acao := 'Insercao';
ELSIF UPDATING THEN
    v_acao := 'Modificacao';
END IF;


IF :NEW.MisturaID IS NULL THEN
INSERT INTO Log (acao , data, operacaoID, OperacaoTipo, dados)
VALUES (
           v_acao,
           CURRENT_TIMESTAMP,
           :NEW.OperacaoID,
           'Rega',
           'Cultura id: ' || :NEW.CulturaID || ' Hora inicial: ' || :NEW.horainicio ||
           ' Duração: ' || :NEW.duracao
       );

ELSE
INSERT INTO Log (acao , data, operacaoID, OperacaoTipo, dados)
VALUES (
       v_acao,
       CURRENT_TIMESTAMP,
       :NEW.OperacaoID,
       'Fertirrega',
       'Cultura id: ' || :NEW.CulturaID || ' Hora inicial: ' || :NEW.horainicio ||
       ' Duração: ' || :NEW.duracao || ' Mistura id: ' || :NEW.MisturaID
   );

END IF;
END;
/





CREATE OR REPLACE TRIGGER operacao_monda_trigger
AFTER INSERT OR UPDATE ON Monda FOR EACH ROW
DECLARE
v_acao VARCHAR(255);

BEGIN

IF INSERTING THEN
  v_acao := 'Insercao';
ELSIF UPDATING THEN
    v_acao := 'Modificacao';
END IF;

INSERT INTO Log (acao , data, operacaoID, OperacaoTipo, dados)
VALUES (
   v_acao,
   CURRENT_TIMESTAMP,
   :NEW.OperacaoID,
   'Monda',
   'Cultura id: ' || :NEW.CulturaID || ' Área: ' || :NEW.area || ' Unidade: ' || :NEW.unidade
);
END;
/




CREATE OR REPLACE TRIGGER operacao_colheita_trigger
AFTER INSERT OR UPDATE ON Colheita FOR EACH ROW
DECLARE
v_acao VARCHAR(255);
BEGIN

IF INSERTING THEN
  v_acao := 'Insercao';
ELSIF UPDATING THEN
    v_acao := 'Modificacao';
END IF;

INSERT INTO Log (acao , data, operacaoID, OperacaoTipo, dados)
VALUES (
       v_acao,
       CURRENT_TIMESTAMP,
       :NEW.OperacaoID,
       'Colheita',
       'Cultura id: ' || :NEW.CulturaID || ' Produto id: '|| :NEW.produtoID || ' Quantidade: ' || :NEW.quantidade || ' Unidade: ' || :NEW.Unidadedesignacao
   );
END;
/





CREATE OR REPLACE TRIGGER operacao_semeadura_trigger
AFTER INSERT OR UPDATE ON Semeadura FOR EACH ROW
DECLARE
v_acao VARCHAR(255);
BEGIN

IF INSERTING THEN
  v_acao := 'Insercao';
ELSIF UPDATING THEN
    v_acao := 'Modificacao';
END IF;

INSERT INTO Log (acao , data, operacaoID, OperacaoTipo, dados)
VALUES (
       v_acao,
       CURRENT_TIMESTAMP,
       :NEW.OperacaoID,
       'Semeadura',
       'Cultura id: ' || :NEW.CulturaID || ' Quandidade de semente: ' || :NEW.quantidadeSemente || ' Unidade: ' || :NEW.unidadeSemente
   );
END;
/





CREATE OR REPLACE TRIGGER operacao_plantacao_trigger
AFTER INSERT OR UPDATE ON Plantacao FOR EACH ROW
DECLARE
v_acao VARCHAR(255);
BEGIN

IF INSERTING THEN
  v_acao := 'Insercao';
ELSIF UPDATING THEN
    v_acao := 'Modificacao';
END IF;

INSERT INTO Log (acao , data, operacaoID, OperacaoTipo, dados)
VALUES (
       v_acao,
       CURRENT_TIMESTAMP,
       :NEW.OperacaoID,
       'Plantação',
       'Cultura id: ' || :NEW.CulturaID || ' Número de plantas: ' || :NEW.NumPlantas || ' Compasso: ' || :NEW.compasso ||
       ' Distâncias entre filas: ' || :NEW.distanciaFilas
   );
END;
/


CREATE OR REPLACE TRIGGER operacao_poda_trigger
AFTER INSERT OR UPDATE ON poda FOR EACH ROW
DECLARE
v_acao VARCHAR(255);
BEGIN

IF INSERTING THEN
  v_acao := 'Insercao';
ELSIF UPDATING THEN
    v_acao := 'Modificacao';
END IF;

INSERT INTO Log (acao , data, operacaoID, OperacaoTipo, dados)
VALUES (
           v_acao,
           CURRENT_TIMESTAMP,
           :NEW.OperacaoID,
           'Poda',
           'Cultura id: ' || :NEW.CulturaID || ' Quandidade: ' || :NEW.quantidade || ' Unidade: ' || :NEW.unidadeQuantidade
       );
END;
/



CREATE OR REPLACE TRIGGER operacao_incorporacaoSolo_trigger
AFTER INSERT OR UPDATE ON IncorporacaoSolo FOR EACH ROW
DECLARE
v_acao VARCHAR(255);
BEGIN

IF INSERTING THEN
  v_acao := 'Insercao';
ELSIF UPDATING THEN
    v_acao := 'Modificacao';
END IF;

INSERT INTO Log (acao , data, operacaoID, OperacaoTipo, dados)
VALUES (
           v_acao,
           CURRENT_TIMESTAMP,
           :NEW.OperacaoID,
           'Incorporação do Solo',
           'Cultura id: ' || :NEW.CulturaID || ' Quandidade: ' || :NEW.quantidade || ' Unidade: ' || :NEW.unidadeDesignacao
       );
END;
/




CREATE OR REPLACE TRIGGER operacao_AplicacaoFator_trigger
AFTER INSERT OR UPDATE ON AplicacaoFator FOR EACH ROW
DECLARE
v_acao VARCHAR(255);
BEGIN

IF INSERTING THEN
  v_acao := 'Insercao';
ELSIF UPDATING THEN
    v_acao := 'Modificacao';
END IF;

INSERT INTO Log (acao , data, operacaoID, OperacaoTipo, dados)
VALUES (
       v_acao,
       CURRENT_TIMESTAMP,
       :NEW.OperacaoID,
       'Aplicação Fator',
       'Id da operação: ' || :NEW.OperacaoID
   );
END;
/


CREATE OR REPLACE TRIGGER operacao_AplicacaoFatorCultura_trigger
AFTER INSERT OR UPDATE ON AFCultura FOR EACH ROW
DECLARE
v_acao VARCHAR(255);
BEGIN

IF INSERTING THEN
  v_acao := 'Insercao';
ELSIF UPDATING THEN
    v_acao := 'Modificacao';
END IF;

INSERT INTO Log (acao , data, operacaoID, OperacaoTipo, dados)
VALUES (
       v_acao,
       CURRENT_TIMESTAMP,
       :NEW.AplicacaoFatorOperacaoID,
       'Aplicação Fator Cultura',
       'Cultura id: ' || :NEW.culturaID || ' Modo de aplicação fator id: ' || :NEW.ModoAFatorID
   );
END;
/



CREATE OR REPLACE TRIGGER operacao_AplicacaoFatorParcela_trigger
AFTER INSERT OR UPDATE ON AFParcela FOR EACH ROW
DECLARE
v_acao VARCHAR(255);
BEGIN

IF INSERTING THEN
  v_acao := 'Insercao';
ELSIF UPDATING THEN
    v_acao := 'Modificacao';
END IF;

INSERT INTO Log (acao , data, operacaoID, OperacaoTipo, dados)
VALUES (
       v_acao,
       CURRENT_TIMESTAMP,
       :NEW.AplicacaoFatorOperacaoID,
       'Aplicação Fator Parcela',
       'Parcela id: ' || :NEW.parcelaID || ' Área: ' || :NEW.area || ' Unidade: ' || :NEW.unidadeDesignacao
   );
END;
/



CREATE OR REPLACE TRIGGER operacao_AplicacaoFator_FatorProducao_trigger
AFTER INSERT OR UPDATE ON AplicacaoFator_FatorProducao FOR EACH ROW
DECLARE
v_acao VARCHAR(255);
BEGIN

IF INSERTING THEN
  v_acao := 'Insercao';
ELSIF UPDATING THEN
    v_acao := 'Modificacao';
END IF;

INSERT INTO Log (acao , data, operacaoID, OperacaoTipo, dados)
VALUES (
       v_acao,
       CURRENT_TIMESTAMP,
       :NEW.OperacaoID,
       'Aplicação Fator de fator de produção',
       'Fator de produção id: ' || :NEW.fatorProducaoID || 'Quantidade: ' || :NEW.Quantidade || ' Unidade: ' || :NEW.Unidadedesignacao
   );
END;
/