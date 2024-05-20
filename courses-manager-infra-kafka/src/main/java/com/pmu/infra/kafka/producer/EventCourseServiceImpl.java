package com.pmu.infra.kafka.producer;

import com.carrefour.domain.model.CreateCourse;
import com.carrefour.domain.repository.EventCourseService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@Setter
public class EventCourseServiceImpl implements EventCourseService {

    private KafkaTemplate<String, CreateCourse> kafkaTemplate;

    public EventCourseServiceImpl(KafkaTemplate<String, CreateCourse> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Value("${kafka.topicname}")
    String topicName;

    @Override
    public Mono<String> sendCreationCourseEvent(CreateCourse createCourse, String xCorrelationID) {

        List<Header> headers = new ArrayList<>();
        log.info("Start Kafka event");
        headers.add(new RecordHeader("X-Correlation-ID", xCorrelationID.getBytes()));

        ProducerRecord<String, CreateCourse> producerRecord = new ProducerRecord <>(topicName, null, System.currentTimeMillis(), UUID.randomUUID().toString(), createCourse, headers);
        kafkaTemplate.send(producerRecord);
        log.info("Kafka event was sent");
        return Mono.just(xCorrelationID);
    }
}
