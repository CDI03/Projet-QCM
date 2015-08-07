CREATE PROCEDURE INSERT_QUESTIONPOSEE
	@Examen_Id integer,
	@Question_Id integer,
	@Ordre integer
AS
BEGIN
	Insert into QuestionPosee (Examen_Id,Question_Id,Ordre,Marque,Repondu)
     		VALUES (@Examen_Id,@Question_Id,@Ordre,0,0);
END