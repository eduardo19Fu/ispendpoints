package xyz.pangosoft.ispendpoints.service;

import xyz.pangosoft.ispendpoints.model.Usuario;

import java.util.List;

public interface IUsuarioService {

    public List<Usuario> getUsuarios();

    public Usuario getUsuario(Integer id);

    public Usuario save(Usuario usuario);

    public void delete();
}
