CREATE PROCEDURE SELECT_ALL_QUESTION_THEME_EXAMEN
	@IdExamen INTEGER,
	@IdTheme INTEGER
AS
BEGIN
	SELECT 
		qu.Id as Question_Id
	FROM
		QuestionPosee qp 
	    inner join Question qu on qp.Question_Id = qu.Id
	WHERE qp.Examen_Id = @IdExamen and qu.Theme_Id = @IdTheme;
END
GO
