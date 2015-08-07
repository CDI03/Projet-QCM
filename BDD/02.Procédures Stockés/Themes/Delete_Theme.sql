CREATE PROCEDURE Delete_Theme
	@Id int
AS
BEGIN
	Delete from Theme where Id = @Id;
END