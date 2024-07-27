INSERT INTO unidade(designacao) VALUES ('l/h');
INSERT INTO unidade(designacao) VALUES ('kg/ha');
INSERT INTO Mistura(ID) VALUES (10);
INSERT INTO Mistura(ID) VALUES (11);

INSERT INTO TipoPlanta(Designacao) VALUES ('Temporária');
INSERT INTO planta(nome, especie, plantaTipoID) VALUES ('Abóbora manteiga', 'Cucurbita moschata var Butternut', 1);

INSERT INTO produto(nome, plantaid) VALUES ('Abóbora manteiga', 96);

INSERT INTO parcela (designacao, area) VALUES ('Campo novo', 1.1);

INSERT INTO fatorproducao(nomecomercial, formulacao, fabricante,fatorproducaotipo,aplicacao, ph) VALUES ('Fertimax Extrume de Cavalo', 'granulado', 'Nutrofertil', 'Abudo', 'Adubo solo', 6.7);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (12,'Matéria orgânica',0.50);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (12,'N',0.03);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (12,'P205',0.008);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (12,'K20',0.004);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (12,'Ca',0.016);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (12,'MgO',0.003);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (12,'B',0.00004);


INSERT INTO fatorproducao(nomecomercial, formulacao, fabricante,fatorproducaotipo,aplicacao, ph) VALUES ('BIOFERTIL N6', 'granulado', 'Nutrofertil', 'Abudo', 'Adubo solo', 6.5);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (13,'Matéria orgânica',0.53);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (13,'N',0.064);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (13,'P205',0.025);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (13,'K20',0.024);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (13,'Ca',0.06);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (13,'MgO',0.003);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (13,'B',0.000020);


INSERT INTO fatorproducao(nomecomercial, formulacao, fabricante,fatorproducaotipo,aplicacao, ph) VALUES ('Tecniferti mol', 'líquido', 'Tecniferti', 'Adubo', 'Adubo solo', 6.5);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (14,'Matéria orgânica',0.27);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (14,'N',0.036);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (14,'Azoto orgânico N',0.020);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (14,'P205',0.020);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (14,'K20',0.030);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (14,'COT',0.15);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (14,'AF',0.010);


INSERT INTO fatorproducao(nomecomercial, formulacao, fabricante,fatorproducaotipo,aplicacao, ph) VALUES ('SoluSOP 52', 'pó molhavel', 'K+s', 'Abudo', 'Adubo solo', 7);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (15,'SO3',0.45);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (15,'K20',0.525);

INSERT INTO fatorproducao(nomecomercial, formulacao, fabricante,fatorproducaotipo,aplicacao, ph, densidade, unidadeDensidade) VALUES ('Floracal flow sl', 'líquido', 'Plymag', 'Abudo', 'Adubo líquido', 7.8, 1.6, 'kg/l');
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (16,'CaO',0.35);


INSERT INTO fatorproducao(nomecomercial, formulacao, fabricante,fatorproducaotipo,aplicacao) VALUES ('Kiplant allgrip', 'líquido', 'Asfertglobal', 'Abudo', 'Adubo líquido');


INSERT INTO fatorproducao(nomecomercial, formulacao, fabricante,fatorproducaotipo,aplicacao) VALUES ('Cuperdem', 'líquido', 'Asfertglobal', 'Abudo', 'Adubo líquido');
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (18,'Cu',0.06);


INSERT INTO setorDeRega (area, caudal, designacao, DataInsercao,unidadeCaudal) VALUES (3.0, 2500,'10',TO_DATE('01-05-2017','DD-MM-YYYY'), 'l/h');

INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio) VALUES (1, 11, TO_DATE('01-05-2017','DD-MM-YYYY'));
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio) VALUES (1, 12, TO_DATE('01-05-2017','DD-MM-YYYY'));

INSERT INTO setorDeRega(area, caudal, designacao, DataInsercao, unidadeCaudal) VALUES (3.0, 1500,'11', TO_DATE('01-05-2017','DD-MM-YYYY'), 'l/h');

INSERT INTO cultura(parcelaID, PlantaID, unidadedesignacao, quantidade, data_inicio) VALUES (2, 86,'un', 1, TO_DATE('01-05-2017','DD-MM-YYYY'));

INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio) VALUES (2, 28, TO_DATE('01-05-2017','DD-MM-YYYY'));


INSERT INTO setorDeRega (area,  caudal, designacao, DataInsercao, unidadeCaudal) VALUES (1.9, 3500,'21', TO_DATE('01-05-2017','DD-MM-YYYY'), 'l/h');

INSERT INTO cultura(parcelaID, PlantaID, unidadedesignacao, quantidade, data_inicio) VALUES (4, 41, 'un', 1, TO_DATE('01-05-2017','DD-MM-YYYY'));
INSERT INTO cultura(parcelaID, PlantaID, unidadedesignacao, quantidade, data_inicio) VALUES (5, 41, 'un', 1, TO_DATE('01-05-2017','DD-MM-YYYY'));

