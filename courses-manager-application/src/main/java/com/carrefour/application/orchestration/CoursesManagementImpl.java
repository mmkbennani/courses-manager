package com.carrefour.application.orchestration;

import com.carrefour.domain.model.CreateCourse;
import com.carrefour.domain.repository.CreateCourseService;
import com.carrefour.domain.repository.EventCourseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Component
@Slf4j
@RequiredArgsConstructor
public class CoursesManagementImpl implements CoursesManagement {



    private final CreateCourseService createCourseService;
    private final EventCourseService eventCourseService;




    public Map<String, Object> buildResourceResponse(Object response) {

        if (response == null) {
            return new ObjectMapper().convertValue(new HashMap<String, String>(), Map.class);
        } else {
            return new ObjectMapper().convertValue(response, Map.class);
        }
    }

    @Override
    public Mono<Map<String, Object>> createCourses(Mono<CreateCourse> createCourseMono) {
        return createCourseMono.flatMap(
            createCourse -> createCourseService.saveCreateCourse(createCourse)
                .map(course -> eventCourseService.sendCreationCourseEvent(course, UUID.randomUUID().toString()))
                .map(this::buildResourceResponse)
        );
    }
}
