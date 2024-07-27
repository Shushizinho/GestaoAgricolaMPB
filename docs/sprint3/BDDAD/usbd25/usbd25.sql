CREATE OR REPLACE TRIGGER trg_generate_operacaoid
BEFORE INSERT ON Operacao
FOR EACH ROW
DECLARE
ultimo_operacaoid NUMBER;
BEGIN
SELECT MAX(OperacaoID) INTO ultimo_operacaoid FROM Operacao;
:NEW.OperacaoID := NVL(ultimo_operacaoid, 0) + 1;
EXCEPTION
  WHEN OTHERS THEN
    :NEW.OperacaoID := NULL;
END;
/