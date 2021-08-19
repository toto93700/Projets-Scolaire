ALTER SESSION SET NLS_DATE_FORMAT = 'DD MM YYYY';
DROP TABLE PATHOLOGIES CASCADE CONSTRAINTS;
CREATE TABLE PATHOLOGIES(
    CODE NUMBER(4)    NOT NULL,
    NOM  VARCHAR2(20) NOT NULL,
    CONSTRAINT pk_pathologies PRIMARY KEY (CODE)
);
DROP TABLE SOINS CASCADE CONSTRAINTS;

CREATE TABLE SOINS(
    ID_SOIN    NUMBER(4)    NOT NULL UNIQUE,
    NOM        VARCHAR2(20) NOT NULL,
    PATHOLOGIE NUMBER(4)    NOT NULL,
    CONSTRAINT pk_soins PRIMARY KEY (NOM,PATHOLOGIE),
    CONSTRAINT fk_soins_pathologies FOREIGN KEY (PATHOLOGIE) REFERENCES PATHOLOGIES(CODE)
);

DROP TABLE SERS CASCADE CONSTRAINTS;
CREATE TABLE SERS(
    ID_SERV    NUMBER(4)    NOT NULL  Unique ,
    CODE       NUMBER(4)    NOT NULL,
    NUMERO     NUMBER(4)    NOT NULL,
    NOM        VARCHAR2(20) NOT NULL,
    PATHOLOGIE NUMBER(4)    NOT NULL,
    CONSTRAINT pk_sers PRIMARY KEY (CODE,PATHOLOGIE),
    CONSTRAINT fk_sers_pathologies FOREIGN KEY (PATHOLOGIE) REFERENCES PATHOLOGIES(CODE)
);
DROP TABLE SALLES CASCADE CONSTRAINTS;
CREATE TABLE SALLES(
    ID_SALLE    NUMBER(4) UNIQUE  NOT NULL,
    NUMERO      NUMBER(4) NOT NULL,
    VOL         NUMBER(4) NOT NULL,
    TAUX_O      NUMBER(4) NOT NULL,
    SER         NUMBER(4) NOT NULL,
    PATHOLOGIE  NUMBER(4) NOT NULL,
    CONSTRAINT pk_salles PRIMARY KEY (NUMERO,SER),
    CONSTRAINT fk_salles_services FOREIGN KEY (SER,PATHOLOGIE) REFERENCES SERS(CODE,PATHOLOGIE)
);
DROP TABLE PERSONNELS CASCADE CONSTRAINTS;
CREATE TABLE PERSONNELS(
    ID_ADRESSE NUMBER(4) NOT NULL  UNIQUE,
    ID_NUMERO NUMBER(4) NOT NULL  UNIQUE,
    INSEE   NUMBER(4)   NOT NULL,
    R_OLE   VARCHAR(20) NOT NULL,
    SER     NUMBER(4)   ,
    SUP_HIE NUMBER(4)   ,
    NOM     VARCHAR(20) NOT NULL,
    PRENOM  VARCHAR(20) NOT NULL,
    PATHOLOGIE NUMBER(4) ,
    CONSTRAINT pk_personnels PRIMARY KEY (INSEE,SER),
    CONSTRAINT fk_personnels_personnels FOREIGN KEY (SUP_HIE,SER) REFERENCES PERSONNELS(INSEE,SER),
    CONSTRAINT fk_personnels_services FOREIGN KEY (SER,PATHOLOGIE) REFERENCES SERS(CODE,PATHOLOGIE)
);

DROP TABLE PATIENTS CASCADE CONSTRAINTS;
CREATE TABLE PATIENTS(
    
    ID_ADRESSE NUMBER(4)   NOT NULL  UNIQUE,
    ID_NUMERO NUMBER(4)   NOT NULL  UNIQUE,
    INSEE      NUMBER(4)   NOT NULL,
    NOM        VARCHAR(20) NOT NULL,
    PRENOM     VARCHAR(20) NOT NULL,
    PATHOLOGIE NUMBER(4)   NOT NULL,
    DATE_A     DATE        NOT NULL,
    DATE_S     DATE        ,
    CONSTRAINT pk_patients PRIMARY KEY (INSEE,DATE_A),
    CONSTRAINT fk_patients_pathologies FOREIGN KEY (PATHOLOGIE) REFERENCES PATHOLOGIES(CODE)
);
DROP TABLE ADRESSES CASCADE CONSTRAINTS;
CREATE TABLE ADRESSES(
    ID_ADRESSE  NUMBER(4)   NOT NULL  ,
    NUMERO NUMBER(4)   NOT NULL,
    RUE    VARCHAR(20) NOT NULL,
    CP     NUMBER(4)   NOT NULL,
    VILLE  VARCHAR(20) NOT NULL,
    
    CONSTRAINT pk_adresses  PRIMARY KEY (ID_ADRESSE),
    CONSTRAINT fk_adresses_patients FOREIGN KEY (ID_ADRESSE) REFERENCES PATIENTS(ID_ADRESSE),
    CONSTRAINT fk_adresses_personnels FOREIGN KEY (ID_ADRESSE) REFERENCES PERSONNELS(ID_ADRESSE)
);
DROP TABLE NUMEROS CASCADE CONSTRAINTS;
CREATE TABLE NUMEROS(
    ID_NUMERO  NUMBER(4)   NOT NULL,
    NUMERO NUMBER(4)   NOT NULL,
    CONSTRAINT pk_numeros  PRIMARY KEY (ID_NUMERO,NUMERO),
    CONSTRAINT fk_numeros_patients FOREIGN KEY (ID_NUMERO) REFERENCES PATIENTS(ID_NUMERO),
    CONSTRAINT fk_numeros_personnels FOREIGN KEY (ID_NUMERO) REFERENCES PERSONNELS(ID_NUMERO)
);
DROP TABLE SOINS_MEDICAUX CASCADE CONSTRAINTS;
CREATE TABLE SOINS_MEDICAUX(
   
    PATHOLOGIE VARCHAR2(20) NOT NULL,
    SER      NUMBER(4)  NOT NULL,
    SOIN     NUMBER(4) NOT NULL,
    SALLE    NUMBER(4) NOT NULL,
    MEDECIN  NUMBER(4) NOT NULL,
    PATIENT  NUMBER(4) NOT NULL,
    COUT     NUMBER(4) NOT NULL,
    DATE_SM  DATE      NOT NULL,
    resultat NUMBER(1) not null;
    CONSTRAINT pk_soins_medicaux PRIMARY KEY (SOIN,SALLE,MEDECIN,PATIENT)

);
   /*CONSTRAINT fk_soins_medicaux_soins   FOREIGN KEY (SOIN)    REFERENCES SOINS(ID_SOIN),
    CONSTRAINT fk_soins_medicaux_salle   FOREIGN KEY (SALLE,SER)   REFERENCES SALLES(NUMERO,SER),
    CONSTRAINT fk_soins_medicaux_medecin FOREIGN KEY (MEDECIN,SER) REFERENCES PERSONNELS(INSEE,SER)*/

   /* CONSTRAINT fk_soins_medicaux_medecin FOREIGN KEY (PATIEN) REFERENCES PATIENTS(ID_PATIENT)*/
