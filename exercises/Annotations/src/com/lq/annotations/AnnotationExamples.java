package com.lq.annotations;

import java.util.ArrayList;

//@SuppressWarnings("all")
//@SuppressWarnings("unused")
@SuppressWarnings("rawtypes")
public class AnnotationExamples {
	ArrayList arrayList = new ArrayList();
	int k = 0;
	
	@SuppressWarnings({"unused", "unchecked"})
	public void myMethod1() {
		arrayList.add(new String());
		int j = 0;
		@SuppressWarnings("unused") int i = 0;
	}
	
	public String toString() {
		int i = 0;
		return super.toString();
	}
}
