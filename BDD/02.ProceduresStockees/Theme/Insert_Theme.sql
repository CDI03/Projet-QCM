CREATE PROCEDURE Insert_Theme
	@Libelle varchar(50),
	@Competence_Id int
AS
BEGIN
	Insert into Theme (Libelle,Competence_Id)
     VALUES (@Libelle,@Competence_Id);
END