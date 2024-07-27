CREATE TABLE EstacaoMeteorologica (
  ID number(10) GENERATED AS IDENTITY, 
  PRIMARY KEY (ID));
CREATE TABLE CadernoCampo (
  ID   number(10) GENERATED AS IDENTITY, 
  nome varchar2(255) NOT NULL, 
  PRIMARY KEY (ID));
CREATE TABLE FichaTecnica (
  Nome            varchar2(255) NOT NULL, 
  FatorProducaoID number(10) NOT NULL, 
  quantidade      float(10) NOT NULL, 
  PRIMARY KEY (Nome, 
  FatorProducaoID));
CREATE TABLE FatorProducao (
  ID                number(10) GENERATED AS IDENTITY, 
  NomeComercial     varchar2(255) NOT NULL, 
  Formulacao        varchar2(255) NOT NULL, 
  Fabricante        varchar2(255) NOT NULL, 
  FatorProducaoTipo varchar2(255) NOT NULL, 
  Aplicacao         varchar2(255) NOT NULL, 
  pH                float(10) DEFAULT NULL, 
  Densidade         float(10) DEFAULT NULL, 
  UnidadeDensidade  varchar2(10) DEFAULT 'kg/l' NOT NULL, 
  PRIMARY KEY (ID));
CREATE TABLE Planta (
  PlantaID     number(10) GENERATED AS IDENTITY, 
  Nome         varchar2(255) NOT NULL, 
  Especie      varchar2(255) NOT NULL, 
  PlantaTipoID number(10) NOT NULL, 
  PRIMARY KEY (PlantaID));
CREATE TABLE Sensor (
  ID                     number(10) GENERATED AS IDENTITY, 
  Marca                  varchar2(255) NOT NULL, 
  Modelo                 varchar2(255) NOT NULL, 
  TipoSensor             varchar2(255) NOT NULL, 
  TipoLeitura            varchar2(255) NOT NULL, 
  EstacaoMeteorologicaID number(10) NOT NULL, 
  PRIMARY KEY (ID));
CREATE TABLE PlanoDeRega (
  ID           number(10) GENERATED AS IDENTITY, 
  HorasRega    varchar2(255) NOT NULL, 
  Duracao      number(10) NOT NULL, 
  Regularidade varchar2(255) NOT NULL, 
  ParcelaID    number(10) NOT NULL, 
  PRIMARY KEY (ID));
CREATE TABLE Cultura (
  CulturaID         number(10) GENERATED AS IDENTITY, 
  Data_Inicio       date NOT NULL, 
  Data_Fim          date DEFAULT NULL, 
  Quantidade        float(10) NOT NULL, 
  ParcelaID         number(10) NOT NULL, 
  PlantaID          number(10) NOT NULL, 
  Unidadedesignacao varchar2(10) NOT NULL, 
  PRIMARY KEY (CulturaID));
CREATE TABLE Fertilizacao (
  TipoFertilizacao varchar2(255) NOT NULL);
CREATE TABLE Unidade (
  designacao varchar2(10) NOT NULL, 
  PRIMARY KEY (designacao));
CREATE TABLE SetorDeRega (
  ID            number(10) GENERATED AS IDENTITY, 
  caudal        float(10) NOT NULL, 
  area          float(10) NOT NULL, 
  designacao    varchar2(255) NOT NULL, 
  DataInsercao  date NOT NULL, 
  UnidadeCaudal varchar2(10) NOT NULL, 
  PRIMARY KEY (ID));
CREATE TABLE SetorDeRegaCultura (
  SetorDeRegaID number(10) NOT NULL, 
  CulturaID     number(10) NOT NULL, 
  Data_Inicio   date NOT NULL, 
  Data_fim      date DEFAULT NULL, 
  PRIMARY KEY (SetorDeRegaID, 
  CulturaID));
CREATE TABLE AplicacaoFator (
  OperacaoID number(10) NOT NULL, 
  PRIMARY KEY (OperacaoID));
