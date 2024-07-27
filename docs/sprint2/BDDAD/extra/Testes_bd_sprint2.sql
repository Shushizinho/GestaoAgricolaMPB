--USBD11
Sucesso:
BEGIN
    prc_create_operacao_agricola_semeadura(
        'Sementeira', 
        1,
        TO_DATE('20-09-2023', 'DD-MM-YYYY'),
        0.9,
        'kg',
        0.3,
        'ha',
        'Nabo greleiro senhora conceição',
        'Horta nova'
    );
END;

Insucesso:
BEGIN
    prc_create_operacao_agricola_semeadura(
        'Sementeira', 
        1,
        TO_DATE('19-09-2023', 'DD-MM-YYYY'),
        1.8,
        'kg',
        0.75,
        'ha',
        'Nabo greleiro senhora conceição',
        'Campo novo'
    );
END;


--USBD12
Sucesso:
BEGIN
   pro_create_operacao_agricola_monda(
       'Monda',
       1,
       TO_DATE('08-09-2023','DD-MM-YYYY'),
        0.5,
       'ha',
       'Campo novo',
       'Cenoura danvers half long',
       'Manual'
       );
END;

Insucesso:
BEGIN
   pro_create_operacao_agricola_monda(
       'Monda',
       1,
       TO_DATE('11-10-2023','DD-MM-YYYY'),
        0.5,
       'ha',
       'Campo novo',
       'Cenoura danvers half long',
       'Manual'
       );
END;


--USBD13
Sucesso:
BEGIN
    pro_create_operacao_agricola_colheita(
        'Colheita',
        1,
        TO_DATE('05-11-2023','DD-MM-YYYY'),
        'Campo grande',
        'Azeitona galega',
        NULL,
        100,
        'kg'
    );
END;

Insucesso:
BEGIN
    pro_create_operacao_agricola_colheita(
        'Colheita',
        1,
        TO_DATE('05-10-2023','DD-MM-YYYY'),
        'Campo grande',
        'Maçã golden',
        NULL,
        800,
        'kg'
    );
END;


--USBS14
Sucesso:
BEGIN
    prc_create_operacao_fator_producao(
        1,                          
        TO_DATE('06-10-2023','DD-MM-YYYY'), 
	1.1,
	'ha',
	4000,
	'kg',
	NULL, --culturaid
    'Fertimax Extrume de Cavalo',
    'Campo novo'
    );
END;

Insucesso:
BEGIN
    prc_create_operacao_fator_producao(
        1,                          
        TO_DATE('08-10-2023','DD-MM-YYYY'), 
	2.1,
	'ha',
	8000,
	'kg',
	NULL, --culturaid
    'Fertimax Extrume de Cavalo',
    'Campo novo'
    );
END;




--USBD16

SET SERVEROUTPUT ON;
DECLARE
v_cursor SYS_REFCURSOR;
    pNomeParcela_teste ParcelaAgricola.Designacao%TYPE := 'Campo novo';
    pDataInicio_teste Operacaoagricola.DATAREALIZACAO%TYPE := TO_DATE('20-05-2023', 'DD-MM-YYYY');
    pDataFim_teste Operacaoagricola.DATAREALIZACAO%TYPE := TO_DATE('06-11-2023', 'DD-MM-YYYY');
    v_parcela ParcelaAgricola.Designacao%TYPE;
    v_especie Planta.Especie%TYPE;
    v_area ParcelaAgricola.Area%TYPE;
    v_dataRealizacao OperacaoAgricola.DataRealizacao%TYPE;
    v_nome ProdutoAgricola.Nome%TYPE;
    v_quantidade RecolhaProduto.QuantidadeProduto%TYPE;
    v_unidadeProduto RecolhaProduto.UnidadeProduto%TYPE;

