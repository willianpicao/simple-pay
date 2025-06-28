package br.com.willianpicao.picpay_simplificado.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "https://util.devi.tools/api/v1/notify", name = "notification-client")
public interface NotificationClient {
    @PostMapping
    void sendNotification();
}
