CREATE PROCEDURE SELECT_ONE_QUESTIONPOSEE
	@Examen_Id integer,
	@Ordre integer
AS
BEGIN
	SELECT 
		qp.Ordre,
		qp.Marque,
		qp.Repondu,
		qp.Question_Id,
		qu.Illustration,
		qu.Enonce,
		qu.Theme_Id,
		t.Libelle
	FROM QuestionPosee qp
		 inner join Question qu on qp.Question_Id = qu.Id
		 inner join Theme t on qu.Theme_Id = t.Id
	WHERE Examen_Id = @Examen_Id AND Ordre=@Ordre;
END