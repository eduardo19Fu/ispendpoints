package xyz.pangosoft.ispendpoints.service;

import xyz.pangosoft.ispendpoints.model.Factura;

import java.util.List;
import java.util.Map;

public interface IFacturaService {

    public List<Factura> findAll();

    public Factura findFactura(Long id);

    public Factura save(Map<String, Object> datosFactura);

}
