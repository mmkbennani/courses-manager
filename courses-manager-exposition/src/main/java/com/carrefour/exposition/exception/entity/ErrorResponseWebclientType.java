package com.carrefour.exposition.exception.entity;

import com.carrefour.domain.exception.CarrefourError;
import org.openapitools.model.ErrorReport;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public class ErrorResponseWebclientType {

    public static Mono<ResponseEntity<ErrorReport>> buildErrorResponse(CarrefourError errorType) {
        return Mono.just(new ErrorReport()
                .type(errorType.getType())
                .title(errorType.getTitle())
                .details(errorType.getDetails())
                .instance(errorType.getInstance()))
            .map(error -> ResponseEntity.status(Integer.parseInt(errorType.getHttpStatus())).body(error));
    }

}
