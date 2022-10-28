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
@Table(name = "ticket")
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idticket;
    private String contenido;
    private String adjunto;
    private Integer idtecnico;
    private int state;
    private int nota;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;

    private static final long serialVersionUID = 1L;
}
