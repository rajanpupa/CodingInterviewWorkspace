//package com.ktm.annotation.other;
//
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
//@Target(ElementType.METHOD)
//@Retention(RetentionPolicy.RUNTIME)
//@interface Test {
//    String info() default "";
//}
//
//
//class Annotated {
//    @Test(info = "AWESOME")
//    public void foo(String myParam) {
//        System.out.println("This is " + myParam);
//    }
//}
//
//
//
