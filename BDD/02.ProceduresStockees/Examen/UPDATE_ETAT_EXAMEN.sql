CREATE PROCEDURE UPDATE_ETAT_EXAMEN
	@Examen_Id int,
	@Etat char(3)
AS
BEGIN
	Update Examen
	set	Etat = @Etat
    WHERE Id = @Examen_Id;
END