package com.student.app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main4 {

	private static List<Student> studentList;
	private static Scanner sc;

	public static void main(String[] args) {
		System.out.println("******Student Managment Systems*******");
		studentList = new ArrayList<Student>();
		while (true) {
			System.out.println("______Welcome______");

			System.out.println("Select an option");
			System.out.println("1. Register a Student name");
			System.out.println("2. Find the student ID");
			System.out.println("3. List all the student information");
			System.out.println("4. list utdent info in sorted order");
			System.out.println("5. Exit");

			sc = new Scanner(System.in);
			int option = sc.nextInt();

			switch (option) {
			case 1:
				enrollStudent(sc);
				break;

			case 2:
				findStudentById(sc);
				break;

			case 3:
				printAllStudentData();
				break;

			case 4:
				sortbyName();
				break;

			case 5:
				exit();
				break;

			default:
				System.out.println("Invalid option selected enter between 1 to 5");
			}
		}
	}

	private static void exit() {
		System.out.println("Good Bye!!!");
		System.exit(0);

	}

	private static void printAllStudentData() {
		System.out.println("------------- Print all the Student data --------------");
		if (studentList.size() > 0) {
			for (Student student : studentList) {
				student.printStudentInfo();
			}
		} else {
			System.err.println("No sutdent record created");
		}
	}

	private static void findStudentById(Scanner sc2) {
		Student studentrecord = null;
		System.out.println("Enter the student Id");
		String studentId = sc2.next();
		try {
			studentrecord = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No student data found!!!"));
		} catch (RuntimeException e) {
			System.err.println("No student id is found!!!!");
		}
		studentrecord.printStudentInfo();
	}

	private static void enrollStudent(Scanner sc2) {
		System.out.println("Enter the student Name");
		String studentname = sc2.next();

		System.out.println("Enter the student Age");
		int studentage = sc2.nextInt();

		System.out.println("Enter the student ID");
		String studentId = sc2.next();

		Student newStudent = new Student(studentname, studentage, studentId);
		studentList.add(newStudent);
		System.out.println("Student added successfully");
		while (true) {
			System.out.println("course have been enrolled....Type done for exit");
			String courseName = sc.next();
			if (courseName.equalsIgnoreCase("Done")) {
				break;
			}
			newStudent.enrollCourse(courseName);
		}
		newStudent.printStudentInfo();
//		System.out.println("Course is enrolled successfully" + courseName);
	}

	private static void sortbyName() {
		/*
		 * Comparator<Student> studentnameorder = new Comparator<Student>() {
		 * 
		 * @Override public int compare(Student o1, Student o2) { return
		 * o1.getName().compareTo(o2.getName()); } };
		 */
		Comparator<Student> studentnameorder = (o1, o2) -> o1.getName().compareTo(o2.getName());

		Collections.sort(studentList, studentnameorder);
		System.out.println("student list in alphabetic order is " + studentList);
	}

	public static Student findStudentById(String studentId) {
		Student result = null;
		try {
			result = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No student data found!!!"));
		} catch (RuntimeException e) {
			System.err.println("No student id is found!!!!");
		}
		return result;

	}
}
