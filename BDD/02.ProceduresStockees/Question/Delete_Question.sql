CREATE PROCEDURE Delete_Question
	@Id int
AS
BEGIN
	Delete from Question where Id = @Id;
END
