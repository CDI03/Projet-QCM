CREATE PROCEDURE SELECT_LAST_QUESTIONPOSEE
	@Examen_Id integer
AS
BEGIN
	SELECT 
		Ordre,
		Marque,
		Repondu
	FROM QuestionPosee
	WHERE Examen_Id = @Examen_Id AND (Marque=1 OR Repondu=1);
END