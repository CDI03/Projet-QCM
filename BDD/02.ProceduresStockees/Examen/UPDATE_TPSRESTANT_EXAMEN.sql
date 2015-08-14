CREATE PROCEDURE UPDATE_TPSRESTANT_EXAMEN
	@Examen_Id int,
	@TempsRestant integer
AS
BEGIN
	Update Examen
	set	TempsRestant = @TempsRestant
    WHERE Id = @Examen_Id;
END