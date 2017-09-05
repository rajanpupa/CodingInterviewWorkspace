package annotation.vogella;

public class SimpleClass {

    public void method1() {
        System.out.println("method1");
    }

    @CanRunAnnotation
    public void method2() {
        System.out.println("method2");
    }

    @CanRunAnnotation
    public void method3() {
        System.out.println("method3");
    }
    
    public void method4() {
        System.out.println("method4");
    }

    @CanRunAnnotation
    public void method5() {
        System.out.println("method5");
    }
    
    @CanRunAnnotation
    public void method7() {
        System.out.println("method7");
    }
} 