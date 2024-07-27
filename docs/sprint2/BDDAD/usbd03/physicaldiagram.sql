CREATE TABLE TIpoCultura (
  Tipo varchar2(255) NOT NULL, 
  PRIMARY KEY (Tipo));
CREATE TABLE EstacaoMeteorologica (
  ID number(10) GENERATED AS IDENTITY, 
  PRIMARY KEY (ID));
CREATE TABLE TipoOperacao (
  Tipo varchar2(255) NOT NULL, 
  PRIMARY KEY (Tipo));
CREATE TABLE OperacaoAgricola (
  ID                         number(10) GENERATED AS IDENTITY, 
  TipoOperacaoTipo           varchar2(255) NOT NULL, 
  CadernoCampoID             number(10), 
  DataRealizacao             date NOT NULL, 
  Quantidade                 number(10), 
  Unidadedesignacao          varchar2(10), 
  FatorProducaoNomeComercial varchar2(255), 
  Parcela                    varchar2(255) NOT NULL, 
  Cultura                    varchar2(255) NOT NULL, 
  PRIMARY KEY (ID));
CREATE TABLE CadernoCampo (
  ID   number(10) GENERATED AS IDENTITY, 
  nome varchar2(255), 
  PRIMARY KEY (ID));
CREATE TABLE ElementoSubstancias (
  Nome varchar2(255) NOT NULL, 
  PRIMARY KEY (Nome));
CREATE TABLE FichaTecnica (
  quantidade                 number(10) NOT NULL, 
  FatorProducaoNomeComercial varchar2(255) NOT NULL, 
  ElementoSubstanciasNome    varchar2(255) NOT NULL, 
  PRIMARY KEY (FatorProducaoNomeComercial, 
  ElementoSubstanciasNome));
CREATE TABLE FatorProducao (
  NomeComercial varchar2(255) NOT NULL, 
  Formulacao    varchar2(255) NOT NULL, 
  CulturaNome   varchar2(255), 
  Fabricante    varchar2(255), 
  PRIMARY KEY (NomeComercial));
CREATE TABLE Cultura (
  Nome          varchar2(255) NOT NULL, 
  TipoCultura   varchar2(255) NOT NULL, 
  SistemaDeRega number(10) NOT NULL, 
  PRIMARY KEY (Nome));
CREATE TABLE TipoFatorProducao (
  Tipo varchar2(255) NOT NULL, 
  PRIMARY KEY (Tipo));
CREATE TABLE Formulacao (
  Tipo varchar2(255) NOT NULL, 
  PRIMARY KEY (Tipo));
CREATE TABLE TipoSensor (
  Tipo varchar2(255) NOT NULL, 
  PRIMARY KEY (Tipo));
CREATE TABLE ProdutosAgricolas (
  CabazID            number(10), 
  OperacaoAgricolaID number(10));
CREATE TABLE ParcelaAgricola (
  Designacao varchar2(255) NOT NULL, 
  Area       number(10) NOT NULL, 
  PRIMARY KEY (Designacao));
CREATE TABLE SensorMeteorologico (
  Marca                  varchar2(255) NOT NULL, 
  Modelo                 varchar2(255) NOT NULL, 
  TipoSensorTipo         varchar2(255), 
  EstacaoMeteorologicaID number(10) NOT NULL, 
  PRIMARY KEY (Modelo));
CREATE TABLE Regularidade (
  TIpo varchar2(255) NOT NULL, 
  PRIMARY KEY (TIpo));
CREATE TABLE PlanoDeRega (
  ID                        number(10) GENERATED AS IDENTITY, 
  "Horas Rega"              number(10) NOT NULL, 
  Duração                   number(10) NOT NULL, 
  ParcelaAgricolaDesignação varchar2(255) NOT NULL UNIQUE, 
  RegularidadeTIpo          varchar2(255) NOT NULL, 
  PRIMARY KEY (ID));
CREATE TABLE LeituraMeteorologica (
  OperacaoAgricolaID            number(10) NOT NULL, 
  Hora                          number(10) NOT NULL, 
  VelocidadeVento               number(10) NOT NULL, 
  TemperaturaSolo               number(10) NOT NULL, 
  HumidadeSolo                  number(10) NOT NULL, 
  "Pressao Atmosferica"         number(10) NOT NULL, 
  Pluviosidade                  number(10) NOT NULL, 
  TemperaturaAr                 number(10) NOT NULL, 
  HumidadeAr                    number(10) NOT NULL, 
  PlanoDeRegaOperacaoAgricolaID number(10) NOT NULL, 
  SensorMeteorologicoModelo     varchar2(255), 
  PRIMARY KEY (OperacaoAgricolaID));
CREATE TABLE Cultura_ParcelaAgricola (
  ID                        number(10) GENERATED AS IDENTITY, 
  ParcelaAgricolaDesignacao varchar2(255) NOT NULL, 
  CulturaNome               varchar2(255) NOT NULL, 
  unidade                   varchar2(10) NOT NULL, 
  quantidade                number(10), 
  Data_Inicio               date NOT NULL, 
  Data_Fim                  date, 
  PRIMARY KEY (ID));
CREATE TABLE SistemaDeRega (
  ID   number(10) GENERATED AS IDENTITY, 
  nome varchar2(255), 
  PRIMARY KEY (ID));
CREATE TABLE Fertilizacao (
  OperacaoAgricolaID         number(10) NOT NULL, 
  TipoFertilizacaoDesignação varchar2(255) NOT NULL, 
  PRIMARY KEY (OperacaoAgricolaID));
CREATE TABLE FatorProducao_Tipo (
  FatorProducaoNomeComercial varchar2(255) NOT NULL, 
  TipoFatorProducaoTipo      varchar2(255) NOT NULL, 
  Aplicacao                  varchar2(255) NOT NULL);
