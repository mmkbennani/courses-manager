package com.carrefour.application.orchestration;

import com.carrefour.domain.model.CreateCourse;
import reactor.core.publisher.Mono;

import java.util.Map;

public interface CoursesManagement {

    Mono<Map<String, Object>> createCourses(Mono<CreateCourse> createCourse);
}
