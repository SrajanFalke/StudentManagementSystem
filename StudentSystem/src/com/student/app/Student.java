
package com.student.app;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
// Here Declaring all the variable as an instance variable
//	Always make Instance variable as private.
	private String name; // String is a non primitive data type and create Reference var,it is name and
							// Default value = null
	private int age; // default value = 0
	private String studentId; // String is a non primitive data type and create Reference var,it is name and
	// Default value = null
	private List<String> courses; // Used generic for inserting only string values

	public Student(String name, int age, String studentId) {
		super();
		if (validateAge(age) && validateName(name) && validateStudentId(studentId)) {
			this.name = name;
			this.age = age;
			this.studentId = studentId;
			courses = new ArrayList<String>(); // Initializing the Arraylist in constructor.
		}
	}

	public void enrollCourse(String course) {
		if (validateCourseName(course)) {
			if (!courses.contains(course)) {
				courses.add(course);
				System.out.println(" Student is enroll to " + course + " Successfully ");
			} else {
				System.err.println("Sutdent is already enrolled for this course " + course);
			}
		}
	}

	public void printStudentInfo() {
		System.out.println("========= Student information =========");
		System.out.println("Student name = " + name);
		System.out.println("Student Age = " + age);
		System.out.println("Student ID = " + studentId);
		System.out.println("Enroll for = " + courses);
	}

	public boolean validateAge(int age) {
		if (age >= 19 && age <= 35) {
			return true;
		} else {
			System.err.println("invalis input please enter the age number between 19 to 35 only");
			return false;
		}
	}

	public boolean validateName(String name) {
		String nameRegex = "^[a-zA-Z\\s]+$";
		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(name);
		if (nameMatcher.matches()) {
			return true;
		} else {
			System.err.println("Enter the valid name start with only characters");
			return false;
		}
	}

	public boolean validateStudentId(String studentId) {
		String idRegex = "S-\\d+$";
		Pattern idPattern = Pattern.compile(idRegex);
		Matcher idMatcher = idPattern.matcher(studentId);
		if (idMatcher.matches()) {
			return true;
		} else {
			System.err.println("Please enter the correct student id start with S char");
			return false;
		}
	}

	public boolean validateCourseName(String course) {
		if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DSA")
				|| course.equalsIgnoreCase("Sw Testing")) {
			return true;
		} else {
			System.err.println("Please enter the correct course name list " + courses);
			return false;
		}
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentId() {
		return studentId;
	}

	public List<String> getCourses() {
		return courses;
	}

}
