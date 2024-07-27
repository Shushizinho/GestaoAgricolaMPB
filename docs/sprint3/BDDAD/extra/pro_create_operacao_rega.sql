create or replace NONEDITIONABLE PROCEDURE pro_create_operacao_rega (
    p_DesignacaoSetor VARCHAR2,
    p_CadernoCampoID NUMBER,
    p_DataRealizacao DATE,
    p_HoraInicio VARCHAR2,
    p_Duracao NUMBER,
    p_MisturaID NUMBER DEFAULT NULL
)
IS
  v_SetorDeRegaID NUMBER;
  v_OperacaoID NUMBER;
BEGIN
  -- Obter o ID do Setor de Rega com base na designação
SELECT ID INTO v_SetorDeRegaID
FROM SetorDeRega
WHERE designacao = p_DesignacaoSetor;

-- Associar a operação de rega a cada Cultura
FOR cult IN (SELECT Cultura.CulturaID FROM Cultura
               JOIN SetorDeRegaCultura ON Cultura.CulturaID = SetorDeRegaCultura.CulturaID
               WHERE SetorDeRegaCultura.SetorDeRegaID = v_SetorDeRegaID) LOOP

    INSERT INTO Operacao (DataRealizacao, CadernoCampoID, DataInsercao, Anulado)
    VALUES (p_DataRealizacao, p_CadernoCampoID, SYSTIMESTAMP, '0')
    RETURNING OperacaoID INTO v_OperacaoID;

INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID)
VALUES (v_OperacaoID, cult.CulturaID, p_HoraInicio, p_Duracao, p_MisturaID);

IF p_MisturaID IS NOT NULL THEN
      INSERT INTO Aplicacaofator (OperacaoID)
      VALUES (v_OperacaoID);
END IF;

END LOOP;

COMMIT; -- Confirmar as alterações no banco de dados
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('Setor de Rega com designação ' || p_DesignacaoSetor || ' não encontrado.');
WHEN OTHERS THEN
    ROLLBACK; -- Em caso de erro, fazer rollback para evitar alterações parciais
    RAISE; -- Rethrow a exceção
END pro_create_operacao_rega;