
-- AJOUT DES CONTRAINTES DE CLEFS ETRANGERES --
ALTER TABLE Promotion 
	ADD CONSTRAINT FK_Promotion_Employe
	FOREIGN KEY (Employe_Id)
	REFERENCES Employe(Id);

ALTER TABLE Promotion 
	ADD CONSTRAINT FK_Promotion_Formation
	FOREIGN KEY (Formation_Id)
	REFERENCES Formation(Id);

ALTER TABLE Inscription  
	ADD CONSTRAINT FK_Inscription_Promotion
	FOREIGN KEY (Formation_Id, Promotion_Numero,Promotion_Code)
	REFERENCES Promotion(Formation_Id, Numero, Code);	

ALTER TABLE CompetenceFormation
	ADD CONSTRAINT FK_CompetenceFormation_Competence 
	FOREIGN KEY (Competence_Id)
	REFERENCES Competence(Id);

ALTER TABLE CompetenceFormation
	ADD CONSTRAINT FK_CompetenceFormation_Formation 
	FOREIGN KEY (Formation_Id)
	REFERENCES Formation(Id);	

ALTER TABLE Theme
	ADD CONSTRAINT FK_Theme_Competence 
	FOREIGN KEY (Competence_Id)
	REFERENCES Competence(Id);
	
ALTER TABLE Section  
	ADD CONSTRAINT FK_Section_Theme
	FOREIGN KEY (Theme_Id)
	REFERENCES Theme(Id);

ALTER TABLE Section  
	ADD CONSTRAINT FK_Section_Test
	FOREIGN KEY (Test_Id)
	REFERENCES Test(Id);

ALTER TABLE Examen   
	ADD CONSTRAINT FK_Examen_Test
	FOREIGN KEY (Test_Id)
	REFERENCES Test(Id);
	
ALTER TABLE Examen   
	ADD CONSTRAINT FK_Examen_Candidat
	FOREIGN KEY (Candidat_Id)
	REFERENCES Candidat(Id);

ALTER TABLE ResultatExamen   
	ADD CONSTRAINT FK_ResultatExamen_Theme
	FOREIGN KEY (Theme_Id)
	REFERENCES Theme(Id);
	
ALTER TABLE ResultatExamen   
	ADD CONSTRAINT FK_ResultatExamen_Test
	FOREIGN KEY (Test_Id)
	REFERENCES Test(Id);

ALTER TABLE ResultatExamen   
	ADD CONSTRAINT FK_ResultatExamen_Examen
	FOREIGN KEY (Examen_Id)
	REFERENCES Examen(Id);

ALTER TABLE Question  
	ADD CONSTRAINT FK_Question_Theme
	FOREIGN KEY (Theme_Id)
	REFERENCES Theme(Id);
 
ALTER TABLE Reponse  
	ADD CONSTRAINT FK_Reponse_Question
	FOREIGN KEY (Question_Id)
	REFERENCES Question(Id);

ALTER TABLE QuestionPosee   
	ADD CONSTRAINT FK_QuestionPosee_Examen
	FOREIGN KEY (Examen_Id)
	REFERENCES Examen(Id);
	
ALTER TABLE QuestionPosee   
	ADD CONSTRAINT FK_QuestionPosee_Question
	FOREIGN KEY (Question_Id)
	REFERENCES Question(Id);

ALTER TABLE ReponseDonnee   
	ADD CONSTRAINT FK_ReponseDonnee_QuestionPosee
	FOREIGN KEY ( Examen_Id, QuestionPosee_Ordre)
	REFERENCES QuestionPosee(Examen_Id, Ordre);
	
ALTER TABLE ReponseDonnee   
	ADD CONSTRAINT FK_ReponseDonnee_Reponse
	FOREIGN KEY (Reponse_Id, Question_Id)
	REFERENCES Reponse(Id, Question_Id);

-- AJOUT DES CONTRAINTES DE TYPE CHECK --	
ALTER TABLE Promotion   
	ADD CONSTRAINT CK_Code
	CHECK (Code in ('FC', 'EA'));

ALTER TABLE Examen   
	ADD CONSTRAINT CK_Etat
	CHECK (Etat in ('EA', 'EC', 'FN'));
	