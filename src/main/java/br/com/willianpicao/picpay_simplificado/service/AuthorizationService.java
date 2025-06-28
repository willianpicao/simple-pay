package br.com.willianpicao.picpay_simplificado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.willianpicao.picpay_simplificado.clients.AuthorizationClient;

@Service
public class AuthorizationService {

    @Autowired
    private  AuthorizationClient client;

    public Boolean isAuthorized() {
        return client.getAuthorization().data().authorization();
    }
}
