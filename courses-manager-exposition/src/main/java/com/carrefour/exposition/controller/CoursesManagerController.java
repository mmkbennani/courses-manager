package com.carrefour.exposition.controller;

import com.carrefour.application.orchestration.CoursesManagement;
import com.carrefour.exposition.exception.CustomGlobalExceptionHandler;
import lombok.AllArgsConstructor;
import org.openapitools.api.V1Api;
import org.openapitools.model.CreateCourse;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.UUID;


@AllArgsConstructor
@RestController
@Validated
public class CoursesManagerController extends CustomGlobalExceptionHandler implements V1Api {

    private final Logger logger;
    private final CoursesManagement coursesManagement;
    private static final String TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";


    @Override
    public Mono<ResponseEntity<Map<String, Object>>> createCourse(UUID xCorrelationID, Mono<CreateCourse> createCourse, ServerWebExchange exchange) {
        return V1Api.super.createCourse(xCorrelationID, createCourse, exchange);
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }

    private ResponseEntity<Map<String, Object>> getResponse(Map<String, Object> response) {
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
