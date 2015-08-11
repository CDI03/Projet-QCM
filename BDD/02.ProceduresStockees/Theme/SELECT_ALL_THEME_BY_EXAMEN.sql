CREATE PROCEDURE SELECT_ALL_THEME_BY_EXAMEN
	@Examen_Id int
AS
BEGIN
		SELECT 
				th.Libelle as Theme_Libelle,
				th.Id as Theme_Id
		FROM
				QuestionPosee qp 
			    inner join Question qu on qp.Question_Id = qu.Id
				inner join Theme th on qu.Theme_Id = th.Id
		WHERE	qp.Examen_Id = @Examen_Id
		GROUP BY th.Libelle,th.Id;
END