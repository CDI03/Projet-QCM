CREATE PROCEDURE SelectAllByTheme_Question
	@Theme_Id integer
AS
BEGIN
	Select Id as Question_Id,Enonce,NbReponses,Illustration 
		from Question 
		where Theme_Id = @Theme_Id;
END