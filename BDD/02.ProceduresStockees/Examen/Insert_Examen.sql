USE [TP_QCM]
GO

CREATE PROCEDURE Insert_Examen
	@Test_Id integer,
	@Candidat_Id char(5),
	@DatePassage datetime
AS
BEGIN
	insert into Examen (Test_Id,Candidat_Id,TempsRestant,DatePassage,Etat)
     values (@Test_Id,@Candidat_Id,null,@DatePassage,'EA');
END