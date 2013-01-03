package validator;

import java.util.regex.Pattern;
import javax.xml.bind.ValidationException;
//处理的时ValidateLength 这个annotation
public class ValidateLengthHandler
   implements ValidateHandler<ValidateLength>
{
   public void validate(ValidateLength settings,
                        Object value)
                        throws ValidationException
   {
    
		String i = (value != null)
                ? value.toString()
                : ""; 
	  if(i.length()<settings.min())
      {
         throw new ValidationException(i+" length is less than " +settings.min());
            
      }else	  if(i.length()>settings.max())
      {
          throw new ValidationException(i+" length is bigger than " +settings.max());
             
       }
   }

   public Class<ValidateLength> getSettingsType()
   {
      return ValidateLength.class;
   } 
}