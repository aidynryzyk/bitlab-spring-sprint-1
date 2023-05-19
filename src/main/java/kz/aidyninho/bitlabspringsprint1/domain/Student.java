package kz.aidyninho.bitlabspringsprint1.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {

    long id;
    String name;
    String surname;
    int grade;
    String mark;

    public Student(String name, String surname, int grade) {
        this.name = name;
        this.surname = surname;
        this.grade = grade;
        this.mark = getMarkByGrade(grade);
    }

    private String getMarkByGrade(int grade) {
        if (grade >= 90) {
            return "A";
        } else if (grade >= 75) {
            return "B";
        } else if (grade >= 60) {
            return "C";
        } else if (grade >= 50) {
            return "D";
        }
        return "F";
    }
}
