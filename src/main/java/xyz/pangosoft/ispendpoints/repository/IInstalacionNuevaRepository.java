package xyz.pangosoft.ispendpoints.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import xyz.pangosoft.ispendpoints.model.InstalacionNueva;

import java.util.List;
import java.util.Map;

public interface IInstalacionNuevaRepository extends JpaRepository<InstalacionNueva, Integer> {

    @Query(value =  "select insn.*, lg.nombre as tecnico, z.zona\n, per.plan\n" +
                    "from instalaciones_nuevas as insn\n" +
                    "left join login as lg on lg.id = insn.idtecnico\n" +
                    "left join zonas as z on z.id = insn.idzona\n" +
                    "left join perfiles as per on per.id = insn.idplan\n" +
                    "where insn.estado = 'pendiente'",
            nativeQuery = true)
    List<Map<String, Object>> findAllInstalacionesNuevas();

    @Query(value =  "Select insn.*, lg.nombre as tecnico, z.zona\n, per.plan\n" +
                    "from instalaciones_nuevas as insn\n" +
                    "left join login as lg on lg.id = insn.idtecnico\n" +
                    "left join zonas as z on z.id = insn.idzona\n" +
                    "left join perfiles as per on per.id = insn.idplan\n" +
                    "where insn.estado = :estado and insn.idtecnico = :idtecnico", nativeQuery = true)
    List<Map<String, Object>> findAllByEstado(@Param("estado") String estado, @Param("idtecnico") int idtecnico);

    @Query(value =  "Select insn.*, lg.nombre as tecnico, z.zona\n, per.plan\n" +
                    "from instalaciones_nuevas as insn\n" +
                    "left join login as lg on lg.id = insn.idtecnico\n" +
                    "left join zonas as z on z.id = insn.idzona\n" +
                    "left join perfiles as per on per.id = insn.idplan\n" +
                    "where insn.estado in ('INSTALADO', 'NO INSTALADO') and insn.idtecnico = :idtecnico", nativeQuery = true)
    List<Map<String, Object>> findInstaladasNoInstaladas(@Param("idtecnico") int idtecnico);
}
