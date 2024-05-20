package com.carrefour.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCourse {

    private String date;

    private BigDecimal numero;

    private String nom;

    private List<CreateCoursePartants> partants;
}
