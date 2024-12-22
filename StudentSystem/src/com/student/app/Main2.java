package com.student.app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {

	private static List<Student> StudentList;

	public static void main(String[] args) {
		System.out.println("******Student Managment Systems*******");
		StudentList = new ArrayList<Student>();

		Student s1;
		s1 = new Student("Aditi zod", 35, "S-107");
		s1.enrollCourse("java");
		s1.enrollCourse("DSA");

		Student s2;
		s2 = new Student("Srajan", 34, "S-101");
		s2.enrollCourse("java");

		Student s3;
		s3 = new Student("Shanky", 34, "S-102");
		s3.enrollCourse("sw testing");

		StudentList.add(s1);
		StudentList.add(s2);
		StudentList.add(s3);
		Student idResult = findStudentById("S-103");
		System.out.println("Result id " + idResult);
		sortbyName();
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
