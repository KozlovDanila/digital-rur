package ru.isimplelab.digitalrur.wallet.data;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface WalletRepository extends ReactiveCrudRepository<Wallet, Long> {
}
