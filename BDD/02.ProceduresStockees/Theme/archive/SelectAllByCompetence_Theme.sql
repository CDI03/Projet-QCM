CREATE PROCEDURE SelectAllByCompetence_Theme
	@Competence_Id INTEGER
AS
BEGIN
	Select t.Id as Theme_Id, t.Libelle as Theme_Libelle, t.Competence_Id
	from Theme t 
	where t.Competence_Id = @Competence_Id
	order by t.Id;
END