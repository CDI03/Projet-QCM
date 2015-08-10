CREATE PROCEDURE Delete_Reponse
	@Id int
AS
BEGIN
	Delete from Reponse where Id = @Id;
END
