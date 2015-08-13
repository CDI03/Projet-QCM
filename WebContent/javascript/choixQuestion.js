/**
 * 
 */
function choixQuestion(leForm,numeroQuestion)
	{
		leForm.action.value="repasserQuestion";
		leForm.choixNumQuestion.value=numeroQuestion;
	    leForm.submit();
	}