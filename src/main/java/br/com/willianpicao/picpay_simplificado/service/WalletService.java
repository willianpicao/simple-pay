package br.com.willianpicao.picpay_simplificado.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.willianpicao.picpay_simplificado.entity.Wallet;
import br.com.willianpicao.picpay_simplificado.repository.WalletRepository;

@Service
public class WalletService {
    @Autowired
    private WalletRepository walletRepository;

    public void addBalance(Wallet wallet, BigDecimal value) {
        wallet.setBalance(wallet.getBalance().add(value));
        walletRepository.save(wallet);
    }

    public void subtractBalance(Wallet wallet, BigDecimal value) {
        wallet.setBalance(wallet.getBalance().subtract(value));
        walletRepository.save(wallet);
    }
}
