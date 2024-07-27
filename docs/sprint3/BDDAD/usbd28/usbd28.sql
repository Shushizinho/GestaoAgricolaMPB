-- Trigger for semeadura
CREATE OR REPLACE TRIGGER block_semeadura_deletion
BEFORE DELETE ON semeadura
FOR EACH ROW
BEGIN
    RAISE_APPLICATION_ERROR(-20001, 'Operação Ilegal. Não é permitido apagar dados relativos a Operações (semeadura).');
END;
/

-- Trigger for monda
CREATE OR REPLACE TRIGGER block_monda_deletion
BEFORE DELETE ON monda
FOR EACH ROW
BEGIN
    RAISE_APPLICATION_ERROR(-20001, 'Operação Ilegal. Não é permitido apagar dados relativos a Operações (monda).');
END;
/

-- Trigger for plantacao
CREATE OR REPLACE TRIGGER block_plantacao_deletion
BEFORE DELETE ON plantacao
FOR EACH ROW
BEGIN
    RAISE_APPLICATION_ERROR(-20001, 'Operação Ilegal. Não é permitido apagar dados relativos a Operações (plantacao).');
END;
/

-- Trigger for AFCultura
CREATE OR REPLACE TRIGGER block_afcultura_deletion
BEFORE DELETE ON AFCultura
FOR EACH ROW
BEGIN
    RAISE_APPLICATION_ERROR(-20001, 'Operação Ilegal. Não é permitido apagar dados relativos a Operações (AFCultura).');
END;
/

-- Trigger for AFParcela
CREATE OR REPLACE TRIGGER block_afparcela_deletion
BEFORE DELETE ON AFParcela
FOR EACH ROW
BEGIN
    RAISE_APPLICATION_ERROR(-20001, 'Operação Ilegal. Não é permitido apagar dados relativos a Operações (AFParcela).');
END;
/

-- Trigger for AplicacaoFator
CREATE OR REPLACE TRIGGER block_aplicacaofator_deletion
BEFORE DELETE ON AplicacaoFator
FOR EACH ROW
BEGIN
    RAISE_APPLICATION_ERROR(-20001, 'Operação Ilegal. Não é permitido apagar dados relativos a Operações (AplicacaoFator).');
END;
/

-- Trigger for Poda
CREATE OR REPLACE TRIGGER block_poda_deletion
BEFORE DELETE ON Poda
FOR EACH ROW
BEGIN
    RAISE_APPLICATION_ERROR(-20001, 'Operação Ilegal. Não é permitido apagar dados relativos a Operações (Poda).');
END;
/

-- Trigger for IncorporacaoSolo
CREATE OR REPLACE TRIGGER block_incorporacaosolo_deletion
BEFORE DELETE ON IncorporacaoSolo
FOR EACH ROW
BEGIN
    RAISE_APPLICATION_ERROR(-20001, 'Operação Ilegal. Não é permitido apagar dados relativos a Operações (IncorporacaoSolo).');
END;
/

-- Trigger for Colheita
CREATE OR REPLACE TRIGGER block_colheita_deletion
BEFORE DELETE ON Colheita
FOR EACH ROW
BEGIN
    RAISE_APPLICATION_ERROR(-20001, 'Operação Ilegal. Não é permitido apagar dados relativos a Operações (Colheita).');
END;
/

-- Trigger for MovimentacaoSolo
CREATE OR REPLACE TRIGGER block_movimentacaosolo_deletion
BEFORE DELETE ON MovimentacaoSolo
FOR EACH ROW
BEGIN
    RAISE_APPLICATION_ERROR(-20001, 'Operação Ilegal. Não é permitido apagar dados relativos a Operações (MovimentacaoSolo).');
END;
/

-- Trigger for Rega
CREATE OR REPLACE TRIGGER block_rega_deletion
BEFORE DELETE ON Rega
FOR EACH ROW
BEGIN
    RAISE_APPLICATION_ERROR(-20001, 'Operação Ilegal. Não é permitido apagar dados relativos a Operações (Rega).');
END;
/

-- Trigger for Operacao
CREATE OR REPLACE TRIGGER block_operacao_deletion
BEFORE DELETE ON Operacao
FOR EACH ROW
BEGIN
    RAISE_APPLICATION_ERROR(-20001, 'Operação Ilegal. Não é permitido apagar dados relativos a Operações (Operacao).');
END;
/