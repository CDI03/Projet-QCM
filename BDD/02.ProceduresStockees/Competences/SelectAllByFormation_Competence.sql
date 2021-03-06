CREATE PROCEDURE SelectAllByFormation_Competence
	@Formation_Id char(8) 
AS
BEGIN
	Select c.Id as Competence_Id, c.Libelle as Competence_Libelle
	from Competence c 
	inner join CompetenceFormation cf
	on (c.Id = cf.Competence_Id)
	where cf.Formation_Id = @Formation_Id
	order by c.Id;
END