package br.com.bullla.trigger.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GcsEventController {

    private static final Logger log = LoggerFactory.getLogger(GcsEventController.class);

    @PostMapping("/gcs/event")
    public ResponseEntity<Void> handleGcsEvent(
            @RequestHeader Map<String, String> headers,
            @RequestBody GcsEventPayload payload
    ) {
        log.info("=================================================");
        log.info("Evento recebido do Eventarc!");
        log.info("Bucket  : {}", payload.bucket());
        log.info("Arquivo : {}", payload.name());
        log.info("Tipo    : {}", payload.contentType());
        log.info("=================================================");

        return ResponseEntity.ok().build();
    }

    public record GcsEventPayload(
            String bucket,
            String name,
            String contentType
    ) {}
}
