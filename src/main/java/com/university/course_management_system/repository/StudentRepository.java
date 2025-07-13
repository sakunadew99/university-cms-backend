package com.university.course_management_system.repository;

import com.university.course_management_system.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByStudentId(String studentId);

    Optional<Student> findByEmail(String email);

    List<Student> findByMajor(String major);

    List<Student> findByEnrollmentYear(Integer year);

    @Query("SELECT s FROM Student s WHERE s.firstName LIKE %?1% OR s.lastName LIKE %?1%")
    List<Student> findByNameContaining(String name);
}