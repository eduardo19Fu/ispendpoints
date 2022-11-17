package xyz.pangosoft.ispendpoints.service;

import xyz.pangosoft.ispendpoints.model.InstalacionNueva;

import java.util.List;
import java.util.Map;

public interface IInstalacionNuevaService {

    public List<InstalacionNueva> findAll();

    public List<Map<String, Object>> findAll2();

    public List<Map<String, Object>> findAllByEstado(String estado);

    public InstalacionNueva findInstalacion(Integer id);

    public InstalacionNueva save(InstalacionNueva instalacionNueva);

    public void delete(Integer id);
}
