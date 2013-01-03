package validator;
import java.lang.annotation.Annotation;
import javax.xml.bind.ValidationException;

public interface ValidateHandler<T extends Annotation>
{
   public void validate(T settings, Object value)
      throws ValidationException;
            
   public Class<T> getSettingsType();
}