package annotation.vogella;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
ElementType.ANNOTATION_TYPE can be applied to an annotation type.
ElementType.CONSTRUCTOR can be applied to a constructor.
ElementType.FIELD can be applied to a field or property.
ElementType.LOCAL_VARIABLE can be applied to a local variable.
ElementType.METHOD can be applied to a method-level annotation.
ElementType.PACKAGE can be applied to a package declaration.
ElementType.PARAMETER can be applied to the parameters of a method.
ElementType.TYPE can be applied to any element of a class.
 */
/*
 * RetentionPolicy could be , Runtime, source and class
 */
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface CanRunAnnotation {

}
