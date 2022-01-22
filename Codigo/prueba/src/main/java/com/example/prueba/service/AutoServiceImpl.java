package com.example.prueba.service;

import com.example.prueba.commons.ResponseCustom;
import com.example.prueba.commons.ValidationBody;
import com.example.prueba.dao.AutoDao;
import com.example.prueba.entity.Auto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementacion de los servicios para autos, usamos Service para que
 * Spring sepa que es un servicio
 */
@Service
public class AutoServiceImpl implements AutoService {

    //Un logger si queremos imprimir informacion en consola
    private static Logger log = LoggerFactory.getLogger(AutoServiceImpl.class);

    private Auto autoDb = null;

    private List<Auto> autos = new ArrayList<>();

    @Autowired
    private AutoDao autoDao;

    @Override
    @Transactional(readOnly = true)  // lo usamos especialmente para metodos que modifiquen directamente en la DB, si algo sale mal se hace rollback
    public ResponseEntity<?> findAll() {
        try {
            this.autos = (List<Auto>) autoDao.findAll();

            if (this.autos.size() > 0) {
                //Empleando ResponseCustom podemos enviar los diferentes códigos de estado y el body que requerimos
                // especialmente si vamos a emplear el customBody de Axity para errores
                return ResponseCustom.responseOk(this.autos);
            }

            return ResponseCustom.responseCustomInfoException("Not found", "No hay registros en la Db");

        } catch (Exception e) {
            return ResponseCustom.responseInternalError("Internal Server Error", "Ha ocurrido un error en el servidor");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> findById(Long id) {
        try {
            this.autoDb = autoDao.findById(id).orElse(null);

            if (autoDb != null) {
                return ResponseCustom.responseOk(this.autoDb);
            }

            return ResponseCustom.responseCustomInfoException("Not Found", "Registro no encontrado");

        } catch (Exception e) {
            return ResponseCustom.responseInternalError("Internal Server Error", "Ha ocurrido un error en el servidor");
        }
    }

    @Override
    @Transactional()
    public ResponseEntity<?> save(Auto auto, BindingResult body) {

        if (body.hasErrors()) {
            return ResponseCustom.responseBadRequest("Bad Request", "Faltan campos requeridos", ValidationBody.validar(body));
        }


        try {
            this.autoDb = autoDao.save(auto);
            return ResponseCustom.responseCreated(this.autoDb);
        } catch (Exception e) {
            return ResponseCustom.responseInternalError("Internal Server Error", "Ha ocurrido un error en el servidor");
        }

    }

    @Override
    @Transactional()
    public ResponseEntity<?> update(Auto auto, BindingResult body, Long id) {

        if (body.hasErrors()) {
            return ResponseCustom.responseBadRequest("Bad Request", "Faltan campos requeridos", ValidationBody.validar(body));
        }


        try {

            this.autoDb = autoDao.findById(id).orElse(null);

            if (autoDb != null) {
                auto.setId(this.autoDb.getId());
                this.autoDb = autoDao.save(auto);
                return ResponseCustom.responseOk(this.autoDb);
            }

            return ResponseCustom.responseCustomInfoException("Not found", "Registro no encontrado");

        } catch (Exception e) {
            return ResponseCustom.responseInternalError("Internal Server Error", "Ha ocurrido un error en el servidor");
        }

    }

    @Override
    @Transactional()
    public ResponseEntity<?> delete(Long id) {

        try {
            Auto autoDb = autoDao.findById(id).orElse(null);

            if (autoDb != null) {
                autoDao.deleteById(id);
                return ResponseCustom.responseOk("Registro eliminado con exito");
            }
            return ResponseCustom.responseCustomInfoException("Not found", "Registro no encontrado");

        } catch (Exception e) {
            return ResponseCustom.responseInternalError("Internal Server Error", "Ha ocurrido un error en el servidor");
        }

    }


}
