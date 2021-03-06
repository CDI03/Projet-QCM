USE [TP_QCM]
GO
/****** Object:  StoredProcedure [dbo].[SelectAllByTest_Section]    Script Date: 08/13/2015 11:55:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[SelectAllByTest_Section]
	@Test_Id integer
AS
BEGIN
	Select s.Test_Id, s.NombreQuestion, s.Theme_Id, t.Libelle, t.Competence_Id 
	from Section s
	inner join Theme t on s.Theme_Id = t.Id
	where Test_Id = @Test_Id;
END