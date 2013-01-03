package validator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Validate(ValidateLengthHandler.class) //��validateע���Լ���handler��


public @interface ValidateLength {
	  int min() default 0;
	  int max() default Integer.MAX_VALUE;
}