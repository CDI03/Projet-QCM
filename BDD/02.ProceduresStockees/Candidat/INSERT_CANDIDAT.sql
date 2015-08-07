CREATE PROCEDURE INSERT_CANDIDAT
	@Nom varchar(30),
	@Prenom varchar(20),
	@MotDePasse varchar(30)
AS
BEGIN
DECLARE @nomTronque char(3) = UPPER(LEFT(@Nom, 3));
DECLARE @prenomEnForme varchar(20) = UPPER(LEFT(@Prenom,1))+LOWER(SUBSTRING(@Prenom,2, 20));
DECLARE @comptage int;
DECLARE @comptageId char(2);
DECLARE @Identifiant char(5);
	SELECT @comptage = COUNT(*) FROM Candidat where Nom like (@nomTronque + '%');
		IF ((@comptage+1)<= 9)
			SET @comptageId = '0' + CAST((@comptage+1) AS CHAR);
		ELSE
			SET @comptageId = CAST((@comptage+1) AS CHAR);
	SET @Identifiant = @nomTronque + @comptageId;
	INSERT INTO Candidat (Id, Nom , Prenom, MotDePasse) values (@Identifiant, UPPER(@Nom), @prenomEnForme, @MotDePasse);
END
