package xyz.pangosoft.ispendpoints.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.pangosoft.ispendpoints.exception.exceptions.DataAccessException;
import xyz.pangosoft.ispendpoints.exception.exceptions.NoSuchElementException;
import xyz.pangosoft.ispendpoints.exception.exceptions.NotFoundException;
import xyz.pangosoft.ispendpoints.exception.exceptions.SQLException;
import xyz.pangosoft.ispendpoints.model.Usuario;
import xyz.pangosoft.ispendpoints.repository.ITblavisouserRepository;
import xyz.pangosoft.ispendpoints.repository.IUsuarioRepository;
import xyz.pangosoft.ispendpoints.service.IUsuarioService;

import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

//    @Autowired
//    private ITblavisouserRepository tblavisouserRepository;

    @Override
    public List<Usuario> getUsuarios() {
        try {
            if (usuarioRepository.findAll().size() > 0) {
                return usuarioRepository.findAll();
            } else {
                throw new NoSuchElementException("No existen usuarios registrados");
            }
        } catch(DataAccessException e) {
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Usuario getUsuario(Integer id) {
        try {
            if (usuarioRepository.findById(id).isPresent()) {
                return usuarioRepository.findById(id).get();
            } else {
                throw new NotFoundException("No existe el usuario buscado.");
            }
        } catch (DataAccessException e) {
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Usuario save(Usuario usuario) {
        try {
            return usuarioRepository.save(usuario);
        } catch(DataAccessException e) {
            throw new DataAccessException(e.getMessage());
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public List<Map<String, Object>> usuariosconzona() {
        try {
            if (usuarioRepository.resultado().size() > 0) {
                return usuarioRepository.resultado();
            } else {
                throw new NoSuchElementException("No existen usuarios registrados");
            }
        } catch(DataAccessException e) {
            throw new DataAccessException(e.getMessage());
        } catch(SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public void delete() {

    }
}
