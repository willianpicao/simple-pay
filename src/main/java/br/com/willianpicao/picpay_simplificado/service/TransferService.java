package br.com.willianpicao.picpay_simplificado.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.willianpicao.picpay_simplificado.entity.Transfer;
import br.com.willianpicao.picpay_simplificado.entity.Wallet;
import br.com.willianpicao.picpay_simplificado.exception.TransferNotAllowedException;
import br.com.willianpicao.picpay_simplificado.repository.TransferRepository;
import jakarta.transaction.Transactional;

@Service
public class TransferService {
    @Autowired
    private UserService userService;

    @Autowired
    private WalletService walletService;

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private NotificationService notificationService;

    @Transactional
    public Transfer creatTransfer(BigDecimal value, Long payerId, Long payeeId) {
        var payer = userService.findById(payerId);
        var payee = userService.findById(payeeId);

        if (!payer.canSendMoney()) {
            throw new TransferNotAllowedException("Payer cannot send money");
        }

        if (!userService.canSendValue(payer, value)) {
            throw new TransferNotAllowedException("Payer does not have enough balance to send this value");
        }

        Wallet payerWallet = payer.getWallet();
        Wallet payeeWallet = payee.getWallet();

        if (!authorizationService.isAuthorized()) {
            throw new TransferNotAllowedException("Transfer not authorized by external service");
        }

        walletService.subtractBalance(payerWallet, value);
        walletService.addBalance(payeeWallet, value);

        Transfer transfer = new Transfer(value, payer, payee, LocalDateTime.now());
        transferRepository.save(transfer);

        notificationService.sendNotification();

        return transfer;
    }
}