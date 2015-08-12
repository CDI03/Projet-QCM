CREATE PROCEDURE SELECT_ALL_INSCRIPTION
AS
BEGIN
	SELECT 
		p.Code as Code_Promotion,
		p.Numero as Numero_Promotion,
		c.Id as Id_Candidat,
		c.Nom as Nom_Candidat,
		c.Prenom as Prenom_Candidat,
		f.Id as Id_Formation,
		f.Titre as Titre_Formation	
	FROM Inscription i
		 inner join Formation f on i.Formation_Id = f.Id
		 inner join Candidat c on i.Candidat_Id = c.Id
		 inner join Promotion p on i.Promotion_Code = p.Code and i.Promotion_Numero = p.Numero and f.Id = p.Formation_Id
	ORDER BY c.Nom;
END