ALTER PROCEDURE Insert_Question
	@Id integer,
	@Enonce text,
	@Theme_Id int
AS
BEGIN
	insert into Question (Enonce, Theme_Id)
     VALUES (@Enonce, @Theme_Id);
END