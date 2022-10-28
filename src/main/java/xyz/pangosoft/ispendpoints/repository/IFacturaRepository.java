package xyz.pangosoft.ispendpoints.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.pangosoft.ispendpoints.model.Factura;

public interface IFacturaRepository extends JpaRepository<Factura, Long> {
}
