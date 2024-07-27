CREATE TABLE EstacaoMeteorologica (
  ID number(10) GENERATED AS IDENTITY,
  PRIMARY KEY (ID));
CREATE TABLE OperacaoAgricola (
  ID                number(10) GENERATED AS IDENTITY,
  TipoOperacao      varchar2(255) NOT NULL,
  CadernoCampoID    number(10) NOT NULL,
  DataRealizacao    date NOT NULL,
  Quantidade        number(12, 2),
  Unidadedesignacao varchar2(10),
  CulturaID         number(10),
  ParcelaAgricolaID number(10) NOT NULL,
  PRIMARY KEY (ID));
CREATE TABLE CadernoCampo (
  ID   number(10) GENERATED AS IDENTITY,
  nome varchar2(255) NOT NULL,
  PRIMARY KEY (ID));
CREATE TABLE FichaTecnica (
  Nome            varchar2(255) NOT NULL,
  FatorProducaoID number(10) NOT NULL,
  quantidade      number(12, 6) NOT NULL,
  PRIMARY KEY (Nome,
  FatorProducaoID));
CREATE TABLE FatorProducao (
  ID                number(10) GENERATED AS IDENTITY,
  NomeComercial     varchar2(255) NOT NULL,
  Formulacao        varchar2(255) NOT NULL,
  Fabricante        varchar2(255) NOT NULL,
  FatorProducaoTipo varchar2(255) NOT NULL,
  Aplicacao         varchar2(255) NOT NULL,
  PRIMARY KEY (ID));
CREATE TABLE Planta (
  ID      number(10) GENERATED AS IDENTITY,
  Especie varchar2(255) NOT NULL,
  Nome    varchar2(255) NOT NULL,
  Tipo    varchar2(255) NOT NULL,
  PRIMARY KEY (ID));
CREATE TABLE RecolhaProduto (
  OperacaoAgricolaID number(10) NOT NULL,
  ProdutoAgricolaID  number(10) NOT NULL,
  QuantidadeProduto  number(12, 2) NOT NULL,
  UnidadeProduto     varchar2(10) NOT NULL,
  PRIMARY KEY (OperacaoAgricolaID));
CREATE TABLE ParcelaAgricola (
  ID         number(10) GENERATED AS IDENTITY,
  Designacao varchar2(255) NOT NULL,
  Area       number(12, 2) NOT NULL,
  PRIMARY KEY (ID));
CREATE TABLE Sensor (
  ID                     number(10) GENERATED AS IDENTITY,
  Marca                  varchar2(255) NOT NULL,
  Modelo                 varchar2(255) NOT NULL,
  TipoSensor             varchar2(255) NOT NULL,
  TipoLeitura            varchar2(255) NOT NULL,
  EstacaoMeteorologicaID number(10) NOT NULL,
  PRIMARY KEY (ID));
CREATE TABLE PlanoDeRega (
  ID                number(10) GENERATED AS IDENTITY,
  HorasRega         varchar2(255) NOT NULL,
  Duração           number(10) NOT NULL,
  Regularidade      varchar2(255) NOT NULL,
  ParcelaAgricolaID number(10) NOT NULL,
  PRIMARY KEY (ID));
CREATE TABLE LeituraSensor (
  ID                            number(10) GENERATED AS IDENTITY,
  SensorID                      number(10) NOT NULL,
  Valor                         number(10) NOT NULL,
  Hora                          varchar2(255) NOT NULL,
  PlanoDeRegaOperacaoAgricolaID number(10) NOT NULL,
  CadernoCampoID                number(10) NOT NULL,
  PRIMARY KEY (ID));
CREATE TABLE Cultura (
  ID                number(10) GENERATED AS IDENTITY,
  ParcelaAgricolaID number(10) NOT NULL,
  PlantaID          number(10) NOT NULL,
  unidade           varchar2(10) NOT NULL,
  quantidade        number(12, 2),
  Data_Inicio       date NOT NULL,
  Data_Fim          date,
  PRIMARY KEY (ID));
CREATE TABLE Fertilizacao (
  TipoFertilizacao varchar2(255) NOT NULL);
CREATE TABLE Unidade (
  designacao varchar2(10) NOT NULL,
  PRIMARY KEY (designacao));
CREATE TABLE SetorDeRega (
  ID           number(10) GENERATED AS IDENTITY,
  debito       number(12, 2) NOT NULL,
  area         number(12, 2) NOT NULL,
  designacao   varchar2(255) NOT NULL,
  DataInsercao date NOT NULL,
  PRIMARY KEY (ID));
CREATE TABLE SetorDeRegaCultura (
  SetorDeRegaID number(10) NOT NULL,
  CulturaID     number(10) NOT NULL,
  Data_Inicio   date NOT NULL,
  Data_fim      date,
  PRIMARY KEY (SetorDeRegaID,
  CulturaID));
CREATE TABLE Rega (
  OperacaoAgricolaID number(10) NOT NULL,
  horainicio         varchar2(255) NOT NULL,
  horafim            varchar2(255) NOT NULL,
  PRIMARY KEY (OperacaoAgricolaID));
CREATE TABLE EstadoFenologico (
  Estado    varchar2(255) NOT NULL,
  CulturaID number(10) NOT NULL);
