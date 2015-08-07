CREATE PROCEDURE SelectAll_Competences
AS
BEGIN
	Select c.Id as Competence_Id, c.Libelle as Competence_Libelle, f.Id as Formation_Id, f.Titre as Formation_Titre 
	from Competence c 
	inner join CompetenceFormation cf
	on (c.Id = cf.Competence_Id)
	inner join Formation f
	on (cf.Formation_Id = f.Id)
	order by c.Id, f.Id;
END