package xyz.pangosoft.ispendpoints.controller;

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

    @Autowired
    private IInstalacionNuevaService instalacionNuevaService;

    @GetMapping("/instalaciones-nuevas/get")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(instalacionNuevaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/instalaciones-nuevas/get/{id}")
    public ResponseEntity<?> findInstalacionNueva(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(instalacionNuevaService.findInstalacion(id), HttpStatus.OK);
    }

    @PostMapping("/instalaciones-nuevas/post")
    public ResponseEntity<?> create(@RequestBody Map<String, Object> body) {
        InstalacionNueva instalacionNueva = new InstalacionNueva();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        instalacionNueva.setNombreCompleto(body.get("nombreCompleto").toString());
        instalacionNueva.setIdentificacion(body.get("identificacion").toString());
        instalacionNueva.setNit(body.get("nit").toString());
        instalacionNueva.setPlan((int) body.get("plan"));
        instalacionNueva.setZona((int) body.get("zona"));
        instalacionNueva.setCorreoElectronico(body.get("correoElectronico").toString());
        instalacionNueva.setMovil(body.get("movil").toString());
        instalacionNueva.setDireccionServicio(body.get("direccionServicio").toString());
        instalacionNueva.setNotas(body.get("notas").toString());
        instalacionNueva.setFotoIdentificacion(body.get("fotoIdentificacion").toString());
        instalacionNueva.setTecnico((int) body.get("tecnico"));
        instalacionNueva.setEstado(body.get("estado").toString());
        try {
            instalacionNueva.setFechaInstalacion(format.parse(body.get("fechaInstalacion").toString()));
            instalacionNueva.setFechaVisita(format.parse(body.get("fechaVisita").toString()));
        } catch (java.text.ParseException e) {
            throw new ParseException(e.getMessage());
        }
        return new ResponseEntity<>(instalacionNuevaService.save(instalacionNueva), HttpStatus.CREATED);
    }

    @PutMapping("/instalaciones-nuevas/put")
    public ResponseEntity<?> changeStatus(@RequestBody Map<String, Object> body) {
        InstalacionNueva instalacionNueva = null;

        instalacionNueva = instalacionNuevaService.findInstalacion((int) body.get("id"));
        instalacionNueva.setEstado(body.get("estado").toString());

        return new ResponseEntity<>(instalacionNuevaService.save(instalacionNueva), HttpStatus.CREATED);
    }
}
