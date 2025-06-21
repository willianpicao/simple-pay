package br.com.willianpicao.picpay_simplificado.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.willianpicao.picpay_simplificado.entity.users.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Wallet implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    User user;

    BigDecimal balance;
}
