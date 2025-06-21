package br.com.willianpicao.picpay_simplificado.entity.users;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("COMMON")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class CommonUser extends User {
    @Override
    public Boolean canSendMoney(){
        return true;
    }
}
