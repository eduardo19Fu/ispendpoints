package xyz.pangosoft.ispendpoints.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.pangosoft.ispendpoints.exception.exceptions.DataAccessException;
import xyz.pangosoft.ispendpoints.exception.exceptions.NoSuchElementException;
import xyz.pangosoft.ispendpoints.model.Perfil;
import xyz.pangosoft.ispendpoints.repository.IPerfilRepository;
import xyz.pangosoft.ispendpoints.service.IPerfilService;

import java.util.List;

@Service
public class PerfilServiceImpl implements IPerfilService {

    @Autowired
    private IPerfilRepository perfilRepository;

    @Override
    public List<Perfil> findAll() {
        try {
            if (perfilRepository.findAll().size() > 0) {
                return perfilRepository.findAll();
            } else {
                throw new NoSuchElementException("No existen elementos en la base de datos.");
            }
        } catch (DataAccessException e) {
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Perfil findPerfil(Integer id) {
        return null;
    }

    @Override
    public Perfil save(Perfil perfil) {
        return null;
    }
}
