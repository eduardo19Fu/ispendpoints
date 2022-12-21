package xyz.pangosoft.ispendpoints.service;

import xyz.pangosoft.ispendpoints.model.AppMovilUsuario;

import java.util.List;

public interface IAppMovilUsuarioService {

    public List<AppMovilUsuario> findUsuarios();

    public AppMovilUsuario findUsuario(Integer id);

    public AppMovilUsuario findUsuarioByUsername(String username);

    public AppMovilUsuario save(AppMovilUsuario usuario);

    public AppMovilUsuario delete(AppMovilUsuario id);
}
