//package com.ktm.annotation.other;
//
//import java.lang.reflect.Method;
//
//public class TestAnnltationParser {
//	
//	public void parse(Class clazz) throws Exception {
//		Method[] methods = clazz.getMethods();
//
//		for (Method method : methods) {
//			if (method.isAnnotationPresent(Test.class)) {
//				Test test = method.getAnnotation(Test.class);
//				String info = test.info();
//
//				if ("AWESOME".equals(info)) {
//					System.out.println("info is awesome!");
//					// try to invoke the method with param
//					method.invoke(Annotated.class.newInstance(), info);
//				}
//			}
//		}
//	}
//	
//}