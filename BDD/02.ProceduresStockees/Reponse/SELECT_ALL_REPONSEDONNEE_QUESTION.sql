CREATE PROCEDURE SELECT_ALL_REPONSEDONNEE_QUESTION
	@IdExamen INTEGER,
	@IdQuestion INTEGER
AS
BEGIN
	SELECT 
		rd.Reponse_Id as Id_Reponse
	FROM
		QuestionPosee qp 
	    inner join ReponseDonnee rd on rd.Question_Id = qp.Question_Id
	    inner join Question qu on qp.Question_Id = qu.Id
	WHERE qp.Examen_Id = @IdExamen and qp.Question_Id = @IdQuestion
END
GO