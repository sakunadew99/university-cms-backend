package com.university.course_management_system.repository;

import com.university.course_management_system.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findByCode(String code);

    List<Course> findByTitleContainingIgnoreCase(String title);

    @Query("SELECT c FROM Course c WHERE c.creditHours = ?1")
    List<Course> findByCreditHours(Integer creditHours);

    @Query("SELECT c FROM Course c WHERE SIZE(c.registrations) < c.maxStudents")
    List<Course> findAvailableCourses();

    @Query("SELECT COUNT(r) FROM Registration r WHERE r.course.id = ?1 AND r.status = 'ACTIVE'")
    Long countActiveRegistrations(Long courseId);
}