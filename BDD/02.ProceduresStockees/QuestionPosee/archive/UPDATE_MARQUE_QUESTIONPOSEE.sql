CREATE PROCEDURE UPDATE_MARQUE_QUESTIONPOSEE
	@Ordre int,
	@Examen_Id int
AS
BEGIN
	Update QuestionPosee 
	set	Marque = 1
    WHERE Examen_Id = @Examen_Id AND Ordre=@Ordre;
END