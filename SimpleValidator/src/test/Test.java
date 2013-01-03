package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import validator.Validator;


public class Test {
	public static void main(String[] args) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		
		TestUserBean  tus = new TestUserBean();
		tus.setEmail("a*a");
		
		Method setEmail = TestUserBean.class.getMethod("setEmail", String.class);
		setEmail.invoke(tus, "aaaaaab");
		
		try {
			
			Validator.validate(tus);
		
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
