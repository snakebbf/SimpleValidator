package test;

import validator.ValidateExpr;
import validator.ValidateLength;

public class TestUserBean {

	@ValidateLength(min=6,max=15)
	@ValidateExpr("a*b")
	private String email;

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	
}
