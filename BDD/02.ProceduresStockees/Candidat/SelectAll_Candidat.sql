USE [TP_QCM]
GO


CREATE PROCEDURE SelectAll_Candidat
AS
BEGIN
	Select c.Id, c.Nom, c.Prenom, c.MotDePasse
	from Candidat c
END