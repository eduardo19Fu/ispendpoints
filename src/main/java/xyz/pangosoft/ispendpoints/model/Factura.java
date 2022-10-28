package xyz.pangosoft.ispendpoints.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "factura_electronica_guatemala")
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer idcliente;
    private Integer idfactura;
    private Double iva;
    private Double total;
    private String uuid;
    private String nit;
    private String razon;
    private String nfactura;
    private String data;
    private String api;
    private String nfacturaCredito;
    private String dataCredito;
    private boolean sandbox;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private static final long serialVersionUID = 1L;
}
