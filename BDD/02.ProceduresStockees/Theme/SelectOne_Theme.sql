USE [TP_QCM]
GO

CREATE PROCEDURE SelectOne_Theme
	@Id INTEGER
AS
BEGIN
	Select t.Id as Theme_Id, t.Libelle as Theme_Libelle, t.Competence_Id, COUNT(t.Id) as NbQuestions
	from Theme t
	inner join Question q on (t.Id = q.Theme_Id)
	where t.Competence_Id = 1 and t.Id = @Id
	group by t.Id, t.Libelle, t.Competence_Id
	order by t.Id;
END
