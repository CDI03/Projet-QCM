CREATE PROCEDURE SELECT_ALL_SECTION_BY_EXAMEN
	@IdTest INTEGER
AS
BEGIN
	SELECT 
			s.NombreQuestion,
			th.Id as Id_Theme,
			th.Libelle as Libelle_Theme
			FROM Section s 
				 inner join Theme th on s.Theme_Id = th.Id
			WHERE s.Test_Id=@IdTest;
END
GO
