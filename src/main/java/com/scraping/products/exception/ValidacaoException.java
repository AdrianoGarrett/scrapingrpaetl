package com.scraping.products.exception;

public class ValidacaoException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public ValidacaoException(String mensagem) {
        super(mensagem);
    }
}
