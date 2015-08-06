CREATE PROCEDURE SelectAllSimple_Competences
AS
BEGIN
	Select c.Id as Competence_Id, c.Libelle as Competence_Libelle 
	from Competence c 
	order by c.Id;
END