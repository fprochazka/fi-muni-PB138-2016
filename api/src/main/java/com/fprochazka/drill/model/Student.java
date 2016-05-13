package com.fprochazka.drill.model;

import java.util.List;
import java.util.UUID;

/**
 * Created by Michaela Bamburová on 13.05.2016.
 */
public class Student {

	private final UUID id;
	private final int uco;
	private final String email;
	private final String passwordHash;
	private final List<Exam> exams;

	public Student(int uco, String email, String passwordHash, List<Exam> exams) {
		this.id = UUID.randomUUID();
		this.uco = uco;
		this.email = email;
		this.passwordHash = passwordHash;
		this.exams = exams;
	}

	public UUID getId() {
		return id;
	}

	public int getUco() {
		return uco;
	}

	public String getEmail() {
		return email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public List<Exam> getExams() {
		return exams;
	}

	@Override
	public String toString() {
		return "Student{" +
			"id='" + id + '\'' +
			", uco=" + uco +
			", email='" + email + '\'' +
			", passwordHash='" + passwordHash + '\'' +
			", exams=" + exams +
			'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Student student = (Student) o;

		return id != null ? id.equals(student.id) : student.id == null;

	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}
}