CREATE TABLE TipoFertilizacao (
  Designação varchar2(255) NOT NULL, 
  PRIMARY KEY (Designação));
CREATE TABLE Unidade (
  designacao varchar2(10) NOT NULL, 
  PRIMARY KEY (designacao));
ALTER TABLE OperacaoAgricola ADD CONSTRAINT FKOperacaoAg527434 FOREIGN KEY (TipoOperacaoTipo) REFERENCES TipoOperacao (Tipo);
ALTER TABLE OperacaoAgricola ADD CONSTRAINT FKOperacaoAg555764 FOREIGN KEY (CadernoCampoID) REFERENCES CadernoCampo (ID);
ALTER TABLE FichaTecnica ADD CONSTRAINT FKFichaTecni874385 FOREIGN KEY (FatorProducaoNomeComercial) REFERENCES FatorProducao (NomeComercial);
ALTER TABLE FatorProducao ADD CONSTRAINT FKFatorProdu259381 FOREIGN KEY (CulturaNome) REFERENCES Cultura (Nome);
ALTER TABLE Cultura ADD CONSTRAINT FKCultura203510 FOREIGN KEY (TipoCultura) REFERENCES TIpoCultura (Tipo);
ALTER TABLE FichaTecnica ADD CONSTRAINT FKFichaTecni773388 FOREIGN KEY (ElementoSubstanciasNome) REFERENCES ElementoSubstancias (Nome);
ALTER TABLE ProdutosAgricolas ADD CONSTRAINT FKProdutosAg248078 FOREIGN KEY (OperacaoAgricolaID) REFERENCES OperacaoAgricola (ID);
ALTER TABLE SensorMeteorologico ADD CONSTRAINT FKSensorMete925299 FOREIGN KEY (TipoSensorTipo) REFERENCES TipoSensor (Tipo);
ALTER TABLE PlanoDeRega ADD CONSTRAINT FKPlanoDeReg856579 FOREIGN KEY (ParcelaAgricolaDesignação) REFERENCES ParcelaAgricola (Designacao);
ALTER TABLE PlanoDeRega ADD CONSTRAINT FKPlanoDeReg324903 FOREIGN KEY (RegularidadeTIpo) REFERENCES Regularidade (TIpo);
ALTER TABLE LeituraMeteorologica ADD CONSTRAINT FKLeituraMet505413 FOREIGN KEY (OperacaoAgricolaID) REFERENCES OperacaoAgricola (ID);
ALTER TABLE LeituraMeteorologica ADD CONSTRAINT FKLeituraMet898090 FOREIGN KEY (PlanoDeRegaOperacaoAgricolaID) REFERENCES PlanoDeRega (ID);
ALTER TABLE LeituraMeteorologica ADD CONSTRAINT FKLeituraMet801418 FOREIGN KEY (SensorMeteorologicoModelo) REFERENCES SensorMeteorologico (Modelo);
ALTER TABLE Cultura_ParcelaAgricola ADD CONSTRAINT FKCultura_Pa745959 FOREIGN KEY (ParcelaAgricolaDesignacao) REFERENCES ParcelaAgricola (Designacao);
ALTER TABLE Cultura_ParcelaAgricola ADD CONSTRAINT FKCultura_Pa498443 FOREIGN KEY (CulturaNome) REFERENCES Cultura (Nome);
ALTER TABLE Fertilizacao ADD CONSTRAINT FKFertilizac459367 FOREIGN KEY (OperacaoAgricolaID) REFERENCES OperacaoAgricola (ID);
ALTER TABLE OperacaoAgricola ADD CONSTRAINT FKOperacaoAg2376 FOREIGN KEY (FatorProducaoNomeComercial) REFERENCES FatorProducao (NomeComercial);
ALTER TABLE Cultura ADD CONSTRAINT FKCultura233474 FOREIGN KEY (SistemaDeRega) REFERENCES SistemaDeRega (ID);
ALTER TABLE SensorMeteorologico ADD CONSTRAINT FKSensorMete104573 FOREIGN KEY (EstacaoMeteorologicaID) REFERENCES EstacaoMeteorologica (ID);
ALTER TABLE FatorProducao ADD CONSTRAINT FKFatorProdu502345 FOREIGN KEY (Formulacao) REFERENCES Formulacao (Tipo);
ALTER TABLE FatorProducao_Tipo ADD CONSTRAINT FKFatorProdu152398 FOREIGN KEY (TipoFatorProducaoTipo) REFERENCES TipoFatorProducao (Tipo);
ALTER TABLE Fertilizacao ADD CONSTRAINT FKFertilizac900658 FOREIGN KEY (TipoFertilizacaoDesignação) REFERENCES TipoFertilizacao (Designação);
ALTER TABLE OperacaoAgricola ADD CONSTRAINT FKOperacaoAg114903 FOREIGN KEY (Unidadedesignacao) REFERENCES Unidade (designacao);
ALTER TABLE FatorProducao_Tipo ADD CONSTRAINT FKFatorProdu699141 FOREIGN KEY (FatorProducaoNomeComercial) REFERENCES FatorProducao (NomeComercial);
ALTER TABLE Cultura_ParcelaAgricola ADD CONSTRAINT FKCultura_Pa944919 FOREIGN KEY (unidade) REFERENCES Unidade (designacao);
ALTER TABLE OperacaoAgricola ADD CONSTRAINT FKOperacaoAg296886 FOREIGN KEY (Parcela) REFERENCES ParcelaAgricola (Designacao);
ALTER TABLE OperacaoAgricola ADD CONSTRAINT FKOperacaoAg834421 FOREIGN KEY (Cultura) REFERENCES Cultura (Nome);
