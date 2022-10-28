package xyz.pangosoft.ispendpoints.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String estado;
    private String correo;
    private String telefono;
    private String movil;
    private String cedula;
    private String pasarela;
    private String codigo;
    private String direccionPrincipal;
    private String nit;

    private final static long serialVersionUID = 1L;
}
