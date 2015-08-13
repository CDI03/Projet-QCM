CREATE PROCEDURE NBQUESTIONPOSEE_BY_EXAMEN
	@Examen_Id integer
AS
	DECLARE @taille integer
	SELECT 
		@taille= count(*)
	FROM QuestionPosee
	WHERE Examen_Id = @Examen_Id
	RETURN @taille