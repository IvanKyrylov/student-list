package com.vannsha.studentlist.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vannsha.studentlist.config.RabbitConfiguration;
import com.vannsha.studentlist.domain.Student;
import com.vannsha.studentlist.servise.StudentService;
import com.vannsha.studentlist.util.MessageListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Map;

@RestController
public class StudentConsumer {

    private final StudentService studentService;
    private final MessageListenerContainerFactory messageListenerContainerFactory;

    public StudentConsumer(StudentService studentService, MessageListenerContainerFactory messageListenerContainerFactory) {
        this.studentService = studentService;
        this.messageListenerContainerFactory = messageListenerContainerFactory;
    }

    @GetMapping(
            value = "/consumer",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> receiveMessagesFromQueue() {
        MessageListenerContainer mlc = messageListenerContainerFactory
                .createMessageListenerContainer(RabbitConfiguration.ROUTING_KEY);
        Gson gson = new GsonBuilder().create();

        Flux<String> f = Flux.create(emitter -> {
            mlc.setupMessageListener(m -> {
                String payload = new String(m.getBody());
                emitter.next(payload);
            });
            emitter.onRequest(v -> {
                mlc.start();
            });
            emitter.onDispose(mlc::stop);
        });

        return f.mergeWith(f);
    }
}
