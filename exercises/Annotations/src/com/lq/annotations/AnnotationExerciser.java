package com.lq.annotations;

import static java.lang.System.out;

import java.lang.annotation.Annotation;

public class AnnotationExerciser {

	public static void main(String[] args) {
		Class[] classes = { UseAnnotation.class };
		
		for (Class classObj: classes) {
			Annotation[] annotations = classObj.getAnnotations();
			out.printf("%s has %d annotations.%n", classObj.getName(), annotations.length);
			for (Annotation annotation: annotations) {
				if (annotation instanceof MyAnnotation) {
					MyAnnotation a = (MyAnnotation) annotation;
					out.println(a.name());
				}
			}
		}
	}

}
