package xyz.pangosoft.ispendpoints.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.pangosoft.ispendpoints.service.IPerfilService;

@CrossOrigin(value = {"*"})
@RestController
@RequestMapping("/api")
public class PerfilApiController {

    @Autowired
    private IPerfilService perfilService;

    @GetMapping("/perfiles")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(perfilService.findAll(), HttpStatus.OK);
    }
}
