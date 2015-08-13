CREATE PROCEDURE UPDATE_REPONDU_QUESTIONPOSEE
	@Ordre int,
	@Examen_Id int
AS
BEGIN
	Update QuestionPosee 
	set	Repondu = 1
    WHERE Examen_Id = @Examen_Id AND Ordre = @Ordre;
END