package com.example.prueba.commons.model;

/**
 * Clase empleada para mandar errores de acuerdo a la documentación de Lineamientos Axity
 */

public class ErrorModel {

    private String errorCode;

    private String errorMessage;

    private String userError;

    private Object info;


    public ErrorModel(String errorCode, String errorMessage, String userError, Object info) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.userError = userError;
        this.info = info;
    }

    public ErrorModel() {
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getUserError() {
        return userError;
    }

    public void setUserError(String userError) {
        this.userError = userError;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }
}

