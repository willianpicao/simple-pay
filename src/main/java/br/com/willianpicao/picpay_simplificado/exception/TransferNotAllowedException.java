package br.com.willianpicao.picpay_simplificado.exception;

public class TransferNotAllowedException extends RuntimeException {
    public TransferNotAllowedException(String msg) {
        super(msg);
    }
}
