package xyz.pangosoft.ispendpoints.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.pangosoft.ispendpoints.exception.exceptions.DataAccessException;
import xyz.pangosoft.ispendpoints.exception.exceptions.NoSuchElementException;
import xyz.pangosoft.ispendpoints.model.Zona;
import xyz.pangosoft.ispendpoints.repository.IZonaRepository;
import xyz.pangosoft.ispendpoints.service.IZonaService;

import java.util.List;

@Service
public class ZonaServiceImpl implements IZonaService {

    @Autowired
    private IZonaRepository zonaRepository;

    @Override
    public List<Zona> findAll() {
        try {
            if (zonaRepository.findAll().size() > 0) {
                return zonaRepository.findAll();
            } else {
                throw new NoSuchElementException("No existen registros en la base de datos.");
            }
        } catch(DataAccessException e) {
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Zona findZona(Integer id) {
        return null;
    }

    @Override
    public Zona save(Zona zona) {
        return null;
    }
}
