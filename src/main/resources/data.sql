-- Insert sample courses (one by one)
INSERT INTO courses (code, title, description, credit_hours, max_students, created_at) VALUES ('CS102', 'Introduction to Python', 'Basic programming concepts using Python', 3, 30, CURRENT_TIMESTAMP);
INSERT INTO courses (code, title, description, credit_hours, max_students, created_at) VALUES ('CS201', 'Data Structures', 'Fundamental data structures and algorithms', 4, 25, CURRENT_TIMESTAMP);
INSERT INTO courses (code, title, description, credit_hours, max_students, created_at) VALUES ('CS301', 'Database Systems', 'Database design and SQL programming', 3, 20, CURRENT_TIMESTAMP);
INSERT INTO courses (code, title, description, credit_hours, max_students, created_at) VALUES ('MATH101', 'Calculus I', 'Differential and integral calculus', 4, 35, CURRENT_TIMESTAMP);
INSERT INTO courses (code, title, description, credit_hours, max_students, created_at) VALUES ('ENG101', 'Technical Writing', 'Writing skills for technical professionals', 2, 40, CURRENT_TIMESTAMP);

-- Insert sample students (one by one)
INSERT INTO students (student_id, first_name, last_name, email, phone, major, enrollment_year, created_at) VALUES ('STU001', 'John', 'Doe', 'john.doe@university.edu', '+1234567890', 'Computer Science', 2023, CURRENT_TIMESTAMP);
INSERT INTO students (student_id, first_name, last_name, email, phone, major, enrollment_year, created_at) VALUES ('STU002', 'Jane', 'Smith', 'jane.smith@university.edu', '+1234567891', 'Information Technology', 2022, CURRENT_TIMESTAMP);
INSERT INTO students (student_id, first_name, last_name, email, phone, major, enrollment_year, created_at) VALUES ('STU003', 'Mike', 'Johnson', 'mike.johnson@university.edu', '+1234567892', 'Software Engineering', 2023, CURRENT_TIMESTAMP);
INSERT INTO students (student_id, first_name, last_name, email, phone, major, enrollment_year, created_at) VALUES ('STU004', 'Sarah', 'Williams', 'sarah.williams@university.edu', '+1234567893', 'Computer Science', 2021, CURRENT_TIMESTAMP);
INSERT INTO students (student_id, first_name, last_name, email, phone, major, enrollment_year, created_at) VALUES ('STU005', 'David', 'Brown', 'david.brown@university.edu', '+1234567894', 'Information Technology', 2022, CURRENT_TIMESTAMP);