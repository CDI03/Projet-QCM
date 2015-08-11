CREATE PROCEDURE SELECT_ALL_QUESTION_SECTION
	@IdTheme INTEGER
AS
BEGIN
	SELECT 
			Illustration,
			Enonce,
			Id,
			Theme_Id
	FROM Question
	WHERE Theme_Id = @IdTheme;
END
GO
