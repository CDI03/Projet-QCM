CREATE PROCEDURE SELECT_ALL_REPONSE_QUESTION
	@IdQuestion INTEGER
AS
BEGIN
	SELECT 
			EstCorrect,
			Libelle,
			Id,
			Question_Id
	FROM Reponse
	WHERE Question_Id = @IdQuestion;
END
GO
