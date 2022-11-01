package xyz.pangosoft.ispendpoints.service;

import xyz.pangosoft.ispendpoints.model.Zona;

import java.util.List;

public interface IZonaService {

    public List<Zona> findAll();

    public Zona findZona(Integer id);

    public Zona save(Zona zona);
}
