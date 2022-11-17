package xyz.pangosoft.ispendpoints.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import xyz.pangosoft.ispendpoints.model.InstalacionNueva;

import java.util.List;
import java.util.Map;

public interface IInstalacionNuevaRepository extends JpaRepository<InstalacionNueva, Integer> {

    @Query(value =  "select insn.*, lg.nombre as tecnico\n" +
                    "from instalaciones_nuevas as insn\n" +
                    "left join login as lg on lg.id = insn.idtecnico\n" +
                    "where insn.estado = 'pendiente'",
            nativeQuery = true)
    List<Map<String, Object>> findAllInstalacionesNuevas();

    @Query(value = "Select * from instalaciones_nuevas where estado = :estado and idtecnico = :idtecnico", nativeQuery = true)
    List<Map<String, Object>> findAllByEstado(@Param("estado") String estado, @Param("idtecnico") int idtecnico);
}
