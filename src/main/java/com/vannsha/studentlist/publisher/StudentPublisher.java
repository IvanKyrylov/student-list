package com.vannsha.studentlist.publisher;

import com.vannsha.studentlist.config.RabbitConfiguration;
import com.vannsha.studentlist.domain.Student;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/update")
public class StudentPublisher {
    private final AmqpTemplate template;

    public StudentPublisher(AmqpTemplate template) {
        this.template = template;
    }

    @PostMapping
    public Mono<ResponseEntity<Student>> update(@RequestBody Student student) {

        return Mono.fromCallable(() -> {
            template.convertAndSend(RabbitConfiguration.EXCHANGE, RabbitConfiguration.ROUTING_KEY, student);
            return ResponseEntity.accepted().build();
        });
    }
}
