package com.eunseo.springdi.bean;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Student extends Person {
    private int studentId;
    private String grade;
    
    public Student() {
        super();
        this.studentId = 1001;
        this.grade = "1";
    }


    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }

    
    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", grade=" + grade + "]";
    }

}
