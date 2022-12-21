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
import xyz.pangosoft.ispendpoints.model.AppMovilUsuario;
import xyz.pangosoft.ispendpoints.service.IAppMovilUsuarioService;

@CrossOrigin(value = {"*"})
@RestController
@RequestMapping("/api")
public class AppMovilUsuarioApiController {

    @Autowired
    private IAppMovilUsuarioService usuarioService;

    @GetMapping("/login/users/get")
    public ResponseEntity<?> getLoginUsuarios() {
        return new ResponseEntity<>(usuarioService.findUsuarios(), HttpStatus.OK);
    }

    @GetMapping("/login/users/get/{id}")
    public ResponseEntity<?> getLoginUsuario(@PathVariable Integer id) {
        return new ResponseEntity<>(usuarioService.findUsuario(id), HttpStatus.OK);
    }

    @GetMapping("/login/users/user/get/{username}")
    public ResponseEntity<?> getLoginUsuarioByName(@PathVariable String username) {
        return new ResponseEntity<>(usuarioService.findUsuarioByUsername(username), HttpStatus.OK);
    }

    @PostMapping("/login/users/post")
    public ResponseEntity<?> createUser(@RequestBody AppMovilUsuario user) {
        return new ResponseEntity<>(usuarioService.save(user), HttpStatus.CREATED);
    }

    @PutMapping("/login/users/put")
    public ResponseEntity<?> updateUser(@RequestBody AppMovilUsuario user) {
        return new ResponseEntity<>(usuarioService.save(user), HttpStatus.CREATED);
    }
}
