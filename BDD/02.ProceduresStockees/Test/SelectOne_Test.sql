USE [TP_QCM]
GO

CREATE PROCEDURE SelectOne_Test
	@Id INTEGER
AS
BEGIN
	SELECT Id,Libelle,Duree,SeuilHaut,SeuilBas
	FROM Test
	WHERE Id = @Id;
END

