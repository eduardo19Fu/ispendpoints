package xyz.pangosoft.ispendpoints.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.pangosoft.ispendpoints.model.Usuario;
import xyz.pangosoft.ispendpoints.service.IUsuarioService;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api")
public class UsuarioApiController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/usuarios/get")
    public ResponseEntity<?> getUsuarios() {
        return new ResponseEntity<>(usuarioService.usuariosconzona(), HttpStatus.OK);
    }

    @GetMapping("/usuarios/zona/get")
    public ResponseEntity<?> getUsuariosConZona() {
        return new ResponseEntity<>(usuarioService.usuariosconzona(), HttpStatus.OK);
    }

    @GetMapping("/usuarios/get/{id}")
    public ResponseEntity<?> getUsuario(@PathVariable Integer id) {
        return new ResponseEntity<>(usuarioService.getUsuario(id), HttpStatus.OK);
    }

    @PostMapping("/usuarios/post")
    public ResponseEntity<?> create(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
    }

    @PutMapping("/usuarios/put")
    public ResponseEntity<?> update(@RequestBody Usuario usuario) {
        return null;
    }
}