CREATE TABLE Monda (
  OperacaoID number(10) NOT NULL, 
  CulturaID  number(10) NOT NULL, 
  Area       number(10) NOT NULL, 
  Unidade    varchar2(10) NOT NULL, 
  PRIMARY KEY (OperacaoID));
CREATE TABLE AplicacaoMistura (
  OperacaoAgricolaID number(10) GENERATED AS IDENTITY, 
  MisturaID          number(10) NOT NULL, 
  PRIMARY KEY (OperacaoAgricolaID));
CREATE TABLE Mistura (
  ID number(10) NOT NULL, 
  PRIMARY KEY (ID));
CREATE TABLE MisturaFatorProducao (
  MisturaID       number(10) NOT NULL, 
  FatorProducaoID number(10) NOT NULL, 
  QuantidadeFator number(10) NOT NULL, 
  Unidadede       varchar2(10) NOT NULL, 
  PRIMARY KEY (MisturaID, 
  FatorProducaoID));
CREATE TABLE Log (
  ID           number(10) GENERATED AS IDENTITY, 
  Acao         varchar2(255) NOT NULL, 
  OperacaoTipo varchar2(255) NOT NULL, 
  Data         timestamp(0) with local time zone NOT NULL, 
  OperacaoID   number(10) NOT NULL, 
  Dados        varchar2(255) DEFAULT 'NULL', 
  PRIMARY KEY (ID));
CREATE TABLE AplicacaoFator_FatorProducao (
  OperacaoID        number(10) NOT NULL, 
  FatorProducaoID   number(10) NOT NULL, 
  Quantidade        number(10) NOT NULL, 
  Unidadedesignacao varchar2(10) NOT NULL, 
  PRIMARY KEY (OperacaoID, 
  FatorProducaoID));
CREATE TABLE Colheita (
  OperacaoID        number(10) NOT NULL, 
  ProdutoID         number(10) NOT NULL, 
  Quantidade        number(10) NOT NULL, 
  CulturaID         number(10) NOT NULL, 
  Unidadedesignacao varchar2(10) NOT NULL, 
  PRIMARY KEY (OperacaoID));
CREATE TABLE Operacao (
  OperacaoID     number(10) NOT NULL, 
  DataRealizacao date NOT NULL, 
  CadernoCampoID number(10) NOT NULL, 
  DataInsercao   timestamp(0) DEFAULT CURRENT_TIMESTAMP NOT NULL, 
  Anulado        number(1) DEFAULT 0 NOT NULL, 
  PRIMARY KEY (OperacaoID));
CREATE TABLE Semeadura (
  OperacaoID        number(10) NOT NULL, 
  CulturaID         number(10) NOT NULL, 
  QuantidadeSemente float(10) NOT NULL, 
  UnidadeSemente    varchar2(10) NOT NULL, 
  PRIMARY KEY (OperacaoID));
CREATE TABLE TipoPlanta (
  TipoPlantaID number(10) GENERATED AS IDENTITY, 
  Designacao   varchar2(100) NOT NULL, 
  PRIMARY KEY (TipoPlantaID));
CREATE TABLE Rega (
  OperacaoID number(10) NOT NULL, 
  CulturaID  number(10) NOT NULL, 
  horainicio varchar2(255) NOT NULL, 
  duracao    number(10) NOT NULL, 
  MisturaID  number(10) DEFAULT NULL, 
  PRIMARY KEY (OperacaoID));
CREATE TABLE Parcela (
  ParcelaID  number(10) GENERATED AS IDENTITY, 
  Designacao varchar2(255) NOT NULL UNIQUE, 
  Area       float(10) NOT NULL, 
  PRIMARY KEY (ParcelaID));
CREATE TABLE Plantacao (
  OperacaoID     number(10) NOT NULL, 
  CulturaID      number(10) NOT NULL, 
  NumPlantas     number(10) NOT NULL, 
  Compasso       float(10) DEFAULT NULL, 
  DistanciaFilas float(10) DEFAULT NULL, 
  PRIMARY KEY (OperacaoID));
