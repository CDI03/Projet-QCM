/**
 * 
 */
function choixQuestion(leForm,numeroQuestion)
	{
		leForm.hiddenField.value="repasserQuestion";
		leForm.choixNumQuestion.value=numeroQuestion;
	    leForm.submit();
	}