package com.student.app;

public class Main {

	public static void main(String[] args) {
		System.out.println("******Student Managment Systems*******");
		Student s1;
		s1 = new Student("Aditi zod", 35, "S-107");
		s1.enrollCourse("java");
		s1.enrollCourse("DSA");
		s1.enrollCourse("Devops");
		s1.enrollCourse("java");
		System.out.println(s1);
		s1.printStudentInfo();
		
		Student s2;
		s2 = new Student("Srajan", 34, "S-101");
		s2.enrollCourse("java");
		s2.printStudentInfo();
		
		Student s3;
		s3 = new Student("Shanky", 32, "S-102");
		s3.enrollCourse("sw testing");
		s3.printStudentInfo();
	}

}
