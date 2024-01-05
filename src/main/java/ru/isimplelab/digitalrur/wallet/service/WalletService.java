package ru.isimplelab.digitalrur.wallet.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.isimplelab.digitalrur.wallet.data.Wallet;
import ru.isimplelab.digitalrur.wallet.data.WalletRepository;
import ru.isimplelab.digitalrur.wallet.dto.WalletDto;

@Service
@RequiredArgsConstructor
public class WalletService {
    private final WalletRepository repository;
    private final ReactiveKafkaProducerTemplate<String, String> template;

    public Mono<WalletDto> create(WalletDto dto) {
        Wallet wallet = new Wallet();
        wallet.setAccount(dto.getAccount());
        wallet.setName(dto.getName());
        return repository.save(wallet)
                .map(v -> new WalletDto(v.getId(), v.getAccount(), v.getName()));
    }

    public void sendToAbs(Long id) {
        repository.findById(id)
                .flatMap(v -> template.send("first_kafka_topic", v.getId().toString()))
                .subscribe();
    }
}
