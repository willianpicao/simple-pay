package br.com.willianpicao.picpay_simplificado.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.willianpicao.picpay_simplificado.dto.AuthorizationResponse;

@FeignClient(url = "https://util.devi.tools/api/v2/authorize", name = "authorization-client")
public interface AuthorizationClient {

    @GetMapping
    AuthorizationResponse getAuthorization();
}
