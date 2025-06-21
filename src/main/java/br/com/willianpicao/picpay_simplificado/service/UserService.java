package br.com.willianpicao.picpay_simplificado.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.willianpicao.picpay_simplificado.entity.users.User;
import br.com.willianpicao.picpay_simplificado.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public Boolean canSendMoney(User user, BigDecimal value) {
        return user.getWallet()
                .getBalance()
                .subtract(value)
                .compareTo(BigDecimal.ZERO) >= 0;
    }
}
