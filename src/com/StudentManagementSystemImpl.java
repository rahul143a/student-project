package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class StudentManagementSystemImpl  implements StudentManagementSystem   {
	Scanner scan =new Scanner(System.in);

	LinkedHashMap<Integer, Student> db=new  LinkedHashMap<Integer, Student>();

	@Override
	public void addStudent() {

		System.out.println("Enter   Id, Name, Age and Marks :");

		int id=scan.nextInt();
		String name=scan.next();
		int age =scan.nextInt();
		double marks=scan.nextDouble();

		Student std =new Student(id, name, age, marks);
		db.put(id, std);
		System.out.println("Student Record Is Inserted Successfully.");
	}

	@Override
	public void removeStudent() {
		System.out.println("Enter the student id to remove :");
		int id=scan.nextInt();

		if (db.containsKey(id)) {
			db.remove(id);
			System.out.println("Student is removed Successfully. ");
		}
		else {
			try {
				throw new StudentNotFoundException("Student Data Not Found!"); 

			} catch ( StudentNotFoundException s) {

				System.out.println(s.getMessage());

			}
		}
	}

	@Override
	public void removeAllStudents() {

		db.clear();
		System.out.println("All students record is removed");


	}

	@Override
	public void displayStudent() {
		System.out.println("Enter the Student Id To Display : ");
		int id=scan.nextInt();

		if (db.containsKey(id)) {
			//Student std=db.get(id);
			//System.out.println(std); we can do in both ways.
			System.out.println(db.get(id));
		}
		else {
			try {
				throw new StudentNotFoundException("Student Data Not Found!"); 

			} catch ( StudentNotFoundException s) {

				System.out.println(s.getMessage());

			}
		}
	}

	@Override
	public void displayAllStudents() {

		Set<Integer> st=db.keySet();

		for (Integer id : st) {
			System.out.println(db.get(id));	
		}
	}

	@Override
	public void updateStudent() {
		System.out.println("Enter the student id update :");
		int id =scan.nextInt();
		if (db.containsKey(id)) {
			System.out.println(db.get(id));
			Student std=db.get(id);
			System.out.println("\n Select The Option To Update");
			System.out.println(" 1) : Name \n 2) : Age \n 3) : Marks");
			int choice=scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Name To Update");
				String name=scan.next();
				std.setName(name);
				System.out.println("Name is updated");
				break;
			case 2:
				System.out.println("Enter Age To Update");
				int age=scan.nextInt();
				std.setAge(age);
				System.out.println("Age is updated");
				break;
				
			case 3:
				System.out.println("Enter Marks To Update");
				double marks=scan.nextDouble();
				std.setMarks(marks);
				System.out.println("Marks is updated");
				break;
				
				default:
					System.out.println("Please Choice The Currect Option!");
					break;
			}
		}
			else {
					try {
						throw new StudentNotFoundException("Student Data Not Found!"); 

					} catch ( StudentNotFoundException s) {

						System.out.println(s.getMessage());

					}
				}
			}

	@Override
	public void countStudents() {
		System.out.println(" No Of Students Are Present :"+db.size());


	}

	@Override
	public void sortStudents() {
		
		ArrayList<Student> l=new ArrayList<Student>();
		  Set<Integer> s =db.keySet();
		for (Integer id : s) {
			l.add(db.get(id));
			
		}
		System.out.println("1). Sort Id \n2). Sort Name \n3). Sort Age\n4). Sort Marks");
		System.out.println("Enter the option to sort");
		int choice=scan.nextInt();
		switch (choice) {
		case 1 :
			Collections.sort(l, new SortStudentById());
		for (Student id: l) {
			System.out.println(id);
		}
			
			break;
	case 2 :
		Collections.sort(l, new SortStudentByName());
		for (Student name: l) {
			System.out.println(name);
		}
			
			break;
	case 3 :
		Collections.sort(l, new SortStudentByAge());
		for (Student age: l) {
			System.out.println(age);
		}
		
		break;
	case 4 :
		Collections.sort(l, new SortStudentByMarks());
		for (Student marks: l) {
			System.out.println(marks);
		}
		
		break;

		default:
			System.out.println("Enter the currect option");
			break;
		}
		

	}
}
