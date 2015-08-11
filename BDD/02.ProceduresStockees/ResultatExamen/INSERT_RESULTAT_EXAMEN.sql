CREATE PROCEDURE INSERT_RESULTAT_EXAMEN
	@Examen_Id integer,
	@Test_Id integer,
	@Theme_Id integer,
	@NbQuestionsReussies integer,
	@NbQuestionsTotales integer
AS
BEGIN
	INSERT 
	INTO ResultatExamen (Examen_Id, Test_Id, Theme_Id, NbQuestionsReussies, NbQuestionsTotales)
    VALUES (@Examen_Id, @Test_Id, @Theme_Id, @NbQuestionsReussies, @NbQuestionsTotales);
END