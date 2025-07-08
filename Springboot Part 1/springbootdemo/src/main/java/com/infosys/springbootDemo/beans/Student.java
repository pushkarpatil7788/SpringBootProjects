package com.infosys.springbootDemo.beans;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_student")
@NamedQuery(
        name = "Student.findAllStudent",
        query = "SELECT s from Student s"
)

@NamedQuery(
        name = "Student.findByEmail",
        query = "Select s from Student s where s.studentEmail = :email"
)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "sname")
    private String studentName;
    @Column(name = "semail")
    private String studentEmail;

    public  Student(){

    }
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL,targetEntity = Laptops.class)
    @JoinColumn(name = "laptop_id",referencedColumnName = "laptopId",nullable = true)
    public Laptops laptops;

    public Laptops getLaptops() {
        return laptops;
    }

    public void setLaptops(Laptops laptops) {
        this.laptops = laptops;
    }

    public Student(String studentName, String studentEmail) {
        this.studentName = studentName;
        this.studentEmail = studentEmail;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }
}