BEGIN
    v_cursor:= ObterProdutosColhidos(pNomeParcela_teste, pDataInicio_teste, pDataFim_teste);
        LOOP
        FETCH v_cursor INTO v_parcela, v_especie, v_area, v_dataRealizacao, v_nome, v_quantidade, v_unidadeProduto;
        EXIT WHEN v_cursor%NOTFOUND;

            DBMS_OUTPUT.PUT_LINE(
            'Espécie: ' || v_especie ||
            ', Parcela: ' || v_parcela ||
            ', Área da Parcela: ' || v_area ||
            ', Produto: ' || v_nome ||
            ', Data de Colheita: ' || TO_CHAR(v_dataRealizacao, 'DD-MON-YYYY') ||
            ', Quantidade: ' || v_quantidade || ' ' || v_unidadeProduto
        );
        DBMS_OUTPUT.PUT_LINE('');
END LOOP;
CLOSE v_cursor;
END;
/

--USBD17

SET SERVEROUTPUT ON;
DECLARE
v_result SYS_REFCURSOR;
    v_nome fichatecnica.nome%TYPE;
    v_nomecomercial fatorproducao.nomecomercial%TYPE;
    v_quantidadetotal NUMBER;
BEGIN
    v_result := ConsultaFatores('Lameiro do moinho', TO_DATE('01-01-2019', 'DD-MM-YYYY'), TO_DATE('06-07-2023', 'DD-MM-YYYY'));

    LOOP
FETCH v_result INTO v_nome, v_nomecomercial, v_quantidadetotal;
        EXIT WHEN v_result%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(v_nome || ' ' || v_nomecomercial || ' ' || v_quantidadetotal);
END LOOP;

CLOSE v_result;
END;
/


--USBD18

SET SERVEROUTPUT ON;
DECLARE
v_cursor SYS_REFCURSOR;
  v_dataRealizacao operacaoagricola.DataRealizacao%TYPE;
  v_tipoOperacao operacaoagricola.TipoOperacao%TYPE;
  v_horaInicioRega VARCHAR2(255);
  v_cultura planta.Nome%TYPE;
  v_quantidade operacaoagricola.Quantidade%TYPE;
  v_unidadeDesignacao operacaoagricola.Unidadedesignacao%TYPE;
BEGIN
  v_cursor := ObterOperacoesPorParcela(TO_DATE('01-07-2023','DD-MM-YYYY'),TO_DATE('02-10-2023','DD-MM-YYYY') , 'Campo novo');

  LOOP
FETCH v_cursor INTO v_dataRealizacao, v_tipoOperacao, v_horaInicioRega, v_cultura, v_quantidade, v_unidadeDesignacao;
    EXIT WHEN v_cursor%NOTFOUND;


    DBMS_OUTPUT.PUT_LINE(v_tipoOperacao);
    DBMS_OUTPUT.PUT_LINE(v_dataRealizacao || ' operação de ' || v_tipoOperacao ||
                         ' ' || v_cultura || ', ' || v_quantidade || ' ' || v_unidadeDesignacao ||
                         (CASE WHEN v_tipoOperacao = 'Rega' THEN ', ' || v_horaInicioRega ELSE '' END) );

    DBMS_OUTPUT.PUT_LINE('');
END LOOP;

CLOSE v_cursor;
END;
/


--USBD19

SET SERVEROUTPUT ON;
DECLARE
v_cursor SYS_REFCURSOR;
    p_data_inicio DATE := TO_DATE('01-01-2019', 'DD-MM-YYYY');
    p_data_fim DATE := TO_DATE('06-07-2023', 'DD-MM-YYYY');
    p_parcela_nome VARCHAR2(255) := 'Lameiro do moinho';
    v_data OperacaoAgricola.DataRealizacao%TYPE;
    v_cultura  Planta.Nome%TYPE;
    v_TipoFator FatorProducao.NomeComercial%TYPE;
BEGIN
    v_cursor := ObterFatorProducao(p_data_inicio, p_data_fim, p_parcela_nome);

        LOOP
FETCH v_cursor INTO v_data, v_TipoFator, v_cultura;
        EXIT WHEN v_cursor%NOTFOUND;
        v_cultura := NVL(v_cultura, 'Sem Cultura');


        DBMS_OUTPUT.PUT_LINE(TO_CHAR(v_data, 'DD-Mon-YYYY') || ', ' || v_TipoFator || ', ' || v_cultura);

END LOOP;
CLOSE v_cursor;
END;
/