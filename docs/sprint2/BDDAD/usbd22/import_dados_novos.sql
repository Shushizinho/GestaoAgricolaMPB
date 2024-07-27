INSERT INTO planta(nome, especie, tipo) VALUES ('Abóbora manteiga', 'Cucurbita moschata var Butternut', 'Temporária');
INSERT INTO produtoagricola(nome, plantaid) VALUES ('Abóbora manteiga', 96);

INSERT INTO parcelaAgricola (designacao, area) VALUES ('Campo novo', 1.1);

INSERT INTO fatorproducao(nomecomercial, formulacao, fabricante,fatorproducaotipo,aplicacao) VALUES ('Fertimax Extrume de Cavalo', 'granulado', 'Nutrofertil', 'Abudo', 'Adubo Solo');
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (12,'Matéria orgânica',0.50);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (12,'N',0.03);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (12,'P205',0.008);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (12,'K20',0.004);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (12,'Ca',0.016);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (12,'MgO',0.003);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (12,'B',0.00004);


INSERT INTO fatorproducao(nomecomercial, formulacao, fabricante,fatorproducaotipo,aplicacao) VALUES ('BIOFERTIL N6', 'granulado', 'Nutrofertil', 'Abudo', 'Adubo Solo');
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (13,'Matéria orgânica',0.53);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (13,'N',0.064);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (13,'P205',0.025);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (13,'K20',0.024);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (13,'Ca',0.06);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (13,'MgO',0.003);
INSERT INTO fichatecnica(FatorProducaoID, Nome, quantidade) VALUES (13,'B',0.000020);

INSERT INTO setorDeRega (area, debito, designacao, DataInsercao) VALUES (3.0, 2500,'10',TO_DATE('01-05-2017','DD-MM-YYYY'));

INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio, Data_fim) VALUES (1, 11, TO_DATE('01-05-2017','DD-MM-YYYY'), null);
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio, Data_fim) VALUES (1, 12, TO_DATE('01-05-2017','DD-MM-YYYY'), null);

INSERT INTO setorDeRega(area, debito, designacao, DataInsercao) VALUES (3.0, 1500,'11', TO_DATE('01-05-2017','DD-MM-YYYY'));

INSERT INTO cultura(ParcelaAgricolaID, PlantaID, unidade, quantidade, data_inicio, data_fim) VALUES (2, 86,'un', 40.0, TO_DATE('01-05-2017','DD-MM-YYYY'), null);

INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio, Data_fim) VALUES (2, 27, TO_DATE('01-05-2017','DD-MM-YYYY'), null);


INSERT INTO setorDeRega (area, debito, designacao, DataInsercao) VALUES (1.9, 3500,'21', TO_DATE('01-05-2017','DD-MM-YYYY'));

INSERT INTO cultura(ParcelaAgricolaID, PlantaID, unidade, quantidade, data_inicio, data_fim) VALUES (4, 41,'un', 90.0, TO_DATE('01-05-2017','DD-MM-YYYY'), null);
INSERT INTO cultura(ParcelaAgricolaID, PlantaID, unidade, quantidade, data_inicio, data_fim) VALUES (5, 41,'un', 90.0, TO_DATE('01-05-2017','DD-MM-YYYY'), null);

INSERT INTO cultura(ParcelaAgricolaID, PlantaID, unidade, quantidade, data_inicio, data_fim) VALUES (4, 37,'un', 60.0, TO_DATE('01-05-2017','DD-MM-YYYY'), null);
INSERT INTO cultura(ParcelaAgricolaID, PlantaID, unidade, quantidade, data_inicio, data_fim) VALUES (5, 37,'un', 60.0, TO_DATE('01-05-2017','DD-MM-YYYY'), null);

INSERT INTO cultura(ParcelaAgricolaID, PlantaID, unidade, quantidade, data_inicio, data_fim) VALUES (4, 48,'un', 40.0, TO_DATE('01-05-2017','DD-MM-YYYY'), null);
INSERT INTO cultura(ParcelaAgricolaID, PlantaID, unidade, quantidade, data_inicio, data_fim) VALUES (5, 48,'un', 40.0, TO_DATE('01-05-2017','DD-MM-YYYY'), null);
INSERT INTO cultura(ParcelaAgricolaID, PlantaID, unidade, quantidade, data_inicio, data_fim) VALUES (4, 48,'un', 30.0, TO_DATE('01-05-2019','DD-MM-YYYY'), null);
INSERT INTO cultura(ParcelaAgricolaID, PlantaID, unidade, quantidade, data_inicio, data_fim) VALUES (5, 48,'un', 30.0, TO_DATE('01-05-2019','DD-MM-YYYY'), null);

