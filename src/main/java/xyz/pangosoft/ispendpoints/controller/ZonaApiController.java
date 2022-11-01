package xyz.pangosoft.ispendpoints.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.pangosoft.ispendpoints.service.IZonaService;

@CrossOrigin(value = {"*"})
@RestController
@RequestMapping("/api")
public class ZonaApiController {

    @Autowired
    private IZonaService zonaService;

    @GetMapping("/zonas")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(zonaService.findAll(), HttpStatus.OK);
    }
}
