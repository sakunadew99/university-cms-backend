package com.university.course_management_system.controller;

import com.university.course_management_system.entity.Registration;
import com.university.course_management_system.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/registrations")
@CrossOrigin(origins = "http://localhost:3000")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public ResponseEntity<List<Registration>> getAllRegistrations() {
        List<Registration> registrations = registrationService.getAllRegistrations();
        return ResponseEntity.ok(registrations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Registration> getRegistrationById(@PathVariable Long id) {
        Optional<Registration> registration = registrationService.getRegistrationById(id);
        return registration.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Registration>> getRegistrationsByStudentId(@PathVariable Long studentId) {
        List<Registration> registrations = registrationService.getRegistrationsByStudentId(studentId);
        return ResponseEntity.ok(registrations);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Registration>> getRegistrationsByCourseId(@PathVariable Long courseId) {
        List<Registration> registrations = registrationService.getRegistrationsByCourseId(courseId);
        return ResponseEntity.ok(registrations);
    }

    @PostMapping
    public ResponseEntity<Registration> createRegistration(@Valid @RequestBody Registration registration) {
        try {
            Registration savedRegistration = registrationService.saveRegistration(registration);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedRegistration);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Registration> updateRegistration(@PathVariable Long id,
                                                           @Valid @RequestBody Registration registrationDetails) {
        try {
            Registration updatedRegistration = registrationService.updateRegistration(id, registrationDetails);
            return ResponseEntity.ok(updatedRegistration);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegistration(@PathVariable Long id) {
        try {
            registrationService.deleteRegistration(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/check/{studentId}/{courseId}")
    public ResponseEntity<Boolean> isStudentRegisteredForCourse(@PathVariable Long studentId,
                                                                @PathVariable Long courseId) {
        boolean isRegistered = registrationService.isStudentRegisteredForCourse(studentId, courseId);
        return ResponseEntity.ok(isRegistered);
    }
}