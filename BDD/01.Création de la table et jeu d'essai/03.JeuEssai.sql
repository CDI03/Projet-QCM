-- TABLE EMPLOYE --
INSERT INTO Employe (Id,Nom,Prenom,Courriel,Fonction)
     VALUES ('RIC01','RICHARD','Thierry', 'trichard@eni-ecole.fr','responsable');
INSERT INTO Employe (Id,Nom,Prenom,Courriel,Fonction)
     VALUES ('NIC01','NICOLAS','C�dric', 'cnicolas@eni-ecole.fr','formateur');
INSERT INTO Employe (Id,Nom,Prenom,Courriel,Fonction)
     VALUES ('COS01','COSSON','Anthony', 'acosson@eni-ecole.fr','formateur');
INSERT INTO Employe (Id,Nom,Prenom,Courriel,Fonction)
     VALUES ('OLL01','OLLIVIER','St�phane', 'sollivier@eni-ecole.fr','responsable');




-- TABLE CANDIDAT --
INSERT INTO Candidat (Id, Nom, Prenom, MotDePasse)
     VALUES ('BER01', 'BERNARD', 'Anthony', '123456');
INSERT INTO Candidat (Id, Nom, Prenom, MotDePasse)
     VALUES ('BEL01', 'BELLAICHE', 'Johanna', '123456');
INSERT INTO Candidat (Id, Nom, Prenom, MotDePasse)
     VALUES ('LAU01', 'LAURENCON', 'Christel', '123456');
INSERT INTO Candidat (Id, Nom, Prenom, MotDePasse)
     VALUES ('JAR01', 'JARNOIN', 'Steven', '123456');
INSERT INTO Candidat (Id, Nom, Prenom, MotDePasse)
     VALUES ('TIE01', 'TIEMTORE', 'Tinga Rene', '123456');
INSERT INTO Candidat (Id, Nom, Prenom, MotDePasse)
     VALUES ('REN01', 'RENAULT', 'Anthony', '123456');
INSERT INTO Candidat (Id, Nom, Prenom, MotDePasse)
     VALUES ('LEG01', 'LEGOUPIL', 'Kevin', '123456');
INSERT INTO Candidat (Id, Nom, Prenom, MotDePasse)
     VALUES ('DES01', 'DESSEINT', 'Sabine', '123456');
INSERT INTO Candidat (Id, Nom, Prenom, MotDePasse)
     VALUES ('TUZ01', 'TUZET', 'Kevin', '123456');
INSERT INTO Candidat (Id, Nom, Prenom, MotDePasse)
     VALUES ('GUI01', 'GUILLARD', 'Jean-Marie', '123456');
INSERT INTO Candidat (Id, Nom, Prenom, MotDePasse)
     VALUES ('COU01', 'COUDREUSE', 'David', '123456');
INSERT INTO Candidat (Id, Nom, Prenom, MotDePasse)
     VALUES ('POU01', 'POUPON', 'Yoran', '123456');
INSERT INTO Candidat (Id, Nom, Prenom, MotDePasse)
     VALUES ('BIC01', 'BICQUELET', 'Florence', '123456');
INSERT INTO Candidat (Id, Nom, Prenom, MotDePasse)
     VALUES ('LEM01', 'LE MONNIER', 'Vincent', '123456');
INSERT INTO Candidat (Id, Nom, Prenom, MotDePasse)
     VALUES ('FAU01', 'FAUCHER', 'Thierry', '123456');
INSERT INTO Candidat (Id, Nom, Prenom, MotDePasse)
     VALUES ('HAN01', 'HANOULT', 'Thibault', '123456');



-- TABLE FORMATION  -- 
INSERT INTO Formation (Id,Titre)
     VALUES ('CDI', 'Concepteur D�veloppeur Informatique');
INSERT INTO Formation (Id,Titre)
     VALUES ('DL', 'D�veloppeur Logiciel');
INSERT INTO Formation (Id,Titre)
     VALUES ('T2SI', 'Technicien Sup�rieur de Support Informatique');
