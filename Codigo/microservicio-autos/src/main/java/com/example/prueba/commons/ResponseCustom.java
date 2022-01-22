package com.example.prueba.commons;

import com.example.prueba.commons.model.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


/**
 * Clase para mandar los diferentes códigos de estado y en algunos caso el error custom de Axity
 */
public class ResponseCustom {

    private static ErrorModel error;

    /**
     * Metodos para retornar un codigo custom de error de acuerdo a los lineamientos Axity
     * @param errMsg Mensaje general
     * @param msg Mensaje concreco
     * @param info Información adicional puede ser un string o un Map<> que será recibido como un JSON en el cliente
     * @return Un response entity con el codigo de estado y una instancia del error custom Axity
     */
    public static ResponseEntity<?> responseInternalError(String errMsg, String msg, Object info ) {
        error = new ErrorModel("001", errMsg, msg, info);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    public static ResponseEntity<?> responseInternalError(String errMsg, String msg) {

        error = new ErrorModel("001", errMsg, msg, "");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    public static ResponseEntity<?> responseCustomInfoException(String errMsg, String msg ) {

        error = new ErrorModel("002", errMsg, msg, "");
        return ResponseEntity.status(HttpStatus.OK).body(error);
    }

    public static ResponseEntity<?> responseCustomInfoException(String errMsg, String msg, Object info ) {

        error = new ErrorModel("002", errMsg, msg, info);
        return ResponseEntity.status(HttpStatus.OK).body(error);
    }
    
    public static ResponseEntity<?> responseBadRequest(String errMsg, String msg, Object info ) {

        error = new ErrorModel("003", errMsg, msg, info);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    public static ResponseEntity<?> responseOk(Object obj ) {
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }

    public static ResponseEntity<?> responseCreated(Object obj ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

}
