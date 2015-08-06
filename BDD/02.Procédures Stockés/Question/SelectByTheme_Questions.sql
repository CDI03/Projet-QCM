CREATE PROCEDURE SelectByTheme_Questions
	@Theme_Id integer
AS
BEGIN
	Select Id,Enonce,NbReponses,Illustration 
	from Question 
	where Theme_Id = @Theme_Id;
END