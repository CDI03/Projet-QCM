USE [TP_QCM]
GO
CREATE PROCEDURE Delete_Section
	@Test_Id int,
	@Theme_Id int
AS
BEGIN
	Delete from Section
	where Test_Id = @Test_Id and Theme_Id=@Theme_Id;
END
