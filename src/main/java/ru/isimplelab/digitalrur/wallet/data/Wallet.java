package ru.isimplelab.digitalrur.wallet.data;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Wallet {
    @Id
    private Long id;
    private String account;
    private String name;
}
