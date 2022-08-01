package com;

import java.util.Comparator;

class SortStudentById  implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		
		return s1.getId()-s2.getId();
	}

}
