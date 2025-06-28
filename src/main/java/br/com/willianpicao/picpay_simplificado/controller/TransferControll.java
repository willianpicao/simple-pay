package br.com.willianpicao.picpay_simplificado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.willianpicao.picpay_simplificado.dto.TransferDTO;
import br.com.willianpicao.picpay_simplificado.service.TransferService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController(value = "/transfer")
public class TransferControll {
    @Autowired
    TransferService transferService;
   
    @PostMapping
    public ResponseEntity<Void> transfer(@RequestBody TransferDTO transferDTO){
        transferService.creatTransfer(transferDTO.value(), transferDTO.payer(), transferDTO.payee());
        return ResponseEntity.accepted().build();
    }
}