INSERT INTO cultura(ParcelaAgricolaID, PlantaID, unidade, quantidade, data_inicio, data_fim) VALUES (4, 61,'un', 40.0, TO_DATE('01-05-2019','DD-MM-YYYY'), null);
INSERT INTO cultura(ParcelaAgricolaID, PlantaID, unidade, quantidade, data_inicio, data_fim) VALUES (5, 61,'un', 40.0, TO_DATE('01-05-2019','DD-MM-YYYY'), null);

INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio, Data_fim) VALUES (3, 28, TO_DATE('01-05-2017','DD-MM-YYYY'), null);
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio, Data_fim) VALUES (3, 29, TO_DATE('01-05-2017','DD-MM-YYYY'), null);
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio, Data_fim) VALUES (3, 30, TO_DATE('01-05-2017','DD-MM-YYYY'), null);
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio, Data_fim) VALUES (3, 31, TO_DATE('01-05-2017','DD-MM-YYYY'), null);
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio, Data_fim) VALUES (3, 32, TO_DATE('01-05-2017','DD-MM-YYYY'), null);
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio, Data_fim) VALUES (3, 33, TO_DATE('01-05-2017','DD-MM-YYYY'), null);
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio, Data_fim) VALUES (3, 34, TO_DATE('01-05-2017','DD-MM-YYYY'), null);
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio, Data_fim) VALUES (3, 35, TO_DATE('01-05-2017','DD-MM-YYYY'), null);
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio, Data_fim) VALUES (3, 36, TO_DATE('01-05-2017','DD-MM-YYYY'), null);
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio, Data_fim) VALUES (3, 37, TO_DATE('01-05-2017','DD-MM-YYYY'), null);
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio, Data_fim) VALUES (3, 38, TO_DATE('01-05-2017','DD-MM-YYYY'), null);

INSERT INTO setorDeRega (area, debito, designacao, DataInsercao) VALUES (1.1, 3500,'22', TO_DATE('01-05-2019','DD-MM-YYYY'));

INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio, Data_fim) VALUES (4, 27, TO_DATE('01-05-2019','DD-MM-YYYY'), null);
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio, Data_fim) VALUES (4, 28, TO_DATE('01-05-2019','DD-MM-YYYY'), null);
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio, Data_fim) VALUES (4, 30, TO_DATE('01-05-2019','DD-MM-YYYY'), null);
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio, Data_fim) VALUES (4, 31, TO_DATE('01-05-2019','DD-MM-YYYY'), null);
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio, Data_fim) VALUES (4, 32, TO_DATE('01-05-2019','DD-MM-YYYY'), null);

INSERT INTO cultura(ParcelaAgricolaID, PlantaID, unidade, quantidade, data_inicio, data_fim) VALUES (5, 44,'un', 50.0, TO_DATE('01-05-2019','DD-MM-YYYY'), null);

INSERT INTO cultura(ParcelaAgricolaID, PlantaID, unidade, quantidade, data_inicio, data_fim) VALUES (5, 56,'un', 20.0, TO_DATE('01-05-2019','DD-MM-YYYY'), null);

INSERT INTO planta(nome, especie, tipo) VALUES ('Macieira canada', 'Malus domestica', 'Permanente');
INSERT INTO cultura(ParcelaAgricolaID, PlantaID, unidade, quantidade, data_inicio, data_fim) VALUES (5, 97,'un', 30.0, TO_DATE('01-05-2019','DD-MM-YYYY'), null);

INSERT INTO planta(nome, especie, tipo) VALUES ('Macieira grand fay', 'Malus domestica', 'Permanente');
INSERT INTO cultura(ParcelaAgricolaID, PlantaID, unidade, quantidade, data_inicio, data_fim) VALUES (5, 98,'un', 40.0, TO_DATE('01-05-2019','DD-MM-YYYY'), null);

INSERT INTO cultura(ParcelaAgricolaID, PlantaID, unidade, quantidade, data_inicio, data_fim) VALUES (5, 57,'un', 50.0, TO_DATE('01-05-2019','DD-MM-YYYY'), null);


INSERT INTO setorDeRega (area, debito, designacao, DataInsercao) VALUES (1.1, 2500,'41', TO_DATE('01-04-2023','DD-MM-YYYY'));

INSERT INTO cultura(ParcelaAgricolaID, PlantaID, unidade, quantidade, data_inicio, data_fim) VALUES (8, 77, 'ha', 0.5, TO_DATE('05-04-2023','DD-MM-YYYY'), TO_DATE('31-05-2023','DD-MM-YYYY'));

