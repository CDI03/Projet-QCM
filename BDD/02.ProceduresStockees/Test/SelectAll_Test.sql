
CREATE PROCEDURE SelectAll_Test
AS
BEGIN
	Select Id, Libelle,Duree, SeuilHaut, SeuilBas
	from Test;
END