package com.carrefour.infra.h2.entity;

import com.carrefour.domain.model.CreateCoursePartants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Course {

    private String date;
    @Id
    private Long numero;

    private String nom;

    @ElementCollection
    @CollectionTable(
        name="Course_partant",
        joinColumns=@JoinColumn(name="numero")
    )
    private List<Partant> partants;
}
