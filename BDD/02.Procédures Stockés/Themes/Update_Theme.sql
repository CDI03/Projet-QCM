CREATE PROCEDURE Update_Theme
	@Id int,
	@Libelle varchar(50),
	@Competence_Id int
AS
BEGIN
	Update Theme 
	set	Libelle = @Libelle,
		Competence_Id = @Competence_Id
 WHERE Id = @Id;
END