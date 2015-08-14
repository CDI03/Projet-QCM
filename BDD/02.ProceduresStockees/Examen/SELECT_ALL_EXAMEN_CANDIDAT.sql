CREATE PROCEDURE SELECT_ALL_EXAMEN_CANDIDAT
	@idCandidat char(5)
AS
BEGIN
	SELECT 
		 t.Id as Test_Id,
		 t.Libelle as Test_Libelle,
		 t.Duree,
		 t.SeuilHaut,
		 t.SeuilBas,
		 e.Id as Examen_Id,
		 e.DatePassage,
		 e.Etat,
		 e.TempsRestant
	FROM Examen e
		 inner join Test t on e.Test_Id = t.Id
	WHERE e.Candidat_Id = @idCandidat;
END
GO
