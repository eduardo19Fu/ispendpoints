package xyz.pangosoft.ispendpoints.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "instalaciones")
public class Instalacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userid;
    private Date fechaIngreso;
    private Date fechaSalida;
    private int idtecnico;
    private String direccion;
    private String telefono;
    private String movil;
    private int idnodo = 0;
    private String email;
    private String cedula;
    private String estate;
    private String cliente;
    private String notas;
    private Date fechaInstalacion;
    private int zona;
    private int idvendedor;
    private int tipoEstrato = 1;
    private String planSolicitado;
    private String nitCliente;
    private String tecnicoInstalacion;
    private String infoAdicional;

    private static final long serialVersionUID = 1L;
}
