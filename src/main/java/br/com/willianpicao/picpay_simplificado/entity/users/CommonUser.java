package br.com.willianpicao.picpay_simplificado.entity.users;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("COMMON")
@Getter
@Setter
public class CommonUser extends User {
    @Override
    public Boolean canSendMoney(){
        return true;
    }
}
