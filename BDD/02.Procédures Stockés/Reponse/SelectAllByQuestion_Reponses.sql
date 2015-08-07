CREATE PROCEDURE SelectAllByQuestion_Reponses
	@Question_Id integer
AS
BEGIN
	Select r.Id as Reponse_Id, r.Question_Id, r.Libelle as Reponse_Libelle, r.EstCorrect as Reponse_EstCorrect 
		from Reponse r
		where r.Question_Id = @Question_Id;
END