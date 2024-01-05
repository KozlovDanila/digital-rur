package ru.isimplelab.digitalrur.wallet.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import ru.isimplelab.digitalrur.wallet.dto.WalletDto;
import ru.isimplelab.digitalrur.wallet.service.WalletService;

@RestController
@AllArgsConstructor
@RequestMapping("/wallet")
public class WalletController {

    private final WalletService service;

    @PostMapping
    public Mono<WalletDto> create(@RequestBody WalletDto wallet) {
        return service.create(wallet);
    }

    @PutMapping("/{id}/send-to-abs")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void sendToAbs(@PathVariable Long id) {
        service.sendToAbs(id);
    }
}