INSERT INTO Formation (Id,Titre)
     VALUES ('LIEA', 'Licence Informatique en alternance');
INSERT INTO Formation (Id,Titre)
     VALUES ('ASR', 'Administrateur R�seaux et Systeme');
INSERT INTO Formation (Id,Titre)
     VALUES ('MS2I-I', 'Manager des Syst�mes d''Information et d''Infrastructure option Infrastructure');
INSERT INTO Formation (Id,Titre)
     VALUES ('MS2I-SI', 'Manager des Syst�mes d''Information et d''Infrastructure option syst�me d''information');
INSERT INTO Formation (Id,Titre)
     VALUES ('TSRI', 'Technicien Sup�rieur en R�seaux Informatiques');
     
-- TABLE TEST --     
INSERT INTO Test (Libelle, Duree, SeuilHaut, SeuilBas)
     VALUES ('C# Initiation � la programmation', 2500, 40, 80);
INSERT INTO Test (Libelle, Duree, SeuilHaut, SeuilBas)
     VALUES ('C# D�veloppement d''une application en couche', 2500, 40, 80);
INSERT INTO Test (Libelle, Duree, SeuilHaut, SeuilBas)
     VALUES ('SQL Utilisation du langage de requ�te', 2500, 40, 80);
INSERT INTO Test (Libelle, Duree, SeuilHaut, SeuilBas)
     VALUES ('PL/SQL programmmation avanc�e Oracle', 2500, 40, 80);
INSERT INTO Test (Libelle, Duree, SeuilHaut, SeuilBas)
     VALUES ('PHP Developpement avec Framework', 2500, 40, 80); 
     
     
-- TABLE PROMOTION --  
INSERT INTO Promotion (Formation_Id,Numero,Code,Employe_Id)
     VALUES ('CDI', 01,'FC', 'RIC01');
INSERT INTO Promotion (Formation_Id,Numero,Code,Employe_Id)
     VALUES ('CDI', 02,'FC', 'RIC01');
INSERT INTO Promotion (Formation_Id,Numero,Code,Employe_Id)
     VALUES ('CDI', 03,'FC', 'RIC01');
INSERT INTO Promotion (Formation_Id,Numero,Code,Employe_Id)
     VALUES ('CDI', 01,'EA', 'RIC01');
INSERT INTO Promotion (Formation_Id,Numero,Code,Employe_Id)
     VALUES ('CDI', 02,'EA', 'RIC01');
INSERT INTO Promotion (Formation_Id,Numero,Code,Employe_Id)
     VALUES ('DL', 01,'FC', 'RIC01');
INSERT INTO Promotion (Formation_Id,Numero,Code,Employe_Id)
     VALUES ('DL', 02,'FC', 'RIC01');
INSERT INTO Promotion (Formation_Id,Numero,Code,Employe_Id)
     VALUES ('LIEA', 01,'EA', 'OLL01');
INSERT INTO Promotion (Formation_Id,Numero,Code,Employe_Id)
     VALUES ('LIEA', 02,'EA', 'OLL01');
INSERT INTO Promotion (Formation_Id,Numero,Code,Employe_Id)
     VALUES ('LIEA', 03,'EA', 'OLL01');
INSERT INTO Promotion (Formation_Id,Numero,Code,Employe_Id)
     VALUES ('MS2I-I', 01,'EA', 'OLL01');
INSERT INTO Promotion (Formation_Id,Numero,Code,Employe_Id)
     VALUES ('MS2I-I', 02,'EA', 'OLL01');
INSERT INTO Promotion (Formation_Id,Numero,Code,Employe_Id)
     VALUES ('TSRI', 01,'EA', 'OLL01');
INSERT INTO Promotion (Formation_Id,Numero,Code,Employe_Id)
     VALUES ('TSRI', 02,'EA', 'OLL01');
INSERT INTO Promotion (Formation_Id,Numero,Code,Employe_Id)
     VALUES ('TSRI', 03,'EA', 'OLL01');
