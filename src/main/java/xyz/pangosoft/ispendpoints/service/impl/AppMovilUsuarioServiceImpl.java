package xyz.pangosoft.ispendpoints.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.pangosoft.ispendpoints.exception.exceptions.DataAccessException;
import xyz.pangosoft.ispendpoints.exception.exceptions.NoSuchElementException;
import xyz.pangosoft.ispendpoints.exception.exceptions.NotFoundException;
import xyz.pangosoft.ispendpoints.exception.exceptions.SQLException;
import xyz.pangosoft.ispendpoints.model.AppMovilUsuario;
import xyz.pangosoft.ispendpoints.repository.IAppMovilUsuarioRepository;
import xyz.pangosoft.ispendpoints.repository.IUsuarioRepository;
import xyz.pangosoft.ispendpoints.service.IAppMovilUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppMovilUsuarioServiceImpl implements UserDetailsService, IAppMovilUsuarioService {

    private Logger logger = LoggerFactory.getLogger(AppMovilUsuarioServiceImpl.class);

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private IAppMovilUsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppMovilUsuario usuario = usuarioRepository.findByUsername(username).get();

        if (usuario == null) {
            logger.error("Error: no existe el usuario en el sistema.");
            throw new UsernameNotFoundException("Error: no existe el usuario en el sistema.");
        }

        List<GrantedAuthority> authorities = usuario.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole()))
                .peek(authority -> logger.info("Role: " + authority.getAuthority()))
                .collect(Collectors.toList());

        return new User(usuario.getUsername(), usuario.getPassword(), usuario.isEnabled(), true, true, true, authorities);
    }

    @Override
    public List<AppMovilUsuario> findUsuarios() {
        try {
            if (usuarioRepository.findAll().size() > 0) {
                return usuarioRepository.findAll();
            } else {
                throw new NoSuchElementException("No existen usuarios relacionados.");
            }
        } catch(DataAccessException e) {
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public AppMovilUsuario findUsuario(Integer id) {
        try {
            if (usuarioRepository.findById(id).isPresent()) {
                return usuarioRepository.findById(id).get();
            } else {
                throw new NotFoundException("No existe el usaurio con el ID: " + id.toString());
            }
        } catch(DataAccessException e) {
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public AppMovilUsuario findUsuarioByUsername(String username) {
        try {
            if (usuarioRepository.findByUsername(username).isPresent()) {
                return usuarioRepository.findByUsername(username).get();
            } else {
                logger.error("Usuario {} no encontrado", username);
                throw new NotFoundException("Usuario " + username + " no existe en la base de datos.");
            }
        } catch(DataAccessException e) {
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public AppMovilUsuario save(AppMovilUsuario usuario) {
        try {
            if(usuario.getId() == null) {
                usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
                return usuarioRepository.save(usuario);
            } else {
                AppMovilUsuario usuarioActual = findUsuario(usuario.getId());

                usuarioActual.setNombre(usuario.getNombre());
                usuarioActual.setUsername(usuario.getUsername());
                usuarioActual.setFechaRegistro(usuario.getFechaRegistro());

                if(usuario.isFirstLogin()) {
                    usuarioActual.setFirstLogin(true);
                } else {
                    usuarioActual.setFirstLogin(false);
                }

                if (usuario.getPassword() != null || (!usuarioActual.getPassword().equals(usuario.getPassword()))) {
                    usuarioActual.setPassword(passwordEncoder.encode(usuario.getPassword()));
                    return usuarioRepository.save(usuarioActual);
                } else {
                    usuarioActual.setPassword(usuario.getPassword());
                    return usuarioRepository.save(usuarioActual);
                }
            }
        } catch(DataAccessException e) {
            logger.error("Error DataAccess => " + e.getStackTrace());
            throw new DataAccessException(e.getMessage());
        } catch (SQLException e) {
            logger.error("Error SQL => " + e.getStackTrace());
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public AppMovilUsuario delete(AppMovilUsuario id) {
        return null;
    }
}
