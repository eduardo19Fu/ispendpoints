package xyz.pangosoft.ispendpoints.service;

import xyz.pangosoft.ispendpoints.model.Perfil;

import java.util.List;

public interface IPerfilService {

    public List<Perfil> findAll();

    public Perfil findPerfil(Integer id);

    public Perfil save(Perfil perfil);
}