INSERT INTO Promotion (Formation_Id,Numero,Code,Employe_Id)
     VALUES ('TSRI', 04,'EA', 'OLL01');
INSERT INTO Promotion (Formation_Id,Numero,Code,Employe_Id)
     VALUES ('ASR', 01,'FC', 'RIC01');
INSERT INTO Promotion (Formation_Id,Numero,Code,Employe_Id)
     VALUES ('ASR', 02,'FC', 'RIC01');
INSERT INTO Promotion (Formation_Id,Numero,Code,Employe_Id)
     VALUES ('ASR', 03,'FC', 'RIC01');
INSERT INTO Promotion (Formation_Id,Numero,Code,Employe_Id)
     VALUES ('MS2I-SI', 01,'FC', 'RIC01');
INSERT INTO Promotion (Formation_Id,Numero,Code,Employe_Id)
     VALUES ('MS2I-SI', 02,'FC', 'RIC01');
INSERT INTO Promotion (Formation_Id,Numero,Code,Employe_Id)
     VALUES ('MS2I-SI', 03,'FC', 'RIC01');
INSERT INTO Promotion (Formation_Id,Numero,Code,Employe_Id)
     VALUES ('MS2I-SI', 04,'FC', 'RIC01');
        
-- TABLE INSCRIPTION --     
INSERT INTO Inscription (Formation_Id, Promotion_Numero, Promotion_Code, Candidat_Id)
     VALUES ('CDI', 03, 'FC' , 'BER01');
INSERT INTO Inscription (Formation_Id, Promotion_Numero, Promotion_Code, Candidat_Id)
     VALUES ('CDI', 03, 'FC' , 'BEL01'); 
INSERT INTO Inscription (Formation_Id, Promotion_Numero, Promotion_Code, Candidat_Id)
     VALUES ('CDI', 03, 'FC' , 'LAU01'); 
INSERT INTO Inscription (Formation_Id, Promotion_Numero, Promotion_Code, Candidat_Id)
     VALUES ('CDI', 03, 'FC' , 'JAR01');  
INSERT INTO Inscription (Formation_Id, Promotion_Numero, Promotion_Code, Candidat_Id)
     VALUES ('DL', 02, 'FC' , 'TIE01');
INSERT INTO Inscription (Formation_Id, Promotion_Numero, Promotion_Code, Candidat_Id)
     VALUES ('DL', 02, 'FC' , 'REN01');
INSERT INTO Inscription (Formation_Id, Promotion_Numero, Promotion_Code, Candidat_Id)
     VALUES ('DL', 02, 'FC' , 'LEG01');
INSERT INTO Inscription (Formation_Id, Promotion_Numero, Promotion_Code, Candidat_Id)
     VALUES ('TSRI', 04, 'EA' , 'TUZ01');
INSERT INTO Inscription (Formation_Id, Promotion_Numero, Promotion_Code, Candidat_Id)
     VALUES ('TSRI', 04, 'EA' , 'COU01');
INSERT INTO Inscription (Formation_Id, Promotion_Numero, Promotion_Code, Candidat_Id)
     VALUES ('TSRI', 04, 'EA' , 'POU01');
INSERT INTO Inscription (Formation_Id, Promotion_Numero, Promotion_Code, Candidat_Id)
     VALUES ('TSRI', 04, 'EA' , 'BIC01');
INSERT INTO Inscription (Formation_Id, Promotion_Numero, Promotion_Code, Candidat_Id)
     VALUES ('TSRI', 04, 'EA' , 'LEM01');
 
 
-- TABLE COMPETENCE -- 
INSERT INTO Competence (Libelle)
	VALUES ('Maqueter une application');
INSERT INTO Competence (Libelle)
	VALUES ('D�velopper une interface utilisateur');
INSERT INTO Competence (Libelle)
	VALUES ('D�velopper des composants d''acc�s aux donn�es');
INSERT INTO Competence (Libelle)
	VALUES ('D�velopper des pages web en lien avec une base de donn�es');
