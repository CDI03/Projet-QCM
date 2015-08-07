ALTER PROCEDURE SelectAll_Themes
AS
BEGIN
	Select t.Id as Theme_Id, t.Libelle as Theme_Libelle, t.Competence_Id, c.Libelle as Competence_Libelle 
	from Theme t 
	inner join Competence c
	on (t.Competence_Id = c.Id)
	order by t.Competence_Id, t.Id;
END