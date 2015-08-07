CREATE PROCEDURE INSERT_REPONSEDONNEE
	@Examen_Id integer,
	@QuestionPosee_Ordre integer,
	@Reponse_Id integer,
	@Question_Id integer
AS
BEGIN
	Insert 
	into ReponseDonnee (Examen_Id, QuestionPosee_Ordre, Reponse_Id, Question_Id)
    VALUES (@Examen_Id,@QuestionPosee_Ordre,@Reponse_Id,@Question_Id);
END