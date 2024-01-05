package ru.isimplelab.digitalrur.wallet;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WalletListener {

    private final ReactiveKafkaConsumerTemplate<String, String> consumerTemplate;

    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent() {
        consumerTemplate
                .receiveAutoAck()
                .doOnNext(System.out::println)
                .subscribe();
    }
}
