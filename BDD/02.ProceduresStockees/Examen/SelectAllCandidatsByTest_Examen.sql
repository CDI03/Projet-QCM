USE [TP_QCM]
GO
/****** Object:  StoredProcedure [dbo].[SelectAllCandidatsByTest_Examen]    Script Date: 08/13/2015 14:42:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[SelectAllCandidatsByTest_Examen]
	 @idTest int
AS
BEGIN
	Select c.Id, c.Nom, c.Prenom, c.MotDePasse
	from Test t
	inner join Examen e on t.Id = e.Test_Id
	inner join Candidat c on e.Candidat_Id = c.Id
	where t.Id = @idTest;
END