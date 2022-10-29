package xyz.pangosoft.ispendpoints.service;

import xyz.pangosoft.ispendpoints.model.Usuario;

import java.util.List;
import java.util.Map;

public interface IUsuarioService {

    public List<Usuario> getUsuarios();

    public Usuario getUsuario(Integer id);

    public Usuario save(Usuario usuario);

    public List<Map<String, Object>> usuariosconzona();

    public void delete();
}
