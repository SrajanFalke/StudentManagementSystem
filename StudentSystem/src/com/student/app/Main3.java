package com.student.app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main3 {

	private static List<Student> StudentList;

	public static void main(String[] args) {
		System.out.println("******Student Managment Systems*******");
		StudentList = new ArrayList<Student>();
//		Taking the input from the user.

		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter Student name...");
		String name = sc.next();
		System.out.println("Student name is:- " + name);

//		For taking input as a integer
		System.out.println("Enter the student age...");
		int age = sc.nextInt();
		System.out.println("Student age is:-" + age);
	}

	private static void sortbyName() {
		/*
		 * Comparator<Student> studentnameorder = new Comparator<Student>() {
		 * 
		 * @Override public int compare(Student o1, Student o2) { return
		 * o1.getName().compareTo(o2.getName()); } };
		 */
		Comparator<Student> studentnameorder = (o1, o2) -> o1.getName().compareTo(o2.getName());

		Collections.sort(StudentList, studentnameorder);
		System.out.println("student list in alphabetic order is " + StudentList);
	}

	public static Student findStudentById(String studentId) {
		Student result = null;
		try {
			result = StudentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No student data found!!!"));
		} catch (RuntimeException e) {
			System.err.println("No student id is found!!!!");
		}
		return result;

	}
}
