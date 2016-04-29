/* 
 * This js check the sign up credentials on the author sign up page
 */
function signupcheck()
{
	if ((document.form2.name.value=="")||(document.form2.lname.value=="")||(document.form2.username.value=="")||(document.form2.password.value=="")||(document.form2.retypepassword.value=="")||(document.form2.Email.value=="")||(document.form2.ReEmail.value=="")||(document.form2.company.value=="")||(document.form2.street.value=="")||(document.form2.city.value=="")||(document.form2.state.value=="")||(document.form2.country.value==""))
	{
		alert("Missing fields");
		return false;
	}
	else if ((document.form2.password.value != document.form2.retypepassword.value))
		{
			alert("Mismatch passwords");
			return false;
		}
	
	else if ((document.form2.Email.value != document.form2.ReEmail.value))
	{
			alert("Mismatch Email");
			return false;
	}
}