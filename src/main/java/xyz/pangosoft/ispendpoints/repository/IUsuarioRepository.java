package xyz.pangosoft.ispendpoints.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import xyz.pangosoft.ispendpoints.model.Usuario;

import java.util.List;
import java.util.Map;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value = "SELECT u.*, z.zona\n" +
            "FROM usuarios as u\n" +
            "INNER JOIN tblavisouser AS tau ON tau.cliente = u.id\n" +
            "INNER JOIN zonas AS z ON z.id = tau.zona", nativeQuery = true)
    List<Map<String, Object>> resultado();
}
