package ru.isimplelab.digitalrur.wallet.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
public class WalletDto {
    private Long id;
    private String account;
    private String name;
}
