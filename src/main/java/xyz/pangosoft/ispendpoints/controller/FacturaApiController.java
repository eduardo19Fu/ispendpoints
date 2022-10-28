package xyz.pangosoft.ispendpoints.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.pangosoft.ispendpoints.model.Factura;
import xyz.pangosoft.ispendpoints.service.IFacturaService;

import java.util.Map;

@CrossOrigin(value = {"*"})
@RestController
@RequestMapping("/api")
public class FacturaApiController {

    @Autowired
    private IFacturaService facturaService;

    @GetMapping("/facturas/get")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(facturaService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/facturas/nit/put")
    public ResponseEntity<?> update(@RequestBody Map<String, Object> datosFactura) {
        return new ResponseEntity<>(facturaService.save(datosFactura), HttpStatus.OK);
    }
}
