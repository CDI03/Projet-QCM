CREATE PROCEDURE Update_Reponse
	@Id integer,
	@Question_Id integer,
	@Libelle varchar(150),
	@EstCorrect bit
AS
BEGIN
	update Reponse set Libelle = @Libelle, EstCorrect = @EstCorrect
     where Id = @Id and  Question_Id = @Question_Id;
END