INSERT INTO cultura(ParcelaAgricolaID, PlantaID, unidade, quantidade, data_inicio, data_fim) VALUES (8, 75, 'ha', 0.5, TO_DATE('05-07-2022','DD-MM-YYYY'), TO_DATE('08-10-2023','DD-MM-YYYY'));

INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio, Data_fim) VALUES (5, 38, TO_DATE('01-04-2023','DD-MM-YYYY'), TO_DATE('10-10-2023','DD-MM-YYYY'));
INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio, Data_fim) VALUES (5, 39, TO_DATE('01-04-2023','DD-MM-YYYY'), TO_DATE('10-10-2023','DD-MM-YYYY'));

INSERT INTO setorDeRega (area, debito, designacao, DataInsercao) VALUES (1.1, 3500,'42',  TO_DATE('01-04-2023','DD-MM-YYYY'));

INSERT INTO cultura(ParcelaAgricolaID, PlantaID, unidade, quantidade, data_inicio, data_fim) VALUES (8, 96, 'ha', 0.6, TO_DATE('06-04-2023','DD-MM-YYYY'), TO_DATE('10-09-2023','DD-MM-YYYY'));

INSERT INTO SetorDeRegaCultura (SetorDeRegaID, CulturaID, Data_Inicio, Data_fim) VALUES (6, 40, TO_DATE('01-04-2023','DD-MM-YYYY'), TO_DATE('10-10-2023','DD-MM-YYYY'));

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Rega', 1,  TO_DATE('14-05-2023','DD-MM-YYYY'), 120, 'min', null, 4);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES (353 , '07:00', '9:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Rega', 1,  TO_DATE('01-06-2023','DD-MM-YYYY'), 120, 'min', null, 4);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES (354, '07:00', '9:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Rega', 1,  TO_DATE('15-06-2023','DD-MM-YYYY'), 120, 'min', null, 4);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES (355 , '07:00', '9:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Rega', 1,  TO_DATE('30-06-2023','DD-MM-YYYY'), 120, 'min', null, 4);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES (356 , '07:00', '9:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Rega', 1,  TO_DATE('07-07-2023','DD-MM-YYYY'), 180, 'min', null, 4);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES (357 , '07:00', '10:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Rega', 1,  TO_DATE('14-07-2023','DD-MM-YYYY'), 180, 'min', null, 4);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES (358 , '22:00', '01:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Rega', 1,  TO_DATE('21-07-2023','DD-MM-YYYY'), 180, 'min', null, 4);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES (359 , '22:00', '01:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Rega', 1,  TO_DATE('28-07-2023','DD-MM-YYYY'), 180, 'min', null, 4);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES (360 , '22:00', '01:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Rega', 1,  TO_DATE('04-08-2023','DD-MM-YYYY'), 150, 'min', null, 4);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES (361, '22:00', '00:30');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Rega', 1,  TO_DATE('11-08-2023','DD-MM-YYYY'), 150, 'min', null, 4);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES (362 , '22:00', '00:30');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Rega', 1,  TO_DATE('18-08-2023','DD-MM-YYYY'), 150, 'min', null, 4);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES (363 , '22:00', '00:30');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Rega', 1,  TO_DATE('25-08-2023','DD-MM-YYYY'), 120, 'min', null, 4);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES (364, '22:00', '00:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Rega', 1,  TO_DATE('01-09-2023','DD-MM-YYYY'),120, 'min', null, 4);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES (365, '22:00', '00:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Rega', 1,  TO_DATE('08-09-2023','DD-MM-YYYY'), 120, 'min', null, 4);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES (366, '22:00', '00:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Rega', 1,  TO_DATE('15-09-2023','DD-MM-YYYY'),120, 'min', null, 4);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES (367, '22:00', '00:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Colheita', 1,  TO_DATE('18-08-2023','DD-MM-YYYY'), 700, 'kg',24 ,4);

