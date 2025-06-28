package br.com.willianpicao.picpay_simplificado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import br.com.willianpicao.picpay_simplificado.clients.NotificationClient;
import br.com.willianpicao.picpay_simplificado.exception.BadRequestException;

@Service
public class NotificationService {

    @Autowired
    NotificationClient client;

    public void sendNotification() {
        try {
        client.sendNotification();
        } catch (HttpClientErrorException e) {
            throw new BadRequestException("Error sending notification");
        }
    }
}
