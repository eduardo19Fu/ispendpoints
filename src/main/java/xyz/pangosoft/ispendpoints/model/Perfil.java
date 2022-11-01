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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "perfiles")
public class Perfil implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String plan;
    private String descripcion;
    private String velocidad;
    private String pcq;
    private String prioridad;
    private double costo;
    private String profile;
    private String lista;
    private int limitat;
    private int burstLimit;
    private int burstThreshold;
    private int burstTime;
    private double impuesto;
    private int api;
    private String idMikrotik;
    private String limitDown;
    private String limitUp;
    private String parent;
    private int reuso;
    private int isDisabled;

    private static final long serialVersionUID = 1L;
}