INSERT INTO RecolhaProduto (OperacaoAgricolaID, ProdutoAgricolaID, QuantidadeProduto, UnidadeProduto) VALUES (368, 48, 700, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Colheita', 1,  TO_DATE('30-08-2023','DD-MM-YYYY'), 900, 'kg',24, 4);

INSERT INTO RecolhaProduto (OperacaoAgricolaID, ProdutoAgricolaID, QuantidadeProduto, UnidadeProduto) VALUES (369, 48, 900, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Colheita', 1,  TO_DATE('05-09-2023','DD-MM-YYYY'), 900, 'kg', 22,4);

INSERT INTO RecolhaProduto (OperacaoAgricolaID, ProdutoAgricolaID, QuantidadeProduto, UnidadeProduto) VALUES (370, 41, 900, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Colheita', 1,  TO_DATE('08-09-2023','DD-MM-YYYY'), 1050, 'kg',22,4);

INSERT INTO RecolhaProduto (OperacaoAgricolaID, ProdutoAgricolaID, QuantidadeProduto, UnidadeProduto) VALUES (371, 41, 1050, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Colheita', 1,  TO_DATE('28-09-2023','DD-MM-YYYY'), 950, 'kg', 23,4);

INSERT INTO RecolhaProduto (OperacaoAgricolaID, ProdutoAgricolaID, QuantidadeProduto, UnidadeProduto) VALUES (372, 37, 950, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Colheita', 1,  TO_DATE('03-10-2023','DD-MM-YYYY'), 800, 'kg', 23,4);

INSERT INTO RecolhaProduto (OperacaoAgricolaID, ProdutoAgricolaID, QuantidadeProduto, UnidadeProduto) VALUES (373, 37, 800, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('04-01-2019','DD-MM-YYYY'), 3200, 'kg', null, 5);

INSERT INTO aplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (374, 13,'Adubo solo', 3200, 'kg');

INSERT INTO cultura(ParcelaAgricolaID, PlantaID, unidade, quantidade, data_inicio, data_fim) VALUES (5, 44,'un', 50, TO_DATE('09-01-2019','DD-MM-YYYY'), null);
INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Plantação', 1,  TO_DATE('09-01-2019','DD-MM-YYYY'), 50,'un', 39, 5);

INSERT INTO cultura(ParcelaAgricolaID, PlantaID, unidade, quantidade, data_inicio, data_fim) VALUES (5, 56,'un', 20, TO_DATE('09-01-2019','DD-MM-YYYY'), null);
INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Plantação', 1,  TO_DATE('09-01-2019','DD-MM-YYYY'), 20,'un', 40, 5);

INSERT INTO cultura(ParcelaAgricolaID, PlantaID, unidade, quantidade, data_inicio, data_fim) VALUES (5, 61,'un', 40, TO_DATE('09-01-2019','DD-MM-YYYY'), null);
INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Plantação', 1,  TO_DATE('10-01-2019','DD-MM-YYYY'), 40,'un', 38, 5);

INSERT INTO cultura(ParcelaAgricolaID, PlantaID, unidade, quantidade, data_inicio, data_fim) VALUES (5, 45,'un', 30, TO_DATE('10-01-2019','DD-MM-YYYY'), null);
INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Plantação', 1,  TO_DATE('10-01-2019','DD-MM-YYYY'), 30,'un', 41, 5);

INSERT INTO cultura(ParcelaAgricolaID, PlantaID, unidade, quantidade, data_inicio, data_fim) VALUES (5, 98,'un', 40, TO_DATE('11-01-2019','DD-MM-YYYY'), null);
INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Plantação', 1,  TO_DATE('11-01-2019','DD-MM-YYYY'), 40,'un', 42, 5);

INSERT INTO cultura(ParcelaAgricolaID, PlantaID, unidade, quantidade, data_inicio, data_fim) VALUES (5, 57,'un', 50, TO_DATE('11-01-2019','DD-MM-YYYY'), null);
INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Plantação', 1,  TO_DATE('11-01-2019','DD-MM-YYYY'), 50,'un', 43, 5);

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('06-01-2020','DD-MM-YYYY'), 1.1, 'ha', 39, 5);
INSERT INTO AplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (381, 12,'Adubo solo', 100, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('06-01-2020','DD-MM-YYYY'), 1.1, 'ha', 40, 5);
INSERT INTO AplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (382, 12,'Adubo solo', 40, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('06-01-2020','DD-MM-YYYY'), 1.1, 'ha', 38, 5);
INSERT INTO AplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (383, 12,'Adubo solo', 80, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('06-01-2020','DD-MM-YYYY'), 1.1, 'ha', 41, 5);
INSERT INTO AplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (384, 12,'Adubo solo', 60, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('06-01-2020','DD-MM-YYYY'), 1.1, 'ha', 42, 5);
INSERT INTO AplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (385, 12,'Adubo solo', 80, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('07-01-2020','DD-MM-YYYY'), 1.1, 'ha', 43, 5);
INSERT INTO AplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (386, 12,'Adubo solo', 100, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('07-01-2020','DD-MM-YYYY'), 1.1, 'ha', 39, 5);
INSERT INTO AplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (387, 12,'Adubo solo', 150, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('07-01-2021','DD-MM-YYYY'), 1.1, 'ha', 40, 5);
INSERT INTO AplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (388, 12,'Adubo solo', 60, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('08-01-2021','DD-MM-YYYY'), 1.1, 'ha', 38, 5);
INSERT INTO AplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (389, 12,'Adubo solo', 120, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('07-01-2021','DD-MM-YYYY'), 1.1, 'ha', 41, 5);
INSERT INTO AplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (390, 12,'Adubo solo', 90, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('07-01-2021','DD-MM-YYYY'), 1.1, 'ha', 42, 5);
INSERT INTO AplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (391, 12,'Adubo solo', 120, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('07-01-2021','DD-MM-YYYY'), 1.1, 'ha', 43, 5);
INSERT INTO AplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (392, 12,'Adubo solo', 150, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('15-01-2022','DD-MM-YYYY'), 1.1, 'ha', 39, 5);
INSERT INTO AplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (393, 13,'Adubo solo', 150, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('15-01-2022','DD-MM-YYYY'), 1.1, 'ha', 40, 5);
INSERT INTO AplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (394, 13,'Adubo solo', 60, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('15-01-2022','DD-MM-YYYY'), 1.1, 'ha', 38, 5);
INSERT INTO AplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (395, 13,'Adubo solo', 120, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('16-01-2022','DD-MM-YYYY'), 1.1, 'ha', 41, 5);
INSERT INTO AplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (396, 13,'Adubo solo', 90, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('16-01-2022','DD-MM-YYYY'), 1.1, 'ha', 42, 5);
INSERT INTO AplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (397, 13,'Adubo solo', 120, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('16-01-2022','DD-MM-YYYY'), 1.1, 'ha', 43, 5);
INSERT INTO AplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (398, 13,'Adubo solo', 150, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('15-05-2022','DD-MM-YYYY'), 1.1, 'ha', 39, 5);
INSERT INTO aplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (399, 5, 'Foliar', 5, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('15-05-2022','DD-MM-YYYY'), 1.1, 'ha', 40, 5);
INSERT INTO aplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (400, 5, 'Foliar', 2, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('15-05-2023','DD-MM-YYYY'), 1.1, 'ha', 38, 5);
INSERT INTO aplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (401, 5, 'Foliar', 4, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('15-05-2023','DD-MM-YYYY'), 1.1, 'ha', 41, 5);
INSERT INTO aplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (402, 5, 'Foliar', 3, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('15-05-2023','DD-MM-YYYY'), 1.1, 'ha', 42, 5);
INSERT INTO aplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (403, 5, 'Foliar', 4, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('15-05-2023','DD-MM-YYYY'), 1.1, 'ha', 43, 5);
INSERT INTO aplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (404, 5, 'Foliar', 5, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Colheita', 1,  TO_DATE('15-09-2023','DD-MM-YYYY'), 700, 'kg', 41,5);

INSERT INTO RecolhaProduto (OperacaoAgricolaID, ProdutoAgricolaID, QuantidadeProduto, UnidadeProduto) VALUES (405, 41, 700, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Colheita', 1,  TO_DATE('16-09-2023','DD-MM-YYYY'), 600, 'kg', 42,5);

INSERT INTO RecolhaProduto (OperacaoAgricolaID, ProdutoAgricolaID, QuantidadeProduto, UnidadeProduto) VALUES (406, 38, 600, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Colheita', 1,  TO_DATE('20-09-2023','DD-MM-YYYY'), 700, 'kg', 42,5);

INSERT INTO RecolhaProduto (OperacaoAgricolaID, ProdutoAgricolaID, QuantidadeProduto, UnidadeProduto) VALUES (407, 38, 700, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Colheita', 1,  TO_DATE('27-09-2023','DD-MM-YYYY'), 600, 'kg', 38,5);

INSERT INTO RecolhaProduto (OperacaoAgricolaID, ProdutoAgricolaID, QuantidadeProduto, UnidadeProduto) VALUES (408, 61, 600, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Colheita', 1,  TO_DATE('05-10-2023','DD-MM-YYYY'), 700, 'kg', 38,5);

INSERT INTO RecolhaProduto (OperacaoAgricolaID, ProdutoAgricolaID, QuantidadeProduto, UnidadeProduto) VALUES (409, 61, 700, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Colheita', 1,  TO_DATE('15-10-2023','DD-MM-YYYY'), 1200, 'kg', 42,5);

INSERT INTO RecolhaProduto (OperacaoAgricolaID, ProdutoAgricolaID, QuantidadeProduto, UnidadeProduto) VALUES (410, 52, 1200, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Colheita', 1,  TO_DATE('15-10-2023','DD-MM-YYYY'), 700, 'kg', 40,5);

INSERT INTO RecolhaProduto (OperacaoAgricolaID, ProdutoAgricolaID, QuantidadeProduto, UnidadeProduto) VALUES (411, 40, 700, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Colheita', 1,  TO_DATE('12-11-2023','DD-MM-YYYY'), 700, 'kg', 39,5);

INSERT INTO RecolhaProduto (OperacaoAgricolaID, ProdutoAgricolaID, QuantidadeProduto, UnidadeProduto) VALUES (412, 44, 700, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Colheita', 1,  TO_DATE('15-11-2023','DD-MM-YYYY'), 800, 'kg', 39,5);

INSERT INTO RecolhaProduto (OperacaoAgricolaID, ProdutoAgricolaID, QuantidadeProduto, UnidadeProduto) VALUES (413, 44, 800, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('13-05-2023','DD-MM-YYYY'), 120, 'min', null, 5);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(414, '23:00', '01:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('02-06-2023','DD-MM-YYYY'), 120, 'min', null, 5);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(415, '23:00', '01:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('16-05-2023','DD-MM-YYYY'), 120, 'min', null, 5);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(416, '23:00', '01:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('01-07-2023','DD-MM-YYYY'), 120, 'min', null, 5);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(417, '23:00', '01:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('08-07-2023','DD-MM-YYYY'), 180, 'min', null, 5);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(418, '23:00', '02:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('15-07-2023','DD-MM-YYYY'), 180, 'min', null, 5);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(419, '23:00', '02:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('22-07-2023','DD-MM-YYYY'), 180, 'min', null, 5);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(420, '23:00', '02:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('29-07-2023','DD-MM-YYYY'), 180, 'min', null, 5);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(421, '23:00', '02:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('05-08-2023','DD-MM-YYYY'), 150, 'min', null, 5);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(422, '23:00', '01:30');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('10-08-2023','DD-MM-YYYY'), 150, 'min', null, 5);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(423, '23:00', '01:30');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('17-08-2023','DD-MM-YYYY'), 150, 'min', null, 5);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(424, '23:00', '01:30');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('24-08-2023','DD-MM-YYYY'), 120, 'min', null, 5);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(425, '23:00', '01:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('02-09-2023','DD-MM-YYYY'), 120, 'min', null, 5);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(426, '23:00', '01:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('09-09-2023','DD-MM-YYYY'), 120, 'min', null, 5);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(427, '23:00', '01:00');


INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('18-09-2023','DD-MM-YYYY'),120, 'min', null, 5);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(428, '23:00', '01:00');

INSERT INTO cultura(ParcelaAgricolaID, PlantaID, unidade, quantidade, data_inicio, data_fim) VALUES (2, 86, 'ha', 3.0 , TO_DATE('12-10-2016','DD-MM-YYYY'), null);
INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Plantação', 1,  TO_DATE('12-10-2016','DD-MM-YYYY'), 40,'un', 28, 2);

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('13-01-2021','DD-MM-YYYY'), 3.0, 'ha', 12, 5);
INSERT INTO AplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (430, 13,'Adubo solo', 120, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('12-01-2021','DD-MM-YYYY'), 3.0, 'ha', 11, 5);
INSERT INTO AplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (431, 13,'Adubo solo', 180, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('12-01-2021','DD-MM-YYYY'), 3.0, 'ha', 28, 5);
INSERT INTO AplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (432, 13,'Adubo solo', 240, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('12-01-2022','DD-MM-YYYY'), 3.0, 'ha', 12, 5);
INSERT INTO AplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (433, 13,'Adubo solo', 120, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('12-01-2022','DD-MM-YYYY'), 3.0, 'ha', 11, 5);
INSERT INTO AplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (434, 13,'Adubo solo', 180, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('13-01-2022','DD-MM-YYYY'), 3.0, 'ha', 28, 5);
INSERT INTO AplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (435, 13,'Adubo solo', 240, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('12-01-2023','DD-MM-YYYY'), 3.0, 'ha', 12, 5);
INSERT INTO AplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (436, 13,'Adubo solo', 120, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('12-01-2023','DD-MM-YYYY'), 3.0, 'ha', 11, 5);
INSERT INTO AplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (437, 13,'Adubo solo', 180, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('12-01-2023','DD-MM-YYYY'), 3.0, 'ha', 28, 5);
INSERT INTO AplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (438, 13,'Adubo solo', 240, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Colheita', 1,  TO_DATE('02-11-2023','DD-MM-YYYY'), 400, 'kg', 28,5);

INSERT INTO RecolhaProduto (OperacaoAgricolaID, ProdutoAgricolaID, QuantidadeProduto, UnidadeProduto) VALUES (439, 86, 400, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Colheita', 1,  TO_DATE('05-11-2023','DD-MM-YYYY'), 300, 'kg', 12,5);

INSERT INTO RecolhaProduto (OperacaoAgricolaID, ProdutoAgricolaID, QuantidadeProduto, UnidadeProduto) VALUES (440, 89, 300, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Colheita', 1,  TO_DATE('08-11-2023','DD-MM-YYYY'), 350, 'kg', 11,5);

INSERT INTO RecolhaProduto (OperacaoAgricolaID, ProdutoAgricolaID, QuantidadeProduto, UnidadeProduto) VALUES (441, 92, 350, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Rega', 1,  TO_DATE('02-06-2023','DD-MM-YYYY'), 60, 'min', null, 2);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES (442, '06:00', '07:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Rega', 1,  TO_DATE('02-07-2023','DD-MM-YYYY'), 120, 'min', null, 2);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES (443, '06:00', '08:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Rega', 1,  TO_DATE('02-08-2023','DD-MM-YYYY'), 180, 'min', null, 2);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES (444, '05:00', '08:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Rega', 1,  TO_DATE('04-09-2023','DD-MM-YYYY'), 120, 'min', null, 2);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES (445, '06:00', '08:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Rega', 1,  TO_DATE('02-10-2023','DD-MM-YYYY'), 60, 'min', null, 2);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES (446, '06:00', '07:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('01-04-2023','DD-MM-YYYY'), 1.1, 'ha', null, 8);
INSERT INTO AplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (447, 8,'Adubo solo', 500, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Sementeira', 1,  TO_DATE('05-04-2023','DD-MM-YYYY'), 1.2, 'kg', 44, 8);

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Sementeira', 1,  TO_DATE('06-04-2023','DD-MM-YYYY'), 1.5, 'kg', 46, 8);

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Monda', 1,  TO_DATE('08-05-2023','DD-MM-YYYY'), 0.5, 'ha', 44, 8);
INSERT INTO monda (OperacaoAgricolaID, TipoMonda) VALUES (450, 'Mecânica');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Monda', 1,  TO_DATE('20-05-2023','DD-MM-YYYY'), 0.6, 'ha', 46, 8);
INSERT INTO monda (OperacaoAgricolaID, TipoMonda) VALUES (451, 'Mecânica');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Colheita', 1,  TO_DATE('14-06-2023','DD-MM-YYYY'), 1500, 'kg', 44,8);
INSERT INTO RecolhaProduto (OperacaoAgricolaID, ProdutoAgricolaID, QuantidadeProduto, UnidadeProduto) VALUES (452, 77, 1500, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Monda', 1,  TO_DATE('20-06-2023','DD-MM-YYYY'), 0.6, 'ha', 46, 8);
INSERT INTO monda (OperacaoAgricolaID, TipoMonda) VALUES (453, 'Mecânica');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Colheita', 1,  TO_DATE('28-06-2023','DD-MM-YYYY'), 2500, 'kg', 44,8);
INSERT INTO RecolhaProduto (OperacaoAgricolaID, ProdutoAgricolaID, QuantidadeProduto, UnidadeProduto) VALUES (454, 77, 2500, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Fertilização', 1,  TO_DATE('03-07-2023','DD-MM-YYYY'), 1.1, 'ha', null, 8);
INSERT INTO AplicacaoFator (OperacaoAgricolaID, FatorProducaoID, Modo, QuantidadeFator, UnidadeFator) VALUES (455, 12,'Adubo solo', 500, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Mobilização do solo', 1,  TO_DATE('04-07-2023','DD-MM-YYYY'), 0.5, 'ha', null, 8);

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Sementeira', 1,  TO_DATE('05-07-2023','DD-MM-YYYY'), 1.2, 'kg', 45, 8);


INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Monda', 1,  TO_DATE('08-08-2023','DD-MM-YYYY'), 0.5, 'ha', 45, 8);
INSERT INTO monda (OperacaoAgricolaID, TipoMonda) VALUES (458, 'Mecânica');


INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Colheita', 1,  TO_DATE('15-09-2023','DD-MM-YYYY'), 8000, 'kg', 46,8);
INSERT INTO RecolhaProduto (OperacaoAgricolaID, ProdutoAgricolaID, QuantidadeProduto, UnidadeProduto) VALUES (459, 96, 8000, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Colheita', 1,  TO_DATE('25-09-2023','DD-MM-YYYY'), 5000, 'kg', 46,8);
INSERT INTO RecolhaProduto (OperacaoAgricolaID, ProdutoAgricolaID, QuantidadeProduto, UnidadeProduto) VALUES (460, 96, 5000, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Colheita', 1,  TO_DATE('18-09-2023','DD-MM-YYYY'), 900, 'kg', 45,8);
INSERT INTO RecolhaProduto (OperacaoAgricolaID, ProdutoAgricolaID, QuantidadeProduto, UnidadeProduto) VALUES (461, 75, 900, 'kg');


INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Colheita', 1,  TO_DATE('22-09-2023','DD-MM-YYYY'), 1500, 'kg', 45,8);
INSERT INTO RecolhaProduto (OperacaoAgricolaID, ProdutoAgricolaID, QuantidadeProduto, UnidadeProduto) VALUES (462, 75, 1500, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Colheita', 1,  TO_DATE('05-10-2023','DD-MM-YYYY'), 1200, 'kg', 45,8);
INSERT INTO RecolhaProduto (OperacaoAgricolaID, ProdutoAgricolaID, QuantidadeProduto, UnidadeProduto) VALUES (463, 75, 1200, 'kg');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Mobilização do solo', 1,  TO_DATE('10-10-2023','DD-MM-YYYY'), 1.1, 'ha', null, 8);

INSERT INTO cultura(ParcelaAgricolaID, PlantaID, unidade, quantidade, data_inicio, data_fim) VALUES (8, 80, 'ha', 1.1, TO_DATE('09-01-2019','DD-MM-YYYY'), null);
INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES( 'Sementeira', 1,  TO_DATE('12-10-2019','DD-MM-YYYY'), 32, 'kg', 54, 8);


INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('12-06-2023','DD-MM-YYYY'), 60, 'min', null, 8);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(466, '06:00', '07:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('19-06-2023','DD-MM-YYYY'), 60, 'min', null, 8);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(467, '06:00', '07:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('30-06-2023','DD-MM-YYYY'), 120, 'min', null, 8);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(468, '04:00', '06:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('08-07-2023','DD-MM-YYYY'), 120, 'min', null, 8);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(469, '04:00', '06:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('15-07-2023','DD-MM-YYYY'),120, 'min', null, 8);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(470, '04:00', '06:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('22-07-2023','DD-MM-YYYY'),150, 'min', null, 8);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(471, '04:00', '06:30');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('29-07-2023','DD-MM-YYYY'), 150, 'min', null, 8);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(472, '04:00', '06:30');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('05-08-2023','DD-MM-YYYY'), 120, 'min', null, 8);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(473, '21:30', '23:30');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('12-08-2023','DD-MM-YYYY'), 120, 'min', null, 8);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(474, '21:30', '23:30');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('19-08-2023','DD-MM-YYYY'),120, 'min', null, 8);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(475, '21:30', '23:30');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('26-08-2023','DD-MM-YYYY'), 120, 'min', null, 8);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(476, '21:30', '23:30');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('31-08-2023','DD-MM-YYYY'), 120, 'min', null, 8);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(477, '21:30', '23:30');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('05-09-2023','DD-MM-YYYY'),120, 'min', null, 8);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(478, '21:30', '23:30');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('20-05-2023','DD-MM-YYYY'), 120, 'min', null, 8);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(479, '07:30', '09:30');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('02-06-2023','DD-MM-YYYY'), 120, 'min', null, 8);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(480, '07:30', '09:30');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('09-06-2023','DD-MM-YYYY'), 120, 'min', null, 8);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(481, '06:20', '08:20');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('09-07-2023','DD-MM-YYYY'), 120, 'min', null, 8);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(482, '06:20', '08:20');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('16-07-2023','DD-MM-YYYY'), 120, 'min', null, 8);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(483, '06:20', '08:20');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('23-07-2023','DD-MM-YYYY'), 120, 'min', null, 8);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(484, '06:20', '08:20');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('30-07-2023','DD-MM-YYYY'), 120, 'min', null, 8);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(485, '06:20', '08:20');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('07-08-2023','DD-MM-YYYY'), 120, 'min', null, 8);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(486, '06:20', '08:20');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('14-08-2023','DD-MM-YYYY'), 120, 'min', null, 8);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(487, '06:20', '08:20');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('21-08-2023','DD-MM-YYYY'), 120, 'min', null, 8);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(488, '06:20', '08:20');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('28-08-2023','DD-MM-YYYY'), 120, 'min', null, 8);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(489, '06:20', '08:20');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('06-09-2023','DD-MM-YYYY'),120, 'min', null, 8);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(490, '06:20', '08:20');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('13-09-2023','DD-MM-YYYY'), 120, 'min', null, 8);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(491, '07:00', '09:00');

INSERT INTO operacaoagricola(tipooperacao, cadernocampoid, datarealizacao, quantidade, unidadedesignacao, culturaid, ParcelaAgricolaID) VALUES('Rega', 1, TO_DATE('20-09-2023','DD-MM-YYYY'), 120, 'min', null, 8);
INSERT INTO Rega (OperacaoAgricolaID, horainicio, horafim) VALUES(492, '07:00', '09:00');