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
	
	
	
	//element 是 AnnotatedElement 对象实例
	public static void validate(AnnotatedElement element, Object value) {
        Validate v;
        ValidateHandler vh;
        Annotation a;
        
        // 从该方法上返回所有的Annotation
        //	@ValidateLength(min=6,max=15)
    	//  @ValidateExpr("a*b")
        
        Annotation[] annotations = element.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
        	
        	
            // 如果该Annotation有类型为Validate的Annotation，则说明这是我们校验
            // 框架所使用的Annotation。
        	
        	// ValidateLength本身有getAnnotation(Validate.class)
        	
            v = annotations[i].annotationType().getAnnotation(Validate.class);
            
            if (v != null) {
                try {
                	
                	//注释ValidateLength将其操作类ValidateLengthHander注入在Validate的value里
                    // 使用Annotation中定义的ValidateHandler类来生成ValidateHandler的实例
                    vh = v.value().newInstance();
                    // 使用创建的ValidateHandler来做校验操作。
                    // 校验过程中可以抛出ValidationException
                    vh.validate(annotations[i], value);
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        }
    }
}
