package com;

import java.util.Comparator;

public class SortStudentByMarks  implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
	
		return s1.getMarks().compareTo(s2.getMarks());
	}
	

}