INSERT INTO Competence (Libelle)
	VALUES ('Concevoir une base de donn�es');
INSERT INTO Competence (Libelle)
	VALUES ('Mettre en place une base de donn�es');
INSERT INTO Competence (Libelle)
	VALUES ('D�velopper des composants dans le langage d�une base de donn�es');
INSERT INTO Competence (Libelle)
	VALUES ('Utiliser l�anglais dans son activit� professionnelle en informatique');
INSERT INTO Competence (Libelle)
	VALUES ('Collaborer � la gestion d�un projet informatique');
INSERT INTO Competence (Libelle)
	VALUES ('D�velopper des composants m�tier');
INSERT INTO Competence (Libelle)
	VALUES ('Construire une application organis�e en couches');
INSERT INTO Competence (Libelle)
	VALUES ('D�velopper une application de mobilit� num�rique');
INSERT INTO Competence (Libelle)
	VALUES ('Pr�parer et ex�cuter les plans de tests d�une application');
INSERT INTO Competence (Libelle)
	VALUES ('Pr�parer et ex�cuter le d�ploiement d�une application');
	
-- TABLE COMPETENCE FORMATION -- 	
INSERT INTO CompetenceFormation (Competence_Id,Formation_Id)
     VALUES (1,'CDI');
INSERT INTO CompetenceFormation (Competence_Id,Formation_Id)
     VALUES (2,'CDI');	
INSERT INTO CompetenceFormation (Competence_Id,Formation_Id)
     VALUES (3,'CDI');	
INSERT INTO CompetenceFormation (Competence_Id,Formation_Id)
     VALUES (4,'CDI');	
INSERT INTO CompetenceFormation (Competence_Id,Formation_Id)
     VALUES (5,'CDI');	
INSERT INTO CompetenceFormation (Competence_Id,Formation_Id)
     VALUES (6,'CDI');	
INSERT INTO CompetenceFormation (Competence_Id,Formation_Id)
     VALUES (7,'CDI');	
INSERT INTO CompetenceFormation (Competence_Id,Formation_Id)
     VALUES (8,'CDI');	
INSERT INTO CompetenceFormation (Competence_Id,Formation_Id)
     VALUES (9,'CDI');	
INSERT INTO CompetenceFormation (Competence_Id,Formation_Id)
     VALUES (10,'CDI');	
INSERT INTO CompetenceFormation (Competence_Id,Formation_Id)
     VALUES (11,'CDI');	
INSERT INTO CompetenceFormation (Competence_Id,Formation_Id)
     VALUES (12,'CDI');	
INSERT INTO CompetenceFormation (Competence_Id,Formation_Id)
     VALUES (13,'CDI');	
INSERT INTO CompetenceFormation (Competence_Id,Formation_Id)
     VALUES (14,'CDI');	
INSERT INTO CompetenceFormation (Competence_Id,Formation_Id)
     VALUES (1,'DL');	
INSERT INTO CompetenceFormation (Competence_Id,Formation_Id)
     VALUES (2,'DL');	
INSERT INTO CompetenceFormation (Competence_Id,Formation_Id)
     VALUES (3,'DL');	
		

-- TABLE THEME --
INSERT INTO Theme (Libelle, Competence_Id)
     VALUES ('C# Variables',1);
INSERT INTO Theme (Libelle, Competence_Id)
     VALUES ('C# Proc�dures',1);
INSERT INTO Theme (Libelle, Competence_Id)
     VALUES ('C# Fonctions',1);
INSERT INTO Theme (Libelle, Competence_Id)
     VALUES ('C# Collections',1);
INSERT INTO Theme (Libelle, Competence_Id)
     VALUES ('PHP Variables',01);
INSERT INTO Theme (Libelle, Competence_Id)
     VALUES ('PHP Proc�dures',01);
INSERT INTO Theme (Libelle, Competence_Id)
     VALUES ('PHP Fonctions',01);
INSERT INTO Theme (Libelle, Competence_Id)
     VALUES ('PHP Collections',01);
