package annotation.oracle1;

import java.lang.annotation.Documented;

// parameterized Annotation
// to make the annotation information appear in the javadoc use this annotation.
@Documented
@interface ParameterizedAnnotation {
	String author();
	String date();

	int currentRevision() default 1;

	String lastModified() default "N/A";

	String lastModifiedBy() default "N/A";

	// Note use of array
	String[] reviewers();
}