INSERT INTO cultura(parcelaID, PlantaID, unidadedesignacao, quantidade, data_inicio) VALUES (4, 37,'un', 1, TO_DATE('01-05-2017','DD-MM-YYYY'));
INSERT INTO cultura(parcelaID, PlantaID, unidadedesignacao, quantidade, data_inicio) VALUES (5, 37,'un', 1, TO_DATE('01-05-2017','DD-MM-YYYY'));

INSERT INTO cultura(parcelaID, PlantaID, unidadedesignacao, quantidade, data_inicio) VALUES (4, 48,'un', 1, TO_DATE('01-05-2017','DD-MM-YYYY'));
INSERT INTO cultura(parcelaID, PlantaID, unidadedesignacao, quantidade, data_inicio) VALUES (5, 48,'un', 1, TO_DATE('01-05-2017','DD-MM-YYYY'));
INSERT INTO cultura(parcelaID, PlantaID, unidadedesignacao, quantidade, data_inicio) VALUES (4, 48,'un', 1, TO_DATE('01-05-2019','DD-MM-YYYY'));
INSERT INTO cultura(parcelaID, PlantaID, unidadedesignacao, quantidade, data_inicio) VALUES (5, 48,'un', 1, TO_DATE('01-05-2019','DD-MM-YYYY'));

INSERT INTO cultura(parcelaID, PlantaID, unidadedesignacao, quantidade, data_inicio) VALUES (4, 61,'un', 1, TO_DATE('01-05-2019','DD-MM-YYYY'));
INSERT INTO cultura(parcelaID, PlantaID, unidadedesignacao, quantidade, data_inicio) VALUES (5, 61,'un', 1, TO_DATE('01-05-2019','DD-MM-YYYY'));


INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio) VALUES (3, 28, TO_DATE('01-05-2017','DD-MM-YYYY'));
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio) VALUES (3, 29, TO_DATE('01-05-2017','DD-MM-YYYY'));
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio) VALUES (3, 30, TO_DATE('01-05-2017','DD-MM-YYYY'));
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio) VALUES (3, 31, TO_DATE('01-05-2017','DD-MM-YYYY'));
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio) VALUES (3, 32, TO_DATE('01-05-2017','DD-MM-YYYY'));
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio) VALUES (3, 33, TO_DATE('01-05-2017','DD-MM-YYYY'));
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio) VALUES (3, 34, TO_DATE('01-05-2017','DD-MM-YYYY'));
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio) VALUES (3, 35, TO_DATE('01-05-2017','DD-MM-YYYY'));
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio) VALUES (3, 36, TO_DATE('01-05-2017','DD-MM-YYYY'));
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio) VALUES (3, 37, TO_DATE('01-05-2017','DD-MM-YYYY'));
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio) VALUES (3, 38, TO_DATE('01-05-2017','DD-MM-YYYY'));

INSERT INTO setorDeRega (area,  caudal, designacao, DataInsercao, unidadeCaudal) VALUES (1.1, 3500,'22', TO_DATE('01-05-2019','DD-MM-YYYY'), 'l/h');

INSERT INTO cultura(parcelaID, PlantaID, unidadedesignacao, quantidade, data_inicio) VALUES (5, 44,'un', 1, TO_DATE('01-05-2019','DD-MM-YYYY'));

INSERT INTO cultura(parcelaID, PlantaID, unidadedesignacao, quantidade, data_inicio) VALUES (5, 56,'un', 1, TO_DATE('01-05-2019','DD-MM-YYYY'));

INSERT INTO TipoPlanta(Designacao) VALUES ('Permanente');
INSERT INTO planta(nome, especie, plantaTipoID) VALUES ('Macieira canada', 'Malus domestica', 1);
INSERT INTO cultura(parcelaID, PlantaID, unidadedesignacao, quantidade, data_inicio) VALUES (5, 97,'un', 1, TO_DATE('01-05-2019','DD-MM-YYYY'));

INSERT INTO planta(nome, especie, plantaTipoID) VALUES ('Macieira grand fay', 'Malus domestica', 1);
INSERT INTO cultura(parcelaID, PlantaID, unidadedesignacao, quantidade, data_inicio) VALUES (5, 98,'un', 1, TO_DATE('01-05-2019','DD-MM-YYYY'));

INSERT INTO cultura(parcelaID, PlantaID, unidadedesignacao, quantidade, data_inicio) VALUES (5, 57,'un', 1, TO_DATE('01-05-2019','DD-MM-YYYY'));

--- aqui cultura id do 39 ao 43
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio) VALUES (4, 39, TO_DATE('01-05-2019','DD-MM-YYYY'));
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio) VALUES (4, 40, TO_DATE('01-05-2019','DD-MM-YYYY'));
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio) VALUES (4, 41, TO_DATE('01-05-2019','DD-MM-YYYY'));
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio) VALUES (4, 42, TO_DATE('01-05-2019','DD-MM-YYYY'));
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio) VALUES (4, 43, TO_DATE('01-05-2019','DD-MM-YYYY'));


