/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.covid19.exception;

/**
 *
 * @author Administrador
 */
public class ConexaoException extends Exception {

    public ConexaoException() {
    }

    public ConexaoException(String message) {
        super(message);
    }

    public ConexaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConexaoException(Throwable cause) {
        super(cause);
    }

    public ConexaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
