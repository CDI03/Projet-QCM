CREATE PROCEDURE Update_Question
	@Id integer,
	@Enonce text,
	@Theme_Id int
AS
BEGIN
	update Question set Enonce = @Enonce
    where Id = @Id and  Theme_Id = @Theme_Id;
END