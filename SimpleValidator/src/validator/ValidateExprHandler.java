package validator;
import java.util.regex.Pattern;
import javax.xml.bind.ValidationException;

public class ValidateExprHandler
   implements ValidateHandler<ValidateExpr>
{
   public void validate(ValidateExpr settings,
                        Object value)
                        throws ValidationException
   {
		String i = (value != null)
                 ? value.toString()
                 : ""; 
                         
      if (!Pattern.matches(settings.value(), i))
      {
         throw new ValidationException(i
            + " does not match the pattern "
            + settings.value());
      }
   }

   public Class<ValidateExpr> getSettingsType()
   {
      return ValidateExpr.class;
   } 
}