CREATE TABLE AplicacaoFator (
  OperacaoAgricolaID number(10) NOT NULL,
  FatorProducaoID    number(10) NOT NULL,
  Modo               varchar2(255),
  QuantidadeFator    number(12, 2) NOT NULL,
  UnidadeFator       varchar2(10) NOT NULL,
  PRIMARY KEY (OperacaoAgricolaID));
CREATE TABLE ProdutoAgricola (
  ID       number(10) GENERATED AS IDENTITY,
  Nome     varchar2(255) NOT NULL,
  PlantaID number(10) NOT NULL,
  PRIMARY KEY (ID));
CREATE TABLE Monda (
  OperacaoAgricolaID number(10) NOT NULL,
  TipoMonda          varchar2(255),
  PRIMARY KEY (OperacaoAgricolaID));
ALTER TABLE OperacaoAgricola ADD CONSTRAINT FKOperacaoAg555764 FOREIGN KEY (CadernoCampoID) REFERENCES CadernoCampo (ID);
ALTER TABLE FichaTecnica ADD CONSTRAINT FKFichaTecni212783 FOREIGN KEY (FatorProducaoID) REFERENCES FatorProducao (ID);
ALTER TABLE RecolhaProduto ADD CONSTRAINT FKRecolhaPro361002 FOREIGN KEY (OperacaoAgricolaID) REFERENCES OperacaoAgricola (ID);
ALTER TABLE PlanoDeRega ADD CONSTRAINT FKPlanoDeReg955264 FOREIGN KEY (ParcelaAgricolaID) REFERENCES ParcelaAgricola (ID);
ALTER TABLE LeituraSensor ADD CONSTRAINT FKLeituraSen432202 FOREIGN KEY (PlanoDeRegaOperacaoAgricolaID) REFERENCES PlanoDeRega (ID);
ALTER TABLE LeituraSensor ADD CONSTRAINT FKLeituraSen784537 FOREIGN KEY (SensorID) REFERENCES Sensor (ID);
ALTER TABLE Cultura ADD CONSTRAINT FKCultura477867 FOREIGN KEY (ParcelaAgricolaID) REFERENCES ParcelaAgricola (ID);
ALTER TABLE Cultura ADD CONSTRAINT FKCultura545688 FOREIGN KEY (PlantaID) REFERENCES Planta (ID);
ALTER TABLE Sensor ADD CONSTRAINT FKSensor673641 FOREIGN KEY (EstacaoMeteorologicaID) REFERENCES EstacaoMeteorologica (ID);
ALTER TABLE Cultura ADD CONSTRAINT FKCultura265899 FOREIGN KEY (unidade) REFERENCES Unidade (designacao);
ALTER TABLE OperacaoAgricola ADD CONSTRAINT FKOperacaoAg931061 FOREIGN KEY (CulturaID) REFERENCES Cultura (ID);
ALTER TABLE SetorDeRegaCultura ADD CONSTRAINT FKSetorDeReg38608 FOREIGN KEY (CulturaID) REFERENCES Cultura (ID);
ALTER TABLE SetorDeRegaCultura ADD CONSTRAINT FKSetorDeReg968245 FOREIGN KEY (SetorDeRegaID) REFERENCES SetorDeRega (ID);
ALTER TABLE OperacaoAgricola ADD CONSTRAINT FKOperacaoAg114903 FOREIGN KEY (Unidadedesignacao) REFERENCES Unidade (designacao);
ALTER TABLE EstadoFenologico ADD CONSTRAINT FKEstadoFeno734588 FOREIGN KEY (CulturaID) REFERENCES Cultura (ID);
ALTER TABLE Rega ADD CONSTRAINT FKRega697915 FOREIGN KEY (OperacaoAgricolaID) REFERENCES OperacaoAgricola (ID);
ALTER TABLE LeituraSensor ADD CONSTRAINT FKLeituraSen422684 FOREIGN KEY (CadernoCampoID) REFERENCES CadernoCampo (ID);
ALTER TABLE AplicacaoFator ADD CONSTRAINT FKAplicacaoF710757 FOREIGN KEY (UnidadeFator) REFERENCES Unidade (designacao);
ALTER TABLE ProdutoAgricola ADD CONSTRAINT FKProdutoAgr97722 FOREIGN KEY (PlantaID) REFERENCES Planta (ID);
ALTER TABLE RecolhaProduto ADD CONSTRAINT FKRecolhaPro885594 FOREIGN KEY (ProdutoAgricolaID) REFERENCES ProdutoAgricola (ID);
ALTER TABLE AplicacaoFator ADD CONSTRAINT FKAplicacaoF661583 FOREIGN KEY (OperacaoAgricolaID) REFERENCES OperacaoAgricola (ID);
ALTER TABLE AplicacaoFator ADD CONSTRAINT FKAplicacaoF840207 FOREIGN KEY (FatorProducaoID) REFERENCES FatorProducao (ID);
ALTER TABLE RecolhaProduto ADD CONSTRAINT FKRecolhaPro37811 FOREIGN KEY (UnidadeProduto) REFERENCES Unidade (designacao);
ALTER TABLE Monda ADD CONSTRAINT FKMonda714231 FOREIGN KEY (OperacaoAgricolaID) REFERENCES OperacaoAgricola (ID);
ALTER TABLE OperacaoAgricola ADD CONSTRAINT FKOperacaoAg431535 FOREIGN KEY (ParcelaAgricolaID) REFERENCES ParcelaAgricola (ID);
