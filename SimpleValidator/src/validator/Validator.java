package validator;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
public class Validator {
	
	public static void validate(Object object){
		 for(Field f:object.getClass().getDeclaredFields()){
			 f.setAccessible(true);
			 try {
				validate(f,f.get(object));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		
		 
	}
	
	
	
	//element �� AnnotatedElement ����ʵ��
	public static void validate(AnnotatedElement element, Object value) {
        Validate v;
        ValidateHandler vh;
        Annotation a;
        
        // �Ӹ÷����Ϸ������е�Annotation
        //	@ValidateLength(min=6,max=15)
    	//  @ValidateExpr("a*b")
        
        Annotation[] annotations = element.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
        	
        	
            // �����Annotation������ΪValidate��Annotation����˵����������У��
            // �����ʹ�õ�Annotation��
        	
        	// ValidateLength������getAnnotation(Validate.class)
        	
            v = annotations[i].annotationType().getAnnotation(Validate.class);
            
            if (v != null) {
                try {
                	
                	//ע��ValidateLength���������ValidateLengthHanderע����Validate��value��
                    // ʹ��Annotation�ж����ValidateHandler��������ValidateHandler��ʵ��
                    vh = v.value().newInstance();
                    // ʹ�ô�����ValidateHandler����У�������
                    // У������п����׳�ValidationException
                    vh.validate(annotations[i], value);
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        }
    }
}
