package xyz.pangosoft.ispendpoints.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import xyz.pangosoft.ispendpoints.exception.exceptions.DataAccessException;
import xyz.pangosoft.ispendpoints.exception.exceptions.NoSuchElementException;
import xyz.pangosoft.ispendpoints.exception.exceptions.NotFoundException;
import xyz.pangosoft.ispendpoints.exception.exceptions.NumberFormatException;
import xyz.pangosoft.ispendpoints.exception.exceptions.SQLException;
import xyz.pangosoft.ispendpoints.model.Factura;
import xyz.pangosoft.ispendpoints.repository.IFacturaRepository;
import xyz.pangosoft.ispendpoints.service.IFacturaService;

import java.util.List;
import java.util.Map;

@Service
public class FacturaServiceImpl implements IFacturaService {

    @Autowired
    private IFacturaRepository facturaRepository;

    @Override
    public List<Factura> findAll() {
        try {
            if (facturaRepository.findAll().size() > 0) {
                return facturaRepository.findAll();
            } else {
                throw new NoSuchElementException("No se encuentra ningún registro relacionado con \"Facturas\"");
            }
        } catch(DataAccessException e) {
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Factura findFactura(Long id) {
        try {
            if (facturaRepository.findById(id).isPresent()) {
                facturaRepository.findById(id).get();
            } else {
                throw new NotFoundException("No se encuentra la factura con ID: \"" + id.toString() + "\"");
            }
        } catch (DataAccessException e) {}
        return null;
    }

    @Override
    public Factura save(Map<String, Object> datosFactura) {
        try {
            long idfactura = Integer.parseInt(datosFactura.get("id").toString());
            String nuevoNit = datosFactura.get("nit").toString();

            Factura factura = null;
            factura = facturaRepository.findById(idfactura).orElse(null);
            factura.setNit(nuevoNit);
            if (factura != null) {
                return facturaRepository.save(factura);
            } else {
                throw new NotFoundException("No existe la factura que desea actualizar");
            }
        } catch (DataAccessException e) {
            throw new DataAccessException(e.getMessage());
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Error al realizar conversión de tipos.");
        }
    }
}
