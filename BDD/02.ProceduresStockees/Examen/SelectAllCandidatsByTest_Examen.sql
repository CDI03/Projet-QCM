USE [TP_QCM]
GO

ALTER PROCEDURE [dbo].[SelectAllCandidatsByTest_Examen]
	 @idTest int
AS
BEGIN
	Select c.Id, c.Nom, c.Prenom, c.MotDePasse, e.DatePassage
	from Test t
	inner join Examen e on t.Id = e.Test_Id
	inner join Candidat c on e.Candidat_Id = c.Id
	where t.Id = @idTest and e.Etat='EA'
	order by e.DatePassage, c.Nom, c.Prenom;
END