package com.university.course_management_system.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "registrations")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Enumerated(EnumType.STRING)
    private RegistrationStatus status;

    // ✅ Result field (grade/marks)
    @Column(name = "grade")
    private String grade;

    @PrePersist
    protected void onCreate() {
        registrationDate = LocalDateTime.now();
        if (status == null) {
            status = RegistrationStatus.ACTIVE;
        }
    }

    public Registration() {}

    public Registration(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    public LocalDateTime getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(LocalDateTime registrationDate) { this.registrationDate = registrationDate; }

    public RegistrationStatus getStatus() { return status; }
    public void setStatus(RegistrationStatus status) { this.status = status; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public enum RegistrationStatus {
        ACTIVE, DROPPED, COMPLETED
    }
}
