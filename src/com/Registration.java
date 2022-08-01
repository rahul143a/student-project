package com;

import java.util.Scanner;

class Registration {

	public static void main(String[] args) {


		Scanner scan=new Scanner(System.in);
		System.out.println(" WELCOME TO SDBMS");
		System.out.println(" ----------------");

		StudentManagementSystem student = new StudentManagementSystemImpl();
		
		while(true) {
			System.out.println(" 1:ADD STUDENT\n 2:REMOVE STUDENT\n 3:REMOVE ALL STUDENTS");
			System.out.println(" 4:DISPLAY STUDENT\n 5:DISPLAY ALL STUDENTS\n 6:UPDATE STUDENT");
			System.out.println(" 7:COUNT STUDENTS\n 8:SORT STUDENTS\n 9:EXIT FROM THIS SITE\n");

			System.out.println(" Enter The Choice");

			int choice = scan.nextInt();

			switch (choice) {
			case 1:
				student.addStudent();
				break;
			case 2:
				student.removeStudent();
				break;
			case 3:
				student.removeAllStudents();
				break;
			case 4:
				student.displayStudent();
				break;
			case 5:
				student.displayAllStudents();
				break;
			case 6:
				student.updateStudent();
				break;
			case 7:
				student.countStudents();
				break;
			case 8:
				student.sortStudents();
				break;
			case 9:
				System.out.println(" THANKS FOR USE THIS SITE!!");
				System.exit(0);
				break;

			default:
				System.out.println(" You Have Entered The Wrong Choice");
				System.out.println(" Please Enter The Currect Choice\n ");
				break;
			}
			System.out.println("--------------------");
		}
	}


}
