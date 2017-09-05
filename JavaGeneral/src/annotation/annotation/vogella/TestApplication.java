package annotation.vogella;

import java.lang.reflect.Method;

public class TestApplication {

    public static void main(String[] args) {

        SimpleClass runner = new SimpleClass();
        Method[] methods = runner.getClass().getMethods();

        for (Method method : methods) {
            CanRunAnnotation annos = method.getAnnotation(CanRunAnnotation.class);
            if (annos != null) {
                try {
                    method.invoke(runner);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
} 
