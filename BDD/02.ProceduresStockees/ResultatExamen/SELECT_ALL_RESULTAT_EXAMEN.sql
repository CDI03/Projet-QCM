CREATE PROCEDURE SELECT_ALL_RESULTAT_EXAMEN
	@Examen_Id integer
AS
BEGIN
	SELECT
		re.Test_Id, 
		re.Theme_Id,
		t.Libelle as Theme_Libelle,
		re.NbQuestionsReussies, 
		re.NbQuestionsTotales
	FROM ResultatExamen re
		 inner join Theme t on re.Theme_Id = t.Id
	WHERE re.Examen_Id=@Examen_Id;
END