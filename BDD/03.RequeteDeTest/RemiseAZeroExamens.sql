--refaire l'update de l'etat du test a EA
UPDATE Examen set Etat = 'EA' where Etat = 'EC';
UPDATE Examen set Etat = 'EA' where Etat = 'FN';
delete from ResultatExamen;
delete from ReponseDonnee;
delete from QuestionPosee;