CREATE PROCEDURE SELECT_COUNT_NBCORRECTES
	@IdExamen INTEGER
AS
BEGIN
	SELECT 
			count(*) as countNbCorrectes
			FROM QuestionPosee qp
				 inner join Reponse r on qp.Question_Id = r.Question_Id
			WHERE r.EstCorrect = '1' and qp.Examen_Id = @IdExamen;
END
GO
