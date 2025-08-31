package com.university.course_management_system.service;

import com.university.course_management_system.entity.Registration;
import com.university.course_management_system.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    public Optional<Registration> getRegistrationById(Long id) {
        return registrationRepository.findById(id);
    }

    public List<Registration> getRegistrationsByStudentId(Long studentId) {
        return registrationRepository.findByStudentId(studentId);
    }

    public List<Registration> getRegistrationsByCourseId(Long courseId) {
        return registrationRepository.findByCourseId(courseId);
    }

    public Registration saveRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    public Registration updateRegistration(Long id, Registration registrationDetails) {
        Registration registration = registrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registration not found with id: " + id));

        // ✅ update grade + status
        if (registrationDetails.getStatus() != null) {
            registration.setStatus(registrationDetails.getStatus());
        }
        if (registrationDetails.getGrade() != null) {
            registration.setGrade(registrationDetails.getGrade());
        }

        return registrationRepository.save(registration);
    }

    public void deleteRegistration(Long id) {
        registrationRepository.deleteById(id);
    }

    public boolean isStudentRegisteredForCourse(Long studentId, Long courseId) {
        return registrationRepository.findByStudentIdAndCourseId(studentId, courseId).isPresent();
    }
}
