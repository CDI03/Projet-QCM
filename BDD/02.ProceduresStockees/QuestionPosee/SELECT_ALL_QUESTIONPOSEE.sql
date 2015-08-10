CREATE PROCEDURE SELECT_ALL_QUESTIONPOSEE
	@Examen_Id integer
AS
BEGIN
	SELECT 
		Ordre,
		Marque,
		Repondu
	FROM QuestionPosee
	WHERE Examen_Id = @Examen_Id
END