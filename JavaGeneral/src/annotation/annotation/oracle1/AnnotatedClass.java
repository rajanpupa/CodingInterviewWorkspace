package annotation.oracle1;
/*
 * TO:SEE:
 * repeatable interface were not supported before jdk 1.8
 * @Repeatable meta-annotation with container annotation type.
 * https://docs.oracle.com/javase/tutorial/java/annotations/QandE/answers.html
 */

@ParameterizedAnnotation(
		author = "John Doe", 
		date = "3/17/2002", 
		currentRevision = 6, 
		lastModified = "4/12/2004", 
		lastModifiedBy = "Jane Doe",
		// Note array notation
		reviewers = { "Alice", "Bob", "Cindy" })
public class AnnotatedClass {

	// class code goes here

}
