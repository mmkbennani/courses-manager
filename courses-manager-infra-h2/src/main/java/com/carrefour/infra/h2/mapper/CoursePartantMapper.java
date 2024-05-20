package com.carrefour.infra.h2.mapper;

import com.carrefour.domain.model.CreateCoursePartants;
import com.carrefour.infra.h2.entity.Partant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CoursePartantMapper {

    CoursePartantMapper INSTANCE = Mappers.getMapper(CoursePartantMapper.class);

    Partant partantDtoToPartant(CreateCoursePartants deliveryDtoH2);
    CreateCoursePartants partantToPartantDto(Partant delivery);
}
