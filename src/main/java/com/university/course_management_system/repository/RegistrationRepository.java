package com.university.course_management_system.repository;

import com.university.course_management_system.entity.Registration;
import com.university.course_management_system.entity.Registration.RegistrationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    List<Registration> findByStudentId(Long studentId);

    List<Registration> findByCourseId(Long courseId);

    List<Registration> findByStatus(RegistrationStatus status);

    Optional<Registration> findByStudentIdAndCourseId(Long studentId, Long courseId);

    @Query("SELECT r FROM Registration r WHERE r.student.id = ?1 AND r.status = 'ACTIVE'")
    List<Registration> findActiveRegistrationsByStudentId(Long studentId);

    @Query("SELECT COUNT(r) FROM Registration r WHERE r.course.id = ?1 AND r.status = 'ACTIVE'")
    Long countActiveRegistrationsByCourseId(Long courseId);
}
