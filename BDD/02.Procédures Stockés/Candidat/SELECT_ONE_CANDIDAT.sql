CREATE PROCEDURE SELECT_ONE_CANDIDAT
	@Id char(5),
	@MotDePasse varchar(30)
AS
BEGIN
	SELECT Nom, Prenom 
			FROM Candidat
			WHERE Id=@Id AND MotDePasse=@MotDePasse;
END
GO
