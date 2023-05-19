package kz.aidyninho.bitlabspringsprint1.repositories;

import kz.aidyninho.bitlabspringsprint1.domain.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private static StudentRepository instance;
    private final List<Student> students = new ArrayList<>();
    private long id = 1;

    private StudentRepository() {
        addStudent(new Student("Student name " + id, "Student last name " + id, 88));
        addStudent(new Student("Student name " + id, "Student last name " + id, 91));
        addStudent(new Student("Student name " + id, "Student last name " + id, 65));
        addStudent(new Student("Student name " + id, "Student last name " + id, 48));
        addStudent(new Student("Student name " + id, "Student last name " + id, 100));
        addStudent(new Student("Student name " + id, "Student last name " + id, 33));
        addStudent(new Student("Student name " + id, "Student last name " + id, 77));
        addStudent(new Student("Student name " + id, "Student last name " + id, 51));
    }

    public static StudentRepository getInstance() {
        if (instance == null) {
            instance = new StudentRepository();
        }
        return instance;
    }

    public void addStudent(Student student) {
        student.setId(id++);
        students.add(student);
    }

    public Student getStudentById(int id) {
        return students.get(id);
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Student> getStudentsByWord(String word) {
        List<Student> filteredStudents = new ArrayList<>();
        for (Student student :
                students) {
            if (student.getName().toLowerCase().contains(word)
                    || student.getSurname().toLowerCase().contains(word)
                    || String.valueOf(student.getId()).contains(word)
                    || String.valueOf(student.getGrade()).contains(word)
                    || student.getMark().toLowerCase().contains(word)) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }
}