INSERT INTO setorDeRega (area,  caudal, designacao, DataInsercao, unidadeCaudal) VALUES (1.1, 2500,'41', TO_DATE('01-04-2023','DD-MM-YYYY'), 'l/h');

INSERT INTO cultura(parcelaID, PlantaID, unidadedesignacao, quantidade, data_inicio, data_fim) VALUES (8, 77, 'ha', 0.5, TO_DATE('05-04-2023','DD-MM-YYYY'), TO_DATE('31-05-2023','DD-MM-YYYY'));

INSERT INTO cultura(parcelaID, PlantaID, unidadedesignacao, quantidade, data_inicio, data_fim) VALUES (8, 75, 'ha', 0.5, TO_DATE('05-07-2022','DD-MM-YYYY'), TO_DATE('08-10-2023','DD-MM-YYYY'));
-- aqui cultura id é 44 e 45
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio, Data_fim) VALUES (5, 44, TO_DATE('01-04-2023','DD-MM-YYYY'), TO_DATE('10-10-2023','DD-MM-YYYY'));
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio, Data_fim) VALUES (5, 45, TO_DATE('01-04-2023','DD-MM-YYYY'), TO_DATE('10-10-2023','DD-MM-YYYY'));

INSERT INTO setorDeRega (area,  caudal, designacao, DataInsercao, unidadeCaudal) VALUES (1.1, 3500,'42',  TO_DATE('01-04-2023','DD-MM-YYYY'), 'l/h');

INSERT INTO cultura(parcelaID, PlantaID, unidadedesignacao, quantidade, data_inicio, data_fim) VALUES (8, 96, 'ha', 0.6, TO_DATE('06-04-2023','DD-MM-YYYY'), TO_DATE('10-09-2023','DD-MM-YYYY'));
--- cultura id é 46
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio, Data_fim) VALUES (6, 46, TO_DATE('01-04-2023','DD-MM-YYYY'), TO_DATE('10-10-2023','DD-MM-YYYY'));

INSERT INTO MisturaFatorProducao VALUES (10, 6, 1.5, 'kg/ha');
INSERT INTO MisturaFatorProducao VALUES (10, 15, 2.5, 'kg/ha');
INSERT INTO MisturaFatorProducao VALUES (10, 16, 1.7, 'l/ha');

INSERT INTO MisturaFatorProducao VALUES (11, 14, 60, 'l/ha');
INSERT INTO MisturaFatorProducao VALUES (11, 17, 2, 'l/ha');

