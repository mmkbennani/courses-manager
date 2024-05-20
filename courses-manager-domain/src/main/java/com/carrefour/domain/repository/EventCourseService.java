package com.carrefour.domain.repository;

import com.carrefour.domain.model.CreateCourse;
import reactor.core.publisher.Mono;

public interface EventCourseService {


    Mono<String> sendCreationCourseEvent(CreateCourse createCourse, String xCorrelationID);

}
