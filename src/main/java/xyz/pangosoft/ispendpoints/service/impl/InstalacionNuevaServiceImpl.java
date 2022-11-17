package xyz.pangosoft.ispendpoints.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.pangosoft.ispendpoints.exception.exceptions.DataAccessException;
import xyz.pangosoft.ispendpoints.exception.exceptions.NoSuchElementException;
import xyz.pangosoft.ispendpoints.exception.exceptions.NotFoundException;
import xyz.pangosoft.ispendpoints.exception.exceptions.SQLException;
import xyz.pangosoft.ispendpoints.model.InstalacionNueva;
import xyz.pangosoft.ispendpoints.repository.IInstalacionNuevaRepository;
import xyz.pangosoft.ispendpoints.service.IInstalacionNuevaService;

import java.util.List;
import java.util.Map;

@Service
public class InstalacionNuevaServiceImpl implements IInstalacionNuevaService {

    @Autowired
    private IInstalacionNuevaRepository instalacionNuevaRepository;

    @Override
    public List<InstalacionNueva> findAll() {
        try {
            if (!instalacionNuevaRepository.findAll().isEmpty()) {
                return instalacionNuevaRepository.findAll();
            } else {
                throw new NoSuchElementException("No existen elementos en la base de datos.");
            }
        } catch(DataAccessException e) {
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public List<Map<String, Object>> findAll2() {
        try {
            if (!instalacionNuevaRepository.findAllInstalacionesNuevas().isEmpty()) {
                return instalacionNuevaRepository.findAllInstalacionesNuevas();
            } else {
                throw new NoSuchElementException("No existen elementos en la base de datos.");
            }
        } catch(DataAccessException e) {
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public List<Map<String, Object>> findAllByEstado(String estado, int idtecnico) {
        try {
            if (!instalacionNuevaRepository.findAllByEstado(estado, idtecnico).isEmpty()) {
                return instalacionNuevaRepository.findAllByEstado(estado, idtecnico);
            } else {
                throw new NoSuchElementException("No existen elementos en la base de datos.");
            }
        } catch(DataAccessException e) {
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public InstalacionNueva findInstalacion(Integer id) {
        try {
            if (instalacionNuevaRepository.findById(id).isPresent()) {
                return instalacionNuevaRepository.findById(id).get();
            } else {
                throw new NotFoundException("No existe el registro con ID: ".concat(id.toString()));
            }
        } catch(DataAccessException e) {
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public InstalacionNueva save(InstalacionNueva instalacionNueva) {
        try {
            return instalacionNuevaRepository.save(instalacionNueva);
        } catch(DataAccessException e) {
            throw new DataAccessException(e.getMessage());
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            instalacionNuevaRepository.deleteById(id);
        } catch(DataAccessException e) {
            throw new DataAccessException(e.getMessage());
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
}
