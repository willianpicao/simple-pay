package br.com.willianpicao.picpay_simplificado.dto;

import java.math.BigDecimal;

public record TransferDTO(BigDecimal value, Long payer, Long payee) {
}
