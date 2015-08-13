USE [TP_QCM]
GO

CREATE PROCEDURE Delete_Examen
	@Test_Id integer,
	@Candidat_Id char(5),
	@DatePassage datetime
AS
BEGIN
	delete from Examen
     where Test_Id = @Test_Id
	 and Candidat_Id = @Candidat_Id
	 and DatePassage = @DatePassage;
END