CREATE TABLE AFCultura (
  AplicacaoFatorOperacaoID number(10) NOT NULL, 
  CulturaID                number(10) NOT NULL, 
  ModoAFatorID             number(10) NOT NULL, 
  PRIMARY KEY (AplicacaoFatorOperacaoID));
CREATE TABLE ModoAFator (
  ID         number(10) GENERATED AS IDENTITY, 
  Designacao varchar2(255) NOT NULL, 
  PRIMARY KEY (ID));
CREATE TABLE AFParcela (
  AplicacaoFatorOperacaoID number(10) NOT NULL, 
  ParcelaID                number(10) NOT NULL, 
  Area                     float(10) NOT NULL, 
  Unidadedesignacao        varchar2(10) NOT NULL, 
  PRIMARY KEY (AplicacaoFatorOperacaoID));
CREATE TABLE MovimentacaoSolo (
  OperacaoID        number(10) NOT NULL, 
  ParcelaID         number(10) NOT NULL, 
  Area              number(10) NOT NULL, 
  Unidadedesignacao varchar2(10) NOT NULL, 
  PRIMARY KEY (OperacaoID));
CREATE TABLE LeituraSensor (
  ID             number(10) GENERATED AS IDENTITY, 
  SensorID       number(10) NOT NULL, 
  Valor          number(10) NOT NULL, 
  Hora           varchar2(255) NOT NULL, 
  CadernoCampoID number(10) NOT NULL, 
  PlanoDeRegaID  number(10) NOT NULL, 
  PRIMARY KEY (ID));
CREATE TABLE Poda (
  OperacaoID        number(10) NOT NULL, 
  Quantidade        number(10), 
  UnidadeQuantidade varchar2(10) NOT NULL, 
  CulturaID         number(10) NOT NULL, 
  PRIMARY KEY (OperacaoID));
CREATE TABLE Produto (
  ProdutoID number(10) GENERATED AS IDENTITY, 
  Nome      varchar2(255) NOT NULL, 
  PlantaID  number(10) NOT NULL, 
  PRIMARY KEY (ProdutoID));
CREATE TABLE IncorporacaoSolo (
  OperacaoID        number(10) NOT NULL, 
  CulturaID         number(10) NOT NULL, 
  quantidade        number(10) NOT NULL, 
  Unidadedesignacao varchar2(10) NOT NULL, 
  PRIMARY KEY (OperacaoID));
