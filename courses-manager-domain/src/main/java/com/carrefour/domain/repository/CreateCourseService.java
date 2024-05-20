package com.carrefour.domain.repository;

import com.carrefour.domain.model.CreateCourse;
import reactor.core.publisher.Mono;

public interface CreateCourseService {


    Mono<CreateCourse> saveCreateCourse(CreateCourse createCourse);

}
