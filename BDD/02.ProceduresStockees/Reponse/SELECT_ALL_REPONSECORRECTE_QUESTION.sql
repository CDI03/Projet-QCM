CREATE PROCEDURE SELECT_ALL_REPONSECORRECTE_QUESTION
	@IdExamen INTEGER,
	@IdQuestion INTEGER
AS
BEGIN
	SELECT 
		r.Id as Id_Reponse
	FROM
		QuestionPosee qp 
	    inner join Reponse r on qp.Question_Id = r.Question_Id
	    inner join Question qu on qp.Question_Id = qu.Id
	WHERE	qp.Examen_Id = @IdExamen and r.EstCorrect = '1' and qp.Question_Id = @IdQuestion
END
GO
