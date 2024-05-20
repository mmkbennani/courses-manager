package com.carrefour.infra.h2.repoimpl;

import com.carrefour.domain.model.CreateCourse;
import com.carrefour.domain.repository.CreateCourseService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateCourseServiceImpl implements CreateCourseService {


    @Override
    public Mono<CreateCourse> saveCreateCourse(CreateCourse createCourse) {
        return null;
    }
}
