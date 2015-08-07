CREATE PROCEDURE SelectAll_Formation
AS
BEGIN
	Select f.Id as Formation_Id, f.Titre as Formation_Titre 
	from Formation f 
	order by f.Id;
END