-- algumas operações de rega do setor 41
--07/08/2023 operação de rega, setor 41, 120 min, 06:20
--14/08/2023 operação de rega, setor 41, 120 min, 06:20
--21/08/2023 operação de rega, setor 41, 120 min, 06:20
--28/08/2023 operação de rega, setor 41, 120 min, 06:20
--06/09/2023 operação de rega, setor 41, 120 min, 06:20
--13/09/2023 operação de rega, setor 41, 120 min, 07:00
--20/09/2023 operação de rega, setor 41, 120 min, 07:00

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('07-08-2023', 'DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (257, 44, '06:20', 120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('07-08-2023', 'DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (258, 45, '06:20', 120);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('14-08-2023', 'DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (259, 44, '06:20', 120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('14-08-2023', 'DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (260, 45, '06:20', 120);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('21-08-2023', 'DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (261, 44, '06:20', 120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('21-08-2023', 'DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (262, 45, '06:20', 120);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('28-08-2023', 'DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (263, 44, '06:20', 120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('28-08-2023', 'DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (264, 45, '06:20', 120);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('06-09-2023', 'DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (265, 44, '06:20', 120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('06-09-2023', 'DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (266, 45, '06:20', 120);


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('20-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (267, 44, '07:00', 120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('20-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (268, 45, '07:00', 120);



-- operacoes rega setor 21 na parcela Lameiro da Ponte
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('14-05-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (269, 29, '07:00', 120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('14-05-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (270, 31, '07:00', 120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('14-05-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (271, 33, '07:00', 120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('14-05-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (272, 35, '07:00', 120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('14-05-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (273, 37, '07:00', 120);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('01-06-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (274, 29, '07:00', 120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('01-06-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (275, 31, '07:00', 120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('01-06-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (276, 33, '07:00', 120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('01-06-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (277, 35, '07:00', 120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('01-06-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (278, 37, '07:00', 120);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('15-06-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (279, 29, '07:00', 120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('15-06-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (280, 31, '07:00', 120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('15-06-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (281, 33, '07:00', 120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('15-06-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (282, 35, '07:00', 120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('15-06-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (283, 37, '07:00', 120);


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('30-06-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (284, 29 ,'07:00', 120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('30-06-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (285, 31 ,'07:00', 120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('30-06-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (286, 33 ,'07:00', 120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('30-06-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (287, 35 ,'07:00', 120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('30-06-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (288, 37 ,'07:00', 120);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('07-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (289, 29 ,'07:00', 180);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('07-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (290, 31 ,'07:00', 180);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('07-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (291, 33 ,'07:00', 180);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('07-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (292, 35 ,'07:00', 180);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('07-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (293, 37 ,'07:00', 180);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('14-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (294, 29 , '22:00',  180);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('14-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (295, 31, '22:00',  180);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('14-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (296, 33, '22:00',  180);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('14-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (297, 35, '22:00',  180);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('14-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (298, 37, '22:00',  180);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('21-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (299, 29 , '22:00',  180);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('21-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (300, 31, '22:00',  180);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('21-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (301, 33, '22:00',  180);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('21-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (302, 35, '22:00',  180);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('21-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (303, 37, '22:00',  180);

----mudar ids


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('28-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (304, 29 , '22:00',  180);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('28-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (305, 31, '22:00',  180);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('28-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (306, 33, '22:00',  180);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('28-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (307, 35, '22:00',  180);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('28-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (308, 37, '22:00',  180);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('04-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (309, 29 , '22:00', 150);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('04-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (310, 31, '22:00', 150);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('04-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (311, 33, '22:00', 150);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('04-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (312, 35, '22:00', 150);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('04-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (313, 37, '22:00', 150);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('11-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (314, 29 , '22:00', 150);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('11-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (315, 31, '22:00', 150);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('11-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (316, 33, '22:00', 150);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('11-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (317, 35, '22:00', 150);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('11-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (318, 37, '22:00', 150);


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('18-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (319, 29 , '22:00', 150);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('18-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (320, 31, '22:00', 150);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('18-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (321, 33, '22:00', 150);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('18-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (322, 35, '22:00', 150);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('18-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (323, 37, '22:00', 150);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('25-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (324, 29 , '22:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('25-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (325, 31, '22:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('25-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (326, 33, '22:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('25-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (327, 35, '22:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('25-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (328, 37, '22:00',  120);


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('01-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (329, 29 , '22:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('01-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (330, 31, '22:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('01-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (331, 33, '22:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('01-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (332, 35, '22:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('01-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (333, 37, '22:00',  120);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('08-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (334, 29 , '22:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('08-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (335, 31, '22:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('08-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (336, 33, '22:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('08-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (337, 35, '22:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('08-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (338, 37, '22:00',  120);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('15-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (339, 29 , '22:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('15-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (340, 31, '22:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('15-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (341, 33, '22:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('15-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (342, 35, '22:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('15-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (343, 37, '22:00',  120);


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('18-08-2023','DD-MM-YYYY'));
INSERT INTO Colheita (OperacaoID, quantidade, unidadedesignacao ,produtoID, culturaID ) VALUES(344, 700, 'kg', 48, 33 );
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('18-08-2023','DD-MM-YYYY'));
INSERT INTO Colheita (OperacaoID, quantidade, unidadedesignacao ,produtoID, culturaID ) VALUES(345, 700, 'kg', 48, 35 );


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1, TO_DATE('30-08-2023','DD-MM-YYYY'));
INSERT INTO Colheita (OperacaoID, quantidade, unidadedesignacao ,produtoID, culturaID ) VALUES(346, 900, 'kg', 48, 33 );
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,   TO_DATE('30-08-2023','DD-MM-YYYY'));
INSERT INTO Colheita (OperacaoID, quantidade, unidadedesignacao ,produtoID, culturaID ) VALUES(347, 900, 'kg', 48, 35 );

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1, TO_DATE('05-09-2023','DD-MM-YYYY'));
INSERT INTO Colheita (OperacaoID, quantidade, unidadedesignacao ,produtoID, culturaID ) VALUES(348, 900, 'kg', 41, 29);


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('08-09-2023','DD-MM-YYYY'));
INSERT INTO Colheita (OperacaoID, quantidade, unidadedesignacao ,produtoID, culturaID ) VALUES(349, 1050, 'kg', 41, 29);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('28-09-2023','DD-MM-YYYY'));
INSERT INTO Colheita (OperacaoID, quantidade, unidadedesignacao ,produtoID, culturaID ) VALUES(350, 950, 'kg', 37, 37);


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('03-10-2023','DD-MM-YYYY'));
INSERT INTO Colheita (OperacaoID, quantidade, unidadedesignacao ,produtoID, culturaID ) VALUES(351, 800, 'kg', 37, 37);


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1,  TO_DATE('04-01-2019','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (352);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (352, 13,  3200, 'kg');
INSERT INTO AFParcela (AplicacaoFatorOperacaoID, ParcelaID, area, unidadedesignacao) VALUES (352, 5, 1.1, 'ha');


INSERT INTO cultura(parcelaID, PlantaID, unidadedesignacao, quantidade, data_inicio) VALUES (5, 44 ,'m2',25 , TO_DATE('09-01-2019','DD-MM-YYYY'));
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('09-01-2019','DD-MM-YYYY'));
INSERT INTO plantacao(OperacaoID,CulturaID, NumPlantas, Compasso, DistanciaFilas) VALUES (353, 47, 50, 5, 5);


INSERT INTO cultura(parcelaID, PlantaID, unidadedesignacao, quantidade, data_inicio) VALUES (5, 56 ,'m2',25 ,TO_DATE('09-01-2019','DD-MM-YYYY'));
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('09-01-2019','DD-MM-YYYY'));
INSERT INTO plantacao(OperacaoID,CulturaID, NumPlantas, Compasso, DistanciaFilas) VALUES (354, 48, 20, 5, 5);


INSERT INTO cultura(parcelaID, PlantaID, unidadedesignacao, quantidade, data_inicio) VALUES (5, 61, 'm2',25 , TO_DATE('10-01-2019','DD-MM-YYYY'));
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('10-01-2019','DD-MM-YYYY'));
INSERT INTO plantacao(OperacaoID,CulturaID, NumPlantas, Compasso, DistanciaFilas) VALUES (355, 49, 40, 5, 5);


INSERT INTO cultura(parcelaID, PlantaID, unidadedesignacao, quantidade, data_inicio) VALUES (5, 45, 'm2',25 ,TO_DATE('10-01-2019','DD-MM-YYYY'));
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('10-01-2019','DD-MM-YYYY'));
INSERT INTO plantacao(OperacaoID,CulturaID, NumPlantas, Compasso, DistanciaFilas) VALUES (356, 50 , 30, 5, 5);


INSERT INTO cultura(parcelaID, PlantaID, unidadedesignacao, quantidade, data_inicio) VALUES (5, 98, 'm2',25 ,TO_DATE('11-01-2019','DD-MM-YYYY'));
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('11-01-2019','DD-MM-YYYY'));
INSERT INTO plantacao(OperacaoID,CulturaID, NumPlantas, Compasso, DistanciaFilas) VALUES (357, 51, 40, 5, 5);


INSERT INTO cultura(parcelaID, PlantaID, unidadedesignacao, quantidade, data_inicio) VALUES (5, 57,'m2',25 ,TO_DATE('11-01-2019','DD-MM-YYYY'));
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('11-01-2019','DD-MM-YYYY'));
INSERT INTO plantacao(OperacaoID,CulturaID, NumPlantas, Compasso, DistanciaFilas) VALUES (358, 52, 50, 5, 5);


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('06-01-2020','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (359);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (359, 12, 100, 'kg');
INSERT INTO ModoAFator (Designacao) VALUES ('Adubo solo');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (359, 47,1);


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('06-01-2020','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (360);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (360, 12, 40, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (360, 48,1);



INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('06-01-2020','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (361);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (361, 12, 80, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (361, 49,1);


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('06-01-2020','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (362);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (362, 12, 60, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (362, 50 ,1);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('07-01-2020','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (363);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (363, 12, 100, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (363, 52,1);


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('07-01-2020','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (364);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (364, 12, 150, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (364, 47,1);


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('07-01-2021','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (365);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (365, 12, 60, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (365, 48,1);


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('08-01-2021','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (366);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (366, 12, 120, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (366, 49,1);


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('07-01-2021','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (367);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (367, 12, 90, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (367, 50 ,1);


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('07-01-2021','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (368);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (368, 12, 120, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (368, 51,1);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('07-01-2021','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (369);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (369, 12, 150, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (369, 52,1);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('15-01-2022','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (370);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (370, 13, 150, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (370, 47,1);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('15-01-2022','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (371);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (371, 13, 60, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (371, 48,1);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('15-01-2022','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (372);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (372, 13, 120, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (372, 49,1);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('16-01-2022','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (373);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (373, 13, 90, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (373, 50 ,1);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('16-01-2022','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (374);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (374, 13, 120, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (374, 51,1);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('16-01-2022','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (375);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (375, 13, 150, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (375, 52,1);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('15-05-2022','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (376);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (376, 7, 5, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (376, 47,2);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('15-05-2022','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (377);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (377, 7, 2, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (377, 48,2);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('15-05-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (378);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (378, 7, 4, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (378, 49,2);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('15-05-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (379);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (379, 7, 3, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (379, 50 ,2);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('15-05-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (380);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (380, 7, 4, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (380, 51,2);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('15-05-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (381);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (381, 7, 5, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (381, 52,2);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('15-09-2023','DD-MM-YYYY'));
INSERT INTO Colheita (OperacaoID, quantidade, unidadedesignacao ,produtoID, culturaID ) VALUES(382, 700, 'kg', 41, 50);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('16-09-2023','DD-MM-YYYY'));
INSERT INTO Colheita (OperacaoID, quantidade, unidadedesignacao ,produtoID, culturaID ) VALUES(383, 600, 'kg', 38, 51);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('20-09-2023','DD-MM-YYYY'));
INSERT INTO Colheita (OperacaoID, quantidade, unidadedesignacao ,produtoID, culturaID ) VALUES(384, 700, 'kg', 38, 51);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('27-09-2023','DD-MM-YYYY'));
INSERT INTO Colheita (OperacaoID, quantidade, unidadedesignacao ,produtoID, culturaID ) VALUES(385, 600, 'kg', 61, 48);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('05-10-2023','DD-MM-YYYY'));
INSERT INTO Colheita (OperacaoID, quantidade, unidadedesignacao ,produtoID, culturaID ) VALUES(386, 700, 'kg', 61, 48);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('15-10-2023','DD-MM-YYYY'));
INSERT INTO Colheita (OperacaoID, quantidade, unidadedesignacao ,produtoID, culturaID ) VALUES(387, 1200, 'kg', 52, 52 );

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('15-10-2023','DD-MM-YYYY'));
INSERT INTO Colheita (OperacaoID, quantidade, unidadedesignacao ,produtoID, culturaID ) VALUES(388, 700, 'kg', 40, 48 );

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('12-11-2023','DD-MM-YYYY'));
INSERT INTO Colheita (OperacaoID, quantidade, unidadedesignacao ,produtoID, culturaID ) VALUES(389, 700, 'kg', 44, 47 );

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('15-11-2023','DD-MM-YYYY'));
INSERT INTO Colheita (OperacaoID, quantidade, unidadedesignacao ,produtoID, culturaID ) VALUES(390, 800, 'kg', 44, 47 );

INSERT INTO cultura(parcelaID, PlantaID, unidadedesignacao, quantidade, data_inicio) VALUES (2, 86,'m2', 36, TO_DATE('12-10-2016','DD-MM-YYYY'));
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1, TO_DATE('12-10-2016','DD-MM-YYYY'));
INSERT INTO plantacao(OperacaoID,CulturaID, NumPlantas, Compasso, DistanciaFilas) VALUES (391, 53, 40, 6, 6);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('13-01-2021','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (392);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (392, 13, 120, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (392, 12,1);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('12-01-2021','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (393);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (393, 13,  180, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (393, 11,1);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('12-01-2021','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (394);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (394, 13,  240, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (394, 53,1);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('12-01-2022','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (395);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (395, 13, 120, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (395, 12,1);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('12-01-2022','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (396);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (396, 13, 180, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (396, 11,1);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('13-01-2022','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (397);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (397, 13, 240, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (397, 53,1);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('12-01-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (398);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (398, 13, 120, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (398, 12,1);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('12-01-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (399);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (399, 13, 180, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (399, 11 ,1);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('12-01-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (400);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (400, 13, 240, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (400, 53,1);


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('02-11-2023','DD-MM-YYYY'));
INSERT INTO Colheita (OperacaoID, quantidade, unidadedesignacao ,produtoID, culturaID ) VALUES(401, 400, 'kg', 86, 53);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('05-11-2023','DD-MM-YYYY'));
INSERT INTO Colheita (OperacaoID, quantidade, unidadedesignacao ,produtoID, culturaID ) VALUES(402, 300, 'kg', 89, 12);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1, TO_DATE('08-11-2023','DD-MM-YYYY'));
INSERT INTO Colheita (OperacaoID, quantidade, unidadedesignacao ,produtoID, culturaID ) VALUES(403, 350, 'kg', 92, 11);


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('01-04-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (404);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (404, 8, 500, 'kg');
INSERT INTO AFParcela (AplicacaoFatorOperacaoID, ParcelaID, area, unidadedesignacao) VALUES (404, 8, 1.1, 'ha');

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('05-04-2023','DD-MM-YYYY'));
INSERT INTO semeadura(OperacaoID,CulturaID, QuantidadeSemente, UnidadeSemente) VALUES (405, 44, 1.2, 'kg');


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('06-04-2023','DD-MM-YYYY'));
INSERT INTO semeadura(OperacaoID,CulturaID, QuantidadeSemente, UnidadeSemente) VALUES (406, 46, 1.5, 'kg');


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('08-05-2023','DD-MM-YYYY'));
INSERT INTO monda (OperacaoID, CulturaID, Area, unidade) VALUES (407, 44, 0.5, 'ha');


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('20-05-2023','DD-MM-YYYY'));
INSERT INTO monda (OperacaoID, CulturaID, Area, unidade) VALUES (408, 46, 0.6, 'ha');

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('14-06-2023','DD-MM-YYYY'));
INSERT INTO Colheita (OperacaoID, quantidade, unidadedesignacao ,produtoID, culturaID ) VALUES(409, 1500, 'kg', 77, 44 );

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('20-06-2023','DD-MM-YYYY'));
INSERT INTO monda (OperacaoID, CulturaID, Area, unidade) VALUES (410, 46, 0.6, 'ha');

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('28-06-2023','DD-MM-YYYY'));
INSERT INTO Colheita (OperacaoID, quantidade, unidadedesignacao ,produtoID, culturaID ) VALUES(411, 2500, 'kg', 77, 44 );

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('03-07-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (412);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (412, 12, 1800, 'kg');
INSERT INTO AFParcela (AplicacaoFatorOperacaoID, ParcelaID, area, unidadedesignacao) VALUES (412, 8, 0.5, 'ha');


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('04-07-2023','DD-MM-YYYY'));
INSERT INTO MovimentacaoSolo(OperacaoID, ParcelaID, Area, Unidadedesignacao) VALUES (413, 8, 0.5, 'ha');


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('05-07-2023','DD-MM-YYYY'));
INSERT INTO semeadura(OperacaoID,CulturaID, QuantidadeSemente, UnidadeSemente) VALUES (414, 45, 1.2, 'kg');


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('08-08-2023','DD-MM-YYYY'));
INSERT INTO monda (OperacaoID, CulturaID, Area, unidade) VALUES (415, 45, 0.5, 'ha');

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('15-09-2023','DD-MM-YYYY'));
INSERT INTO Colheita (OperacaoID, quantidade, unidadedesignacao ,produtoID, culturaID ) VALUES(416, 8000, 'kg', 96, 46 );


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('25-09-2023','DD-MM-YYYY'));
INSERT INTO Colheita (OperacaoID, quantidade, unidadedesignacao ,produtoID, culturaID ) VALUES(417, 5000, 'kg', 96, 46 );


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('18-09-2023','DD-MM-YYYY'));
INSERT INTO Colheita (OperacaoID, quantidade, unidadedesignacao ,produtoID, culturaID ) VALUES(418, 900, 'kg', 75, 45 );


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('22-09-2023','DD-MM-YYYY'));
INSERT INTO Colheita (OperacaoID, quantidade, unidadedesignacao ,produtoID, culturaID ) VALUES(419, 1500, 'kg', 75, 45 );

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('05-10-2023','DD-MM-YYYY'));
INSERT INTO Colheita (OperacaoID, quantidade, unidadedesignacao ,produtoID, culturaID ) VALUES(420, 1200, 'kg', 75, 45 );


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES( 1,  TO_DATE('10-10-2023','DD-MM-YYYY'));
INSERT INTO MovimentacaoSolo(OperacaoID, ParcelaID, Area, Unidadedesignacao) VALUES (421, 8, 1.1, 'ha');


INSERT INTO cultura(parcelaID, PlantaID, unidadedesignacao, quantidade, data_inicio) VALUES (8, 80, 'un', 1, TO_DATE('09-01-2019','DD-MM-YYYY'));
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(1,  TO_DATE('09-01-2019','DD-MM-YYYY'));
INSERT INTO semeadura(OperacaoID,CulturaID, QuantidadeSemente, UnidadeSemente) VALUES (422, 53, 32, 'kg');

-- operacoes rega do setor 10
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('02-06-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (423);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (423, 11, '06:00', 60, 10);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('02-06-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (424);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (424, 12, '06:00', 60, 10);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('17-06-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (425, 11, '05:00', 30);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('17-06-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (426, 12, '05:00', 30);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('02-07-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (427);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (427, 11, '06:00', 120, 10);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('02-07-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (428);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (428, 12, '06:00', 120, 10);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('17-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (429, 11, '05:00', 30);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('17-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (430, 12, '05:00', 30);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('02-08-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (431);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (431, 11, '05:00', 180, 10);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('02-08-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (432);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (432, 12, '05:00', 180, 10);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('17-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (433, 11, '05:00', 60);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('17-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (434, 12, '05:00', 60);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('04-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (435, 11, '06:00', 120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('04-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (436, 12, '06:00', 120);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('18-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (437, 11, '05:00', 30);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('18-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (438, 12, '05:00', 30);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('02-10-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (439, 11, '05:00', 60);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('02-10-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (440, 12, '05:00', 60);

-- operações de rega do setor 22
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('13-05-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (441, 39, '23:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('13-05-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (442, 40, '23:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('13-05-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (443, 41, '23:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('13-05-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (444, 42, '23:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('13-05-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (445, 43, '23:00',  120);


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('02-06-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (446, 39, '23:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('02-06-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (447, 40, '23:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('02-06-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (448, 41, '23:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('02-06-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (449, 42, '23:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('02-06-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (450, 43, '23:00',  120);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('16-06-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (451);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (451, 39, '23:00',  120, 10);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('16-06-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (452);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (452, 40, '23:00',  120, 10);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('16-06-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (453);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (453, 41, '23:00',  120, 10);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('16-06-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (454);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (454, 42, '23:00',  120, 10);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('16-06-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (455);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (455, 43, '23:00',  120, 10);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('01-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (456, 39, '23:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('01-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (457, 40, '23:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('01-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (458, 41, '23:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('01-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (459, 42, '23:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('01-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (460, 43, '23:00',  120);


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('08-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (461, 39, '23:00', 180);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('08-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (462, 40, '23:00', 180);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('08-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (463, 41, '23:00', 180);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('08-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (464, 42, '23:00', 180);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('08-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (465, 43, '23:00', 180);


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('15-07-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (466);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (466, 39, '23:00', 180, 11);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('15-07-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (467);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (467, 40, '23:00', 180, 11);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('15-07-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (468);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (468, 41, '23:00', 180, 11);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('15-07-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (469);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (469, 42, '23:00', 180, 11);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('15-07-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (470);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (470, 43, '23:00', 180, 11);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('22-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (471, 39, '23:00', 180);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('22-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (472, 40, '23:00', 180);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('22-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (473, 41, '23:00', 180);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('22-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (474, 42, '23:00', 180);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('22-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (475, 43, '23:00', 180);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('29-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (476, 39, '23:00', 180);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('29-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (477, 40, '23:00', 180);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('29-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (478, 41, '23:00', 180);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('29-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (479, 42, '23:00', 180);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('29-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (480, 43, '23:00', 180);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('05-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (481, 39, '23:00', 150);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('05-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (482, 40, '23:00', 150);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('05-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (483, 41, '23:00', 150);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('05-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (484, 42, '23:00', 150);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('05-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (485, 43, '23:00', 150);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('10-08-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (486);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (486, 39, '23:00', 150, 10);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('10-08-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (487);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (487, 40, '23:00', 150, 10);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('10-08-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (488);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (488, 41, '23:00', 150, 10);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('10-08-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (489);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (489, 42, '23:00', 150, 10);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('10-08-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (490);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (490, 43, '23:00', 150, 10);


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('17-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (491, 39, '23:00', 150);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('17-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (492, 40, '23:00', 150);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('17-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (493, 41, '23:00', 150);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('17-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (494, 42, '23:00', 150);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('17-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (495, 43, '23:00', 150);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('24-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (496, 39, '23:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('24-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (497, 40, '23:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('24-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (498, 41, '23:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('24-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (499, 42, '23:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('24-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (500, 43, '23:00',  120);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('02-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (501, 39, '23:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('02-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (502, 40, '23:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('02-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (503, 41, '23:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('02-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (504, 42, '23:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('02-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (505, 43, '23:00',  120);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('09-09-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (506);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (506, 39, '23:00',  120, 10);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('09-09-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (507);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (507, 40, '23:00',  120, 10);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('09-09-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (508);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (508, 41, '23:00',  120, 10);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('09-09-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (509);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (509, 42, '23:00',  120, 10);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('09-09-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (510);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (510, 43, '23:00',  120, 10);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('18-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (511, 39, '23:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('18-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (512, 40, '23:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('18-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (513, 41, '23:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('18-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (514, 42, '23:00',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('18-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (515, 43, '23:00',  120);

--- operacoes do setor 42
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('12-06-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (516, 46, '06:00',60);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('19-06-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (517, 46, '06:00', 60);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('30-06-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (518);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (518, 46, '04:00', 120, 11);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('08-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (519, 46, '04:00', 120);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('15-07-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (520);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (520, 46, '04:00', 120, 10);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('22-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (521, 46, '04:00', 150);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('29-07-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (522);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (522, 46, '04:00', 150, 11);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('05-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (523, 46, '21:30', 120);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('12-08-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (524);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (524, 46, '04:00', 120, 10);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('19-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (525, 46, '21:30', 120);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('26-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (526, 46, '21:30', 120);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('31-08-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (527, 46, '21:30', 120);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('05-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (528, 46, '21:30', 120);



--- resto das operações de rega do setor 41
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('20-05-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (529);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (529, 44, '07:30', 120, 11);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('20-05-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (530);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (530, 45, '07:30', 120, 11);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('02-06-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (531, 44, '07:30', 120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('02-06-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (532, 45, '07:30', 120);


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('09-06-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (533, 44, '06:20',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('09-06-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (534, 45, '06:20',  120);


INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('09-07-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (535);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (535, 44, '06:20',  120, 10);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('09-07-2023','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (536);
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao, MisturaID) VALUES (536, 45, '06:20',  120, 10);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('16-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (537, 44, '06:20',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('16-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (538, 45, '06:20',  120);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('23-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (539, 44, '06:20',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('23-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (540, 45, '06:20',  120);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('30-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (541, 44, '06:20',  120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('30-07-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (542, 45, '06:20',  120);

INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('13-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (543, 44, '07:00', 120);
INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('13-09-2023','DD-MM-YYYY'));
INSERT INTO Rega (OperacaoID, CulturaID, horainicio, duracao) VALUES (544, 45, '07:00', 120);



INSERT INTO operacao(cadernocampoid, datarealizacao) VALUES(  1,  TO_DATE('06-01-2020','DD-MM-YYYY'));
INSERT INTO aplicacaoFator (OperacaoID) VALUES (545);
INSERT INTO AplicacaoFator_FatorProducao(OperacaoID, FatorProducaoID, quantidade, UnidadeDesignacao) VALUES (545, 12, 80, 'kg');
INSERT INTO AFCultura (AplicacaoFatorOperacaoID, CulturaID, ModoAFatorID) VALUES (545, 51,1);
