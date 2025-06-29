package br.com.willianpicao.picpay_simplificado.config;

import java.math.BigDecimal;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import br.com.willianpicao.picpay_simplificado.entity.Wallet;
import br.com.willianpicao.picpay_simplificado.entity.users.CommonUser;
import br.com.willianpicao.picpay_simplificado.entity.users.MerchantUser;
import br.com.willianpicao.picpay_simplificado.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@Profile("test")
public class DataInitializer {

    private final UserRepository userRepository;

    @PostConstruct
    public void init() {
        var commonUser = CommonUser.builder()
                .fullName("Willian Usuário Comum")
                .cpf("11111111111")
                .email("common@example.com")
                .password("123456")
                .build();

        var commonWallet = new Wallet(null, commonUser, new BigDecimal("1000.00"));
        commonUser.setWallet(commonWallet);

        var merchantUser = MerchantUser.builder()
                .fullName("Lojista Exemplo")
                .cpf("22222222222")
                .email("merchant@example.com")
                .password("123456")
                .build();

        var merchantWallet = new Wallet(null, merchantUser, new BigDecimal("2000.00"));
        merchantUser.setWallet(merchantWallet);

        userRepository.save(commonUser);
        userRepository.save(merchantUser);
    }
}
