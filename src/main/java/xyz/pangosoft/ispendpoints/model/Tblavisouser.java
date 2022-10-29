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

// @Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
// @Table(name = "tblavisouser")
public class Tblavisouser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String mora;
    private String reconexion;
    private String impuesto;
    private byte[] avatarCliente;
    private int chat;
    private int zona;
    private int diapago;
    private int tipopago;
    private int tipoaviso;
    private int meses;
    private Date fechaFactura;
    private int diafactura;
    private int avisopantalla;
    private int corteautomatico;


    private static final long serialVersionUID = 1L;
}
