CREATE PROCEDURE UPDATE_ETAT_QUESTIONPOSEE
	@Ordre int,
	@Examen_Id int,
	@Repondu bit,
	@Marque bit
AS
BEGIN
	Update QuestionPosee 
	set	Repondu = @Repondu, Marque = @Marque
    WHERE Examen_Id = @Examen_Id AND Ordre=@Ordre;
END