INSERT INTO Theme (Libelle, Competence_Id)
     VALUES ('Java Variables',2);
INSERT INTO Theme (Libelle, Competence_Id)
     VALUES ('Java Proc�dures',2);
INSERT INTO Theme (Libelle, Competence_Id)
     VALUES ('Java Fonctions',2);
INSERT INTO Theme (Libelle, Competence_Id)
     VALUES ('Java Collections',2);
INSERT INTO Theme (Libelle, Competence_Id)
     VALUES ('Javascript Variables',3);
INSERT INTO Theme (Libelle, Competence_Id)
     VALUES ('Javascript Proc�dures',3);
INSERT INTO Theme (Libelle, Competence_Id)
     VALUES ('Javascript Fonctions',3);
INSERT INTO Theme (Libelle, Competence_Id)
     VALUES ('Javascript Collections',3);    
     

-- TABLE SECTION --
INSERT INTO Section (Test_Id, Theme_Id, NombreQuestion)
     VALUES (01,01,3);
INSERT INTO Section (Test_Id, Theme_Id, NombreQuestion)
     VALUES (01,02,3);
INSERT INTO Section (Test_Id, Theme_Id, NombreQuestion)
     VALUES (01,03,3);
INSERT INTO Section (Test_Id, Theme_Id, NombreQuestion)
     VALUES (01,04,3);

-- TABLE EXAMEN --
INSERT INTO Examen (Test_Id,Candidat_Id,TempsRestant,DatePassage,Etat)
     VALUES(01,'BER01',null,'20150814 14:00:00.000','EA');
INSERT INTO Examen (Test_Id,Candidat_Id,TempsRestant,DatePassage,Etat)
     VALUES(01,'BER01',null,'20150825 15:00:00.000','EA');
INSERT INTO Examen (Test_Id,Candidat_Id,TempsRestant,DatePassage,Etat)
     VALUES(01,'BEL01',null,'20150814 14:00:00.000','EA');
INSERT INTO Examen (Test_Id,Candidat_Id,TempsRestant,DatePassage,Etat)
     VALUES(01,'BEL01',null,'20150825 15:00:00.000','EA');

-- TABLE RESULTAT EXAMEN --
INSERT INTO ResultatExamen (Examen_Id, Test_Id, Theme_Id,NbQuestionsReussies,NbQuestionsTotales)
     VALUES (01,01,1,35,12);
INSERT INTO ResultatExamen (Examen_Id, Test_Id, Theme_Id,NbQuestionsReussies,NbQuestionsTotales)
     VALUES (02,01,1,40,12);
INSERT INTO ResultatExamen (Examen_Id, Test_Id, Theme_Id,NbQuestionsReussies,NbQuestionsTotales)
     VALUES (03,01,1,35,12);
INSERT INTO ResultatExamen (Examen_Id, Test_Id, Theme_Id,NbQuestionsReussies,NbQuestionsTotales)
     VALUES (04,01,1,40,12);

-- TABLE QUESTION --
INSERT INTO Question (Enonce,Theme_Id,NbReponses,Illustration)
     VALUES('Quel est la valeur de x ? String x = 3 ; Boolean y = ( x == 5 ); if (y) {x = 2);',1,3, null);
INSERT INTO Question (Enonce,Theme_Id,NbReponses,Illustration)
     VALUES('Quel est la valeur de x ? String x = 3 ; Boolean y = ( x == 3 ); if (y) {x = 2);',1,3, null);
INSERT INTO Question (Enonce,Theme_Id,NbReponses,Illustration)
     VALUES('Quel est la valeur de x ? String x; Boolean y = ( x == 5 ); if (y) {x = 2);',1,3, null);
INSERT INTO Question (Enonce,Theme_Id,NbReponses,Illustration)
     VALUES('Quel est la valeur de x ? String x = 5 ; Boolean y = ( x == 5 ); if (y) {x = 2);',1,3, null);
INSERT INTO Question (Enonce,Theme_Id,NbReponses,Illustration)
     VALUES('Quel est la valeur de x ? String x = 3 ; Boolean y = ( x == 5 ); if (y) {x = 5);',1,3, null);
INSERT INTO Question (Enonce,Theme_Id,NbReponses,Illustration)
     VALUES('Que renvoie cette fonction ? Public static boolean uneFonction (int unEntier) { int x = 3; if (x == unEntier) { return true } else { return false };',2,3, null);
INSERT INTO Question (Enonce,Theme_Id,NbReponses,Illustration)
     VALUES('Que renvoie cette fonction ? Public static boolean uneFonction (int unEntier) { int x = 3; if (x != unEntier) { return true } else { return false };',2,3, null);
INSERT INTO Question (Enonce,Theme_Id,NbReponses,Illustration)
     VALUES('Que renvoie cette fonction ? Public static boolean uneFonction (int unEntier) { int x = 3; if (x == unEntier) { return false } else { return true };',2,3, null);
INSERT INTO Question (Enonce,Theme_Id,NbReponses,Illustration)
     VALUES('Que renvoie cette fonction ? Public static boolean uneFonction (int unEntier) { unEntier = 3; int x = 3; if (x == unEntier) { return true } else { return false };',2,3, null);
INSERT INTO Question (Enonce,Theme_Id,NbReponses,Illustration)
     VALUES('Que renvoie cette fonction ? Public static boolean uneFonction (int unEntier) { unAutreEntier = 3; int x = 3; if (x == unEntier) { return true } else { return false };',2,3, null);
INSERT INTO Question (Enonce,Theme_Id,NbReponses,Illustration)
     VALUES('Que renvoie cette proc�dure ? Public static boolean uneProc�dure (int unEntier) { int x = unEntier; if (x == unEntier) { inserer(3) } else { delete(unEntier) };',3,3, null);
INSERT INTO Question (Enonce,Theme_Id,NbReponses,Illustration)
     VALUES('Que renvoie cette proc�dure ? Public static boolean uneProc�dure (int unEntier) { int x = unEntier; if (x != unEntier) { inserer(3) } else { delete(unnEtier) };',3,3, null);
INSERT INTO Question (Enonce,Theme_Id,NbReponses,Illustration)
     VALUES('Que renvoie cette proc�dure ? Public static boolean uneProc�dure (int unEntier) { int x = unEntier; if (x == unEntier) { delete(unEntier) } else { inserer(3) };',3,3, null);
INSERT INTO Question (Enonce,Theme_Id,NbReponses,Illustration)
     VALUES('Que renvoie cette proc�dure ? Public static boolean uneProc�dure (int unEntier) { unEntier = 3; int x = unEntier; if (x == unEntier) { inserer(3) } else { delete(unEtier) };',3,3, null);
INSERT INTO Question (Enonce,Theme_Id,NbReponses,Illustration)
     VALUES('Que renvoie cette proc�dure ? Public static boolean uneProc�dure (int unEntier) { unAutreEntier = 3; int x = unEntier; if (x == unEntier) { inserer(3) } else { delete(unEtier) };',3,3, null);
INSERT INTO Question (Enonce,Theme_Id,NbReponses,Illustration)
     VALUES('Quel sont les �l�ments de la liste ? List<int> uneListe = new List<int>; uneListe.add(5);uneListe.add(4);uneListe.add(3);uneListe.removeAt(5);',4,3, null);
INSERT INTO Question (Enonce,Theme_Id,NbReponses,Illustration)
     VALUES('Quel sont les �l�ments de la liste ? List<int> uneListe = new List<int>; uneListe.add(5);uneListe.add(''uneChaine'');uneListe.add(3);uneListe.removeAt(5);',4,3, null);
INSERT INTO Question (Enonce,Theme_Id,NbReponses,Illustration)
     VALUES('Quel sont les �l�ments de la liste ? List<int> uneListe = new List<int>; uneListe.add(5);uneListe.add(4);uneListe.add(3);uneListe.removeAt(5);',4,3, null);
