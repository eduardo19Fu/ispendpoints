package xyz.pangosoft.ispendpoints.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.pangosoft.ispendpoints.exception.exceptions.ParseException;
import xyz.pangosoft.ispendpoints.model.InstalacionNueva;
import xyz.pangosoft.ispendpoints.service.IInstalacionNuevaService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@CrossOrigin(value = {"*"})
@RestController
@RequestMapping("/api")
public class InstalacionNuevaApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(InstalacionNuevaApiController.class);
    @Autowired
    private IInstalacionNuevaService instalacionNuevaService;

    @GetMapping("/instalaciones-nuevas/get")
    public ResponseEntity<?> findAll() {
        // return new ResponseEntity<>(instalacionNuevaService.findAll(), HttpStatus.OK);
        return new ResponseEntity<>(instalacionNuevaService.findAll2(), HttpStatus.OK);
    }

    @GetMapping("/instalaciones-nuevas/get/{id}")
    public ResponseEntity<?> findInstalacionNueva(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(instalacionNuevaService.findInstalacion(id), HttpStatus.OK);
    }

    @GetMapping("/instalaciones-nuevas/instalacion-status/get/{idtecnico}")
    public ResponseEntity<?> findInstalacionesNuevasInstaldasNoInstaladas(@PathVariable("idtecnico") Integer idtecnico) {
        LOGGER.info("Ejecutando petición al servicio");
        return new ResponseEntity<>(instalacionNuevaService.findAllInstaladasYNoInstaladas(idtecnico), HttpStatus.OK);
    }

    @GetMapping("/instalaciones-nuevas/estado/get/{estado}/{idtecnico}")
    public ResponseEntity<?> findInstalacionesNuevasEstado(@PathVariable("estado") String estado, @PathVariable("idtecnico") int idtecnico) {
        return new ResponseEntity<>(instalacionNuevaService.findAllByEstado(estado, idtecnico), HttpStatus.OK);
    }

    @PostMapping("/instalaciones-nuevas/post")
    public ResponseEntity<?> create(@RequestBody Map<String, Object> body) {
        LOGGER.info("Registro de Orden de Instalación");
        InstalacionNueva instalacionNueva = new InstalacionNueva();


        instalacionNueva.setNombreCompleto(body.get("nombre_completo").toString());
        instalacionNueva.setIdentificacion(body.get("identificacion").toString());
        instalacionNueva.setNit(body.get("nit").toString());
        instalacionNueva.setIdplan(Integer.parseInt(body.get("plan").toString()));
        instalacionNueva.setIdzona(Integer.parseInt(body.get("zona").toString()));
        instalacionNueva.setCorreoElectronico(body.get("correo_electronico").toString());
        instalacionNueva.setMovil(body.get("movil").toString());
        instalacionNueva.setDireccionServicio(body.get("direccion_servicio").toString());
        instalacionNueva.setEstado("pendiente");
        instalacionNueva.setFotoIdentificacion(body.get("foto_identificacion").toString());
        instalacionNueva.setPrioridad(body.get("prioridad").toString());

        if (body.get("notas") != null) { instalacionNueva.setNotas(body.get("notas").toString()); }
        
        if(body.get("siPago").toString().equals("SI")) {
            instalacionNueva.setSiPago(true);
        } else if(body.get("siPago").toString().equals("NO")) {
            instalacionNueva.setSiPago(false);
        }

        LOGGER.debug("Orden de Instalación => " + instalacionNueva);

        return new ResponseEntity<>(instalacionNuevaService.save(instalacionNueva), HttpStatus.CREATED);
    }

    @PutMapping("/instalaciones-nuevas/put")
    public ResponseEntity<?> changeStatus(@RequestBody Map<String, Object> body) {
        InstalacionNueva instalacionNueva = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        instalacionNueva = instalacionNuevaService.findInstalacion((int) body.get("id"));
        instalacionNueva.setEstado(body.get("estado").toString());
        instalacionNueva.setIdtecnico((int) body.get("tecnico"));

        LOGGER.info("Instalación Nueva => " + instalacionNueva);

        try {
            if (!body.get("fecha_instalacion").toString().isEmpty() && !body.get("fecha_visita").toString().isEmpty()) {
                instalacionNueva.setFechaInstalacion(format.parse(body.get("fecha_instalacion").toString()));
                instalacionNueva.setFechaVisita(format.parse(body.get("fecha_visita").toString()));
            } else if (!body.get("fecha_instalacion").toString().isEmpty() && body.get("fecha_visita").toString().isEmpty()) {
                instalacionNueva.setFechaInstalacion(format.parse(body.get("fecha_instalacion").toString()));
                instalacionNueva.setFechaVisita(null);
            } else if (body.get("fecha_instalacion").toString().isEmpty() && !body.get("fecha_visita").toString().isEmpty()) {
                instalacionNueva.setFechaInstalacion(null);
                instalacionNueva.setFechaVisita(format.parse(body.get("fecha_visita").toString()));
            } else {
                instalacionNueva.setFechaInstalacion(null);
                instalacionNueva.setFechaVisita(null);
            }
        } catch (java.text.ParseException e) {
            LOGGER.error(e.getMessage());
            throw new ParseException(e.getMessage());
        }

        return new ResponseEntity<>(instalacionNuevaService.save(instalacionNueva), HttpStatus.CREATED);
    }
}
