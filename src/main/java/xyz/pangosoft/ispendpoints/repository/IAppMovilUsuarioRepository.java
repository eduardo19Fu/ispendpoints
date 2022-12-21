package xyz.pangosoft.ispendpoints.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import xyz.pangosoft.ispendpoints.model.AppMovilRole;
import xyz.pangosoft.ispendpoints.model.AppMovilUsuario;

import java.util.List;
import java.util.Optional;

public interface IAppMovilUsuarioRepository extends JpaRepository<AppMovilUsuario, Integer> {

    Optional<AppMovilUsuario> findByUsername(String username);

    @Query(value = "Select r from AppMovilRole r")
    List<AppMovilRole> findAllRoles();
}