ALTER TABLE Operacao ADD CONSTRAINT FKOperacao517013 FOREIGN KEY (CadernoCampoID) REFERENCES CadernoCampo (ID);
ALTER TABLE FichaTecnica ADD CONSTRAINT FKFichaTecni212783 FOREIGN KEY (FatorProducaoID) REFERENCES FatorProducao (ID);
ALTER TABLE Sensor ADD CONSTRAINT FKSensor673641 FOREIGN KEY (EstacaoMeteorologicaID) REFERENCES EstacaoMeteorologica (ID);
ALTER TABLE SetorDeRegaCultura ADD CONSTRAINT FKSetorDeReg968245 FOREIGN KEY (SetorDeRegaID) REFERENCES SetorDeRega (ID);
ALTER TABLE Monda ADD CONSTRAINT FKMonda948315 FOREIGN KEY (OperacaoID) REFERENCES Operacao (OperacaoID);
ALTER TABLE MisturaFatorProducao ADD CONSTRAINT FKMisturaFat404335 FOREIGN KEY (Unidadede) REFERENCES Unidade (designacao);
ALTER TABLE MisturaFatorProducao ADD CONSTRAINT FKMisturaFat927734 FOREIGN KEY (FatorProducaoID) REFERENCES FatorProducao (ID);
ALTER TABLE MisturaFatorProducao ADD CONSTRAINT FKMisturaFat676623 FOREIGN KEY (MisturaID) REFERENCES Mistura (ID);
ALTER TABLE Log ADD CONSTRAINT FKLog398635 FOREIGN KEY (OperacaoID) REFERENCES Operacao (OperacaoID);
ALTER TABLE AplicacaoFator_FatorProducao ADD CONSTRAINT FKAplicacaoF828486 FOREIGN KEY (OperacaoID) REFERENCES AplicacaoFator (OperacaoID);
ALTER TABLE AplicacaoFator_FatorProducao ADD CONSTRAINT FKAplicacaoF17627 FOREIGN KEY (FatorProducaoID) REFERENCES FatorProducao (ID);
ALTER TABLE Colheita ADD CONSTRAINT FKColheita498865 FOREIGN KEY (OperacaoID) REFERENCES Operacao (OperacaoID);
ALTER TABLE Colheita ADD CONSTRAINT FKColheita451164 FOREIGN KEY (CulturaID) REFERENCES Cultura (CulturaID);
ALTER TABLE Semeadura ADD CONSTRAINT FKSemeadura301596 FOREIGN KEY (CulturaID) REFERENCES Cultura (CulturaID);
ALTER TABLE Semeadura ADD CONSTRAINT FKSemeadura719964 FOREIGN KEY (OperacaoID) REFERENCES Operacao (OperacaoID);
ALTER TABLE Planta ADD CONSTRAINT FKPlanta740036 FOREIGN KEY (PlantaTipoID) REFERENCES TipoPlanta (TipoPlantaID);
ALTER TABLE Rega ADD CONSTRAINT FKRega18030 FOREIGN KEY (CulturaID) REFERENCES Cultura (CulturaID);
ALTER TABLE Rega ADD CONSTRAINT FKRega931999 FOREIGN KEY (OperacaoID) REFERENCES Operacao (OperacaoID);
ALTER TABLE Cultura ADD CONSTRAINT FKCultura590450 FOREIGN KEY (ParcelaID) REFERENCES Parcela (ParcelaID);
ALTER TABLE Plantacao ADD CONSTRAINT FKPlantacao827695 FOREIGN KEY (CulturaID) REFERENCES Cultura (CulturaID);
ALTER TABLE Plantacao ADD CONSTRAINT FKPlantacao122334 FOREIGN KEY (OperacaoID) REFERENCES Operacao (OperacaoID);
ALTER TABLE AplicacaoFator ADD CONSTRAINT FKAplicacaoF427499 FOREIGN KEY (OperacaoID) REFERENCES Operacao (OperacaoID);
ALTER TABLE AFCultura ADD CONSTRAINT FKAFCultura433347 FOREIGN KEY (AplicacaoFatorOperacaoID) REFERENCES AplicacaoFator (OperacaoID);
ALTER TABLE AFCultura ADD CONSTRAINT FKAFCultura849527 FOREIGN KEY (CulturaID) REFERENCES Cultura (CulturaID);
ALTER TABLE Colheita ADD CONSTRAINT FKColheita979147 FOREIGN KEY (Unidadedesignacao) REFERENCES Unidade (designacao);
ALTER TABLE Cultura ADD CONSTRAINT FKCultura838764 FOREIGN KEY (Unidadedesignacao) REFERENCES Unidade (designacao);
ALTER TABLE AFParcela ADD CONSTRAINT FKAFParcela486505 FOREIGN KEY (AplicacaoFatorOperacaoID) REFERENCES AplicacaoFator (OperacaoID);
ALTER TABLE AFParcela ADD CONSTRAINT FKAFParcela677563 FOREIGN KEY (ParcelaID) REFERENCES Parcela (ParcelaID);
ALTER TABLE MovimentacaoSolo ADD CONSTRAINT FKMovimentac941339 FOREIGN KEY (OperacaoID) REFERENCES Operacao (OperacaoID);
ALTER TABLE MovimentacaoSolo ADD CONSTRAINT FKMovimentac667667 FOREIGN KEY (ParcelaID) REFERENCES Parcela (ParcelaID);
ALTER TABLE MovimentacaoSolo ADD CONSTRAINT FKMovimentac552237 FOREIGN KEY (Unidadedesignacao) REFERENCES Unidade (designacao);
ALTER TABLE Cultura ADD CONSTRAINT FKCultura643243 FOREIGN KEY (PlantaID) REFERENCES Planta (PlantaID);
ALTER TABLE Monda ADD CONSTRAINT FKMonda1714 FOREIGN KEY (CulturaID) REFERENCES Cultura (CulturaID);
ALTER TABLE Monda ADD CONSTRAINT FKMonda214083 FOREIGN KEY (Unidade) REFERENCES Unidade (designacao);
ALTER TABLE SetorDeRegaCultura ADD CONSTRAINT FKSetorDeReg277125 FOREIGN KEY (CulturaID) REFERENCES Cultura (CulturaID);
ALTER TABLE FatorProducao ADD CONSTRAINT FKFatorProdu874283 FOREIGN KEY (UnidadeDensidade) REFERENCES Unidade (designacao);
ALTER TABLE SetorDeRega ADD CONSTRAINT FKSetorDeReg138841 FOREIGN KEY (UnidadeCaudal) REFERENCES Unidade (designacao);
ALTER TABLE Semeadura ADD CONSTRAINT FKSemeadura183970 FOREIGN KEY (UnidadeSemente) REFERENCES Unidade (designacao);
ALTER TABLE LeituraSensor ADD CONSTRAINT FKLeituraSen784537 FOREIGN KEY (SensorID) REFERENCES Sensor (ID);
ALTER TABLE LeituraSensor ADD CONSTRAINT FKLeituraSen422684 FOREIGN KEY (CadernoCampoID) REFERENCES CadernoCampo (ID);
ALTER TABLE LeituraSensor ADD CONSTRAINT FKLeituraSen245569 FOREIGN KEY (PlanoDeRegaID) REFERENCES PlanoDeRega (ID);
ALTER TABLE PlanoDeRega ADD CONSTRAINT FKPlanoDeReg113053 FOREIGN KEY (ParcelaID) REFERENCES Parcela (ParcelaID);
ALTER TABLE AFParcela ADD CONSTRAINT FKAFParcela429249 FOREIGN KEY (Unidadedesignacao) REFERENCES Unidade (designacao);
ALTER TABLE Poda ADD CONSTRAINT FKPoda982064 FOREIGN KEY (OperacaoID) REFERENCES Operacao (OperacaoID);
ALTER TABLE Poda ADD CONSTRAINT FKPoda169743 FOREIGN KEY (UnidadeQuantidade) REFERENCES Unidade (designacao);
ALTER TABLE Poda ADD CONSTRAINT FKPoda967964 FOREIGN KEY (CulturaID) REFERENCES Cultura (CulturaID);
ALTER TABLE Colheita ADD CONSTRAINT FKColheita534443 FOREIGN KEY (ProdutoID) REFERENCES Produto (ProdutoID);
ALTER TABLE Produto ADD CONSTRAINT FKProduto305692 FOREIGN KEY (PlantaID) REFERENCES Planta (PlantaID);
ALTER TABLE AFCultura ADD CONSTRAINT FKAFCultura952167 FOREIGN KEY (ModoAFatorID) REFERENCES ModoAFator (ID);
ALTER TABLE AplicacaoFator_FatorProducao ADD CONSTRAINT FKAplicacaoF791756 FOREIGN KEY (Unidadedesignacao) REFERENCES Unidade (designacao);
ALTER TABLE Rega ADD CONSTRAINT FKRega376242 FOREIGN KEY (MisturaID) REFERENCES Mistura (ID);
ALTER TABLE IncorporacaoSolo ADD CONSTRAINT FKIncorporac980436 FOREIGN KEY (CulturaID) REFERENCES Cultura (CulturaID);
ALTER TABLE IncorporacaoSolo ADD CONSTRAINT FKIncorporac969592 FOREIGN KEY (OperacaoID) REFERENCES Operacao (OperacaoID);
ALTER TABLE IncorporacaoSolo ADD CONSTRAINT FKIncorporac491579 FOREIGN KEY (Unidadedesignacao) REFERENCES Unidade (designacao);
