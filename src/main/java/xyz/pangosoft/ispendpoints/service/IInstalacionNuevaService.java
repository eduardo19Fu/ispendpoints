package xyz.pangosoft.ispendpoints.service;

import xyz.pangosoft.ispendpoints.model.InstalacionNueva;

import java.util.List;

public interface IInstalacionNuevaService {

    public List<InstalacionNueva> findAll();

    public InstalacionNueva findInstalacion(Integer id);

    public InstalacionNueva save(InstalacionNueva instalacionNueva);

    public void delete(Integer id);
}
