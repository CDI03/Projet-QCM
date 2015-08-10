use TP_QCM;

-- SCRIPT DE SUPPRESSION DES TABLES --

drop Table ReponseDonnee ;
drop Table QuestionPosee;
drop Table Reponse ;
drop Table Question ;
drop Table ResultatExamen ;
drop Table Examen  ;
drop Table Section;
drop Table Theme ;
drop Table CompetenceFormation ;
drop Table Competence;
drop Table Inscription;
drop Table Promotion ;
drop Table Test ;
drop Table Formation;
drop Table Candidat ;
drop Table Employe ;

--SCRIPT DE CREATION DES TABLES AVEC CLEFS PRIMAIRES --
CREATE TABLE Employe 
    (Id CHAR(5) NOT NULL , 
     Nom VARCHAR(30) NOT NULL , 
     Prenom VARCHAR(20) , 
     Courriel VARCHAR(100) NOT NULL ,  
     Fonction VARCHAR(50) , 
     CONSTRAINT PK_Employe PRIMARY KEY (Id));

CREATE TABLE Candidat 
    (Id CHAR(5) NOT NULL , 
     Nom VARCHAR(30) NOT NULL , 
     Prenom VARCHAR(20) NOT NULL , 
     MotDePasse VARCHAR(30) NOT NULL , 
     CONSTRAINT Candidat_PK PRIMARY KEY (Id));

CREATE TABLE Formation 
    (Id CHAR(8) NOT NULL , 
     Titre VARCHAR(150) NOT NULL , 
     CONSTRAINT Formation_PK PRIMARY KEY (Id));

CREATE TABLE Test 
    (Id INTEGER NOT NULL IDENTITY(1, 1),
     Libelle VARCHAR(50) NOT NULL , 
     Duree INTEGER NOT NULL , 
     SeuilHaut INTEGER NOT NULL , 
     SeuilBas INTEGER NOT NULL , 
     CONSTRAINT Test_PK PRIMARY KEY (Id));

CREATE TABLE Promotion 
    (Formation_Id CHAR(8) NOT NULL,
	 Numero INTEGER NOT NULL, 
     Code CHAR(2) NOT NULL,  
     Employe_Id CHAR(5) NOT NULL,
     CONSTRAINT PK_Promotion PRIMARY KEY (Formation_Id, Numero, Code));

CREATE TABLE Inscription 
    (Formation_Id CHAR(8) NOT NULL ,
     Promotion_Numero INTEGER NOT NULL , 
     Promotion_Code CHAR(2) NOT NULL ,  
     Candidat_Id CHAR(5) NOT NULL , 
     CONSTRAINT Inscription_PK PRIMARY KEY (Formation_Id, Promotion_Numero, Promotion_Code, Candidat_Id));

CREATE TABLE Competence 
    (Id INTEGER NOT NULL IDENTITY(1, 1),
     Libelle VARCHAR(150) NOT NULL , 
     CONSTRAINT Competence_PK PRIMARY KEY (Id));
     
CREATE TABLE CompetenceFormation
	(Competence_Id INTEGER NOT NULL,
	 Formation_Id CHAR(8) NOT NULL,
	 CONSTRAINT CompetenceFormation_PK PRIMARY KEY (Competence_Id, Formation_Id));

CREATE TABLE Theme 
    (Id INTEGER NOT NULL IDENTITY(1, 1),
     Libelle VARCHAR(50) NOT NULL ,
     Competence_Id INTEGER NOT NULL , 
     CONSTRAINT Theme_PK PRIMARY KEY (Id));

CREATE TABLE Section 
    (Test_Id INTEGER NOT NULL , 
     Theme_Id INTEGER NOT NULL , 
     NombreQuestion INTEGER NOT NULL ,
     CONSTRAINT Section_PK PRIMARY KEY (Test_Id, Theme_Id));

CREATE TABLE Examen 
    (Id INTEGER NOT NULL IDENTITY(1, 1), 
     Test_Id INTEGER NOT NULL , 
     Candidat_Id CHAR(5) NOT NULL , 
     TempsRestant INTEGER, 
     DatePassage DATETIME NOT NULL , 
     Etat CHAR(3) NOT NULL , 
     CONSTRAINT Examen_PK PRIMARY KEY (Id));

CREATE TABLE ResultatExamen 
    (Examen_Id INTEGER NOT NULL , 
     Test_Id INTEGER NOT NULL , 
     Theme_Id INTEGER NOT NULL , 
     NbQuestionsReussies INTEGER NOT NULL , 
     NbQuestionsTotales INTEGER NOT NULL , 
     CONSTRAINT ResultatExamen_PK PRIMARY KEY (Examen_Id, Test_Id, Theme_Id));

CREATE TABLE Question 
    (Id INTEGER NOT NULL IDENTITY(1, 1), 
     Enonce TEXT NOT NULL ,
     Theme_Id INTEGER NOT NULL , 
     Illustration IMAGE , 
     CONSTRAINT Question_PK PRIMARY KEY (Id));

CREATE TABLE Reponse 
    (Id INTEGER NOT NULL , 
     Question_Id INTEGER NOT NULL , 
     Libelle VARCHAR(150) NOT NULL , 
     EstCorrect BIT NOT NULL , 
     CONSTRAINT Reponse_PK PRIMARY KEY (Id, Question_Id));

CREATE TABLE QuestionPosee 
    (Examen_Id INTEGER NOT NULL,
     Ordre INTEGER NOT NULL,  
     Question_Id INTEGER NOT NULL,
     Repondu BIT NOT NULL, 
     Marque BIT NOT NULL, 
     CONSTRAINT QuestionPosee_PK PRIMARY KEY (Examen_Id, Ordre));

CREATE TABLE ReponseDonnee 
    (Examen_Id INTEGER NOT NULL , 
     QuestionPosee_Ordre INTEGER NOT NULL ,  
     Reponse_Id INTEGER NOT NULL ,
     Question_Id INTEGER NOT NULL, 
     CONSTRAINT ReponseDonnee_PK PRIMARY KEY (Examen_Id, QuestionPosee_Ordre, Reponse_Id, Question_Id));