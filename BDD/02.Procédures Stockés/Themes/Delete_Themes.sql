ALTER PROCEDURE Delete_Themes
	@Id int
AS
BEGIN
	Delete from Theme where Id = @Id;
END