USE [TP_QCM]
GO
CREATE PROCEDURE Insert_Section
	@Test_Id int,
	@Theme_Id int,
	@NombreQuestion int
AS
BEGIN
	INSERT INTO Section (Test_Id,Theme_Id,NombreQuestion)
     VALUES (@Test_Id,@Theme_Id,@NombreQuestion);
END