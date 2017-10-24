package org.ostenant.springboot.learning.examples.repository;

import org.ostenant.springboot.learning.examples.model.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {
}
