package xyz.pangosoft.ispendpoints.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.pangosoft.ispendpoints.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
}
