package xyz.pangosoft.ispendpoints.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "instalaciones_nuevas")
public class InstalacionNueva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombreCompleto;
    private String identificacion;
    private String nit;
    private int idplan;
    private int idzona;
    private String correoElectronico;
    private String movil;
    private String direccionServicio;
    private String notas;
    private String fotoIdentificacion;
    private int idtecnico;
    private Integer idvendedor;
    private String estado;
    private String prioridad;
    private boolean siPago;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Temporal(TemporalType.DATE)
    private Date fechaInstalacion;

    @Temporal(TemporalType.DATE)
    private Date fechaVisita;

    @PrePersist
    public void prepersist() {
        this.fechaRegistro = new Date();
    }

    private final static long serialVersionUID = 1L;
}
