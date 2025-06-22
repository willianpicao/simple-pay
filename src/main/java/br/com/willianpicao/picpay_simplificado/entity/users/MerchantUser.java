package br.com.willianpicao.picpay_simplificado.entity.users;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("MERCHANT")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class MerchantUser extends User {
    @Override
    public Boolean canSendMoney() {
        return false;
    }
}
