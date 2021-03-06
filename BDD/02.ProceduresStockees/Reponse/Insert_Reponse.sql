CREATE PROCEDURE Insert_Reponse
	@Id integer,
	@Question_Id integer,
	@Libelle varchar(150),
	@EstCorrect bit
AS
BEGIN
	declare @comptage integer;
	Select @comptage = COUNT(*) from Reponse where Question_Id = @Question_Id;
	set @Id = (@comptage + 1);
	insert into Reponse (Id, Question_Id, Libelle, EstCorrect)
     VALUES (@Id, @Question_Id, @Libelle,@EstCorrect);
END