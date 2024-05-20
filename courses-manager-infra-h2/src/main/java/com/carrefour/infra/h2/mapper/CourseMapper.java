package com.carrefour.infra.h2.mapper;

import com.carrefour.domain.model.CreateCourse;
import com.carrefour.infra.h2.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    Course coursesDtoToCourse(CreateCourse deliveryDtoH2);
    CreateCourse coursesToCourseDto(Course delivery);
}