INSERT INTO Question (Enonce,Theme_Id,NbReponses,Illustration)
     VALUES('Quel sont les �l�ments de la liste ? List<int> uneListe = new List<int>; uneListe.add(5);uneListe.add(4);uneListe.add(5);uneListe.add(3);uneListe.removeAt(5);',4,3, null);
INSERT INTO Question (Enonce,Theme_Id,NbReponses,Illustration)
     VALUES('Quel sont les �l�ments de la liste ? List<int> uneListe = new List<int>; uneListe.add(5);uneListe.add(4);uneListe.add(3);uneListe.removeAt(5);uneListe.removeAt(4);uneListe.add(4);uneListe.removeAt(5);',4,3, null);		
			
-- TABLE REPONSE --
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (001,0001,'x vaut 3',1);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (002,0001,'x vaut 5',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (003,0001,'x vaut 2',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (004,0001,'x vaut null',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (001,0002,'x vaut 3',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (002,0002,'x vaut 5',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (003,0002,'x vaut 2',1);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (004,0002,'x vaut null',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (001,0003,'x vaut 3',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (002,0003,'x vaut 5',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (003,0003,'x vaut 2',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (004,0003,'x vaut null',1);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (001,0004,'x vaut 3',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (002,0004,'x vaut 5',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (003,0004,'x vaut 2',2);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (004,0004,'x vaut null',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (001,0005,'x vaut 3',1);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (002,0005,'x vaut 5',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (003,0005,'x vaut 2',0);   
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (004,0005,'x vaut null',0);

INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (001,0006,'true',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (002,0006,'false',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (003,0006,'on ne peut pas savoir',1);   
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (001,0007,'true',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (002,0007,'false',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (003,0007,'on ne peut pas savoir',1);   
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (001,0008,'true',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (002,0008,'false',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (003,0008,'on ne peut pas savoir',1);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (001,0009,'true',1);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (002,0009,'false',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (003,0009,'on ne peut pas savoir',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (001,0010,'true',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (002,0010,'false',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (003,0010,'on ne peut pas savoir',1);

INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (001,0011,'inserer(3)',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (002,0011,'delete(unEntier)',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (003,0011,'on ne peut pas savoir',1);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (001,0012,'inserer(3)',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (002,0012,'delete(unEntier)',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (003,0012,'on ne peut pas savoir',1);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (001,0013,'inserer(3)',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (002,0013,'delete(unEntier)',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (003,0013,'on ne peut pas savoir',1);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (001,0014,'inserer(3)',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (002,0014,'delete(unEntier)',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (003,0014,'on ne peut pas savoir',1);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (001,0015,'inserer(3)',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (002,0015,'delete(unEntier)',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (003,0015,'on ne peut pas savoir',1);

INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (001,0016,'{5, 4, 3}',1);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (002,0016,'{5, 4, 3, 5}',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (003,0016,'{5, 4}',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (004,0016,'Aucune de ces r�ponses',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (001,0017,'{5, 4, 3}',1);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (002,0017,'{5, 4, 3, 5}',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (003,0017,'{5, 4}',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (004,0017,'Aucune de ces r�ponses',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (001,0018,'{5, 4, 3}',1);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (002,0018,'{5, 4, 3, 5}',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (003,0018,'{5, 4}',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (004,0018,'Aucune de ces r�ponses',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (001,0019,'{5, 4, 3}',1);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (002,0019,'{5, 4, 3, 5}',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (003,0019,'{5, 4}',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (004,0019,'Aucune de ces r�ponses',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (001,0020,'{5, 4, 3}',1);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (002,0020,'{5, 4, 3, 5}',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (003,0020,'{5, 4}',0);
INSERT INTO Reponse (Id,Question_Id,Libelle,EstCorrect)
     VALUES (004,0020,'Aucune de ces r�ponses',0);


-- TABLE QuestionPosee Mettre en integer les champs ... --
-- TABLE Reponse Mettre en integer les champs ... --
