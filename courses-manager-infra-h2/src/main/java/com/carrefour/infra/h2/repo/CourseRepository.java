package com.carrefour.infra.h2.repo;

import com.carrefour.infra.h2.entity.Course;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface CourseRepository  extends R2dbcRepository<Course, Long> {
}
