DECLARE
v_result SYS_REFCURSOR;
    v_nome fichatecnica.nome%TYPE;
    v_nomecomercial fatorproducao.nomecomercial%TYPE;
    v_quantidadetotal NUMBER;
BEGIN
    v_result := ConsultaFatores('Lameiro do moinho', TO_DATE('1-1-2019', 'DD-MM-YYYY'), TO_DATE('6-7-2023', 'DD-MM-YYYY'));

    LOOP
FETCH v_result INTO v_nome, v_nomecomercial, v_quantidadetotal;
        EXIT WHEN v_result%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(v_nome || ' ' || v_nomecomercial || ' ' || v_quantidadetotal);
END LOOP;

CLOSE v_result;
END;
/