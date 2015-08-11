CREATE PROCEDURE SELECT_ONE_TEST
	@IdTest INTEGER
AS
BEGIN
	SELECT 
			s.NombreQuestion,
			th.Id as Id_Theme,
			th.Libelle as Libelle_Theme,
			q.Illustration,
			q.Enonce,
			q.Id as Id_Question,
			r.EstCorrect,
			r.Libelle as Libelle_Reponse,
			r.Id as Id_Reponse
			FROM Section s 
				 inner join Theme th on s.Theme_Id = th.Id
				 inner join Question q on th.Id = q.Theme_Id
				 inner join Reponse r on q.Id = r.Question_Id
			WHERE s.Test_Id=@IdTest